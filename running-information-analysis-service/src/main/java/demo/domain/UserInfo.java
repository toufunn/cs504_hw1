package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
public class UserInfo {
    private String username;
    private String address;
    public UserInfo(String username, String address) {
        this.username = username;
        this.address = address;
    }
    public UserInfo() {
        this.username = "";
        this.address = "";
    }
}
