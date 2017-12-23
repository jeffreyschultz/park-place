package com.forrent.parkplace.service.parks;

import com.google.maps.model.LatLng;

import java.util.List;

public interface ParkProvider {

    /**
     * @param location
     * @return
     */
    List<Park> findParks(LatLng location);
}
