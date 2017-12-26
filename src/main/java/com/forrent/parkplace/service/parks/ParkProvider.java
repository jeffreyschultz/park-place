package com.forrent.parkplace.service.parks;

import com.google.maps.model.LatLng;

import java.util.List;

public interface ParkProvider {

    /**
     * @param latLng
     * @return
     */
    List<Park> findParks(LatLng latLng);
}
