package com.forrent.parkplace.web.mvc.controller;

import com.forrent.parkplace.service.parks.Park;
import com.forrent.parkplace.service.parks.ParkService;
import com.google.maps.model.LatLng;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parks")
public class ParksController {

    private ParkService parkService;

    public void setParkService(ParkService parkService) {
        this.parkService = parkService;
    }

    @RequestMapping
    public List<Park> getParks() {
        return parkService.findParks(new LatLng(37.069, -76.487));
    }

    @RequestMapping(value = "/test")
    public String test() {
        return DateTime.now().toString();
    }
}
