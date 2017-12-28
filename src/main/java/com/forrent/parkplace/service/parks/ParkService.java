package com.forrent.parkplace.service.parks;

import com.forrent.parkplace.support.Coord;
import com.google.maps.model.LatLng;

import java.util.List;

/**
 * Service interface for the Park Service subsystem.
 */
public interface ParkService {

    /**
     * Returns a list of Park instances that are near the specified coordinate.
     *
     * @param coord
     * @return
     */
    List<Park> findParks(Coord coord);
}
