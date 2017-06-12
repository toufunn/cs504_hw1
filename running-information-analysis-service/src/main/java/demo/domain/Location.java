/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue
    private Long userId;
    private String runningId;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "userName")),
            @AttributeOverride(name = "address", column = @Column(name = "userAddress"))})
    private final UserInfo userInfo;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;

    private Date timestamp = new Date();
    private String healthWarningLevel;

    private int heartRate = 0;

    public String setHealthWarningLevel (int rate) {
        if (rate >=60 && rate <=75) return "LOW";
        if (rate >75 && rate <=120) return "NORMAL";
        if (rate >120) return "HIGH";
        return "UNKOWN";
    }
    public Location() {
        this.userInfo = null;
        this.runningId = null;
    }

    private int heartsRate = 0;

    @JsonCreator
    public Location(@JsonProperty("username") String username,
                    @JsonProperty("address") String address) {
        this.userInfo = new UserInfo(username, address);
        this.heartsRate = (int)(Math.random()*140)+60;
        this.healthWarningLevel = setHealthWarningLevel(this.heartsRate);
    }
    public Location(UserInfo userInfo) {
        this.userInfo = userInfo;
        this.runningId = null;
    }
    public Location(String runningId) {
        this.userInfo = null;
        this.runningId = runningId;
    }
}
