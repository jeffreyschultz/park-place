package com.forrent.parkplace.web.mvc.controller;

import com.forrent.parkplace.service.parks.Park;
import com.forrent.parkplace.service.parks.ParkService;
import com.forrent.parkplace.support.Coord;
import com.forrent.parkplace.web.mvc.model.ParkModel;
import com.forrent.parkplace.web.mvc.model.ParkToParkModelMapper;
import com.google.maps.model.LatLng;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The intention of this rest service is that it is a service that is tied directly to a view within the application, and
 * uses the (m)odel defined by the MVC triad for the presentation.
 * <p>
 * This differs from the intention of services that would be placed under the api/rest and api/soap packages, as those
 * would be for external facing consumers, where they could vary depending on requirements. This directly supports the
 * app itself.
 */
@RestController
@RequestMapping("/parks")
public class ParksController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParksController.class);

    private ParkService parkService;

    public void setParkService(ParkService parkService) {
        this.parkService = parkService;
    }

    /**
     * Gets a list of parks near the specific location.
     *
     * @param lat
     * @param lng
     * @return
     */
    @RequestMapping
    public List<ParkModel> getParks(
            //@RequestParam(value = "lat", defaultValue = "37.069")
                    Double lat,
            //@RequestParam(value = "lng", defaultValue = "-76.487")
                    Double lng) {

        LOGGER.info("{lat={},lng={}}", lat, lng);

        List<Park> parks = parkService.findParks(new Coord(lat, lng));

        return ParkToParkModelMapper.map(parks);
    }

    /**
     * Test method that returns the current time.
     *
     * @return
     */
    @RequestMapping(value = "/test")
    public String test() {
        return DateTime.now().toString();
    }
}
