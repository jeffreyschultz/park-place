package com.forrent.parkplace.service.google;

import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;

/**
 */
public interface GoogleMapsGeocodeService {
    GeocodingResult[] geocode(String address) throws InterruptedException, ApiException, IOException;
}
