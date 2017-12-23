package com.forrent.parkplace.service.google;

import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResponse;

import java.io.IOException;

public interface GoogleMapsPlacesService {
    PlacesSearchResponse findParksNearBy(LatLng location) throws InterruptedException, ApiException, IOException;
}
