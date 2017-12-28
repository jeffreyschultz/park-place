package com.forrent.parkplace.service.parks;

import com.forrent.parkplace.support.Coord;
import com.google.maps.model.LatLng;

import java.util.List;

public interface ParkProvider {

    /**
     * @param coord
     * @return
     */
    List<Park> findParks(Coord coord);
}
