package com.forrent.parkplace.service.google;

import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResponse;

import java.io.IOException;

/**
 * Service interface for the Google Maps Places API.
 */
public interface GoogleMapsPlacesService {

    /**
     * Returns a response containing a list of parks near the specified location.
     *
     * @param location
     * @return
     * @throws InterruptedException
     * @throws ApiException
     * @throws IOException
     */
    PlacesSearchResponse findParksNearBy(LatLng location) throws InterruptedException, ApiException, IOException;
}
