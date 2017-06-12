/*
 * Copyright 2016 the original author or authors.
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

package demo.rest;

import demo.domain.Location;
import demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RunningServiceController {

    private LocationService locationService;

    @Autowired
    public RunningServiceController(LocationService locationService) {
        this.locationService = locationService;

    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Location> locations) {
        this.locationService.saveRunningLocations(locations);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.POST)
    public void purge() {
        this.locationService.deleteAll();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Page<Location> findALLUserId(@RequestParam(name = "page", required=false) int page,
                                          @RequestParam(name = "size",required=false) int size) {

        return this.locationService.findAllUserId(new PageRequest(page, size));
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public Page<Location> user(@PathVariable Long userId,
                                          @RequestParam(name = "page", required=false) int page,
                                          @RequestParam(name = "size",required=false) int size) {
        return this.locationService.findByUserId(userId, new PageRequest(page, size));
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable Long userId) {
        this.locationService.deleteItem(userId);
    }

    @RequestMapping(value = "/users/heart", method = RequestMethod.GET)
    public Page<Location> sortByHearstRrate(@RequestParam(name = "page") int page,
                                          @RequestParam(name = "size") int size) {
        return this.locationService.sortByHeartRate(new PageRequest(page, size));
    }
}
