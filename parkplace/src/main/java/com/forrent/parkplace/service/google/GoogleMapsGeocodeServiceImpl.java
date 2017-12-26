package com.forrent.parkplace.service.google;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;

/**
 * Default implementation of the Google Maps Geocode API service.
 */
public class GoogleMapsGeocodeServiceImpl extends GoogleMapsClient implements GoogleMapsGeocodeService {

    protected GoogleMapsGeocodeServiceImpl(GeoApiContext geoApiContext) {
        super(geoApiContext);
    }

    /**
     * Geocodes an address and returns a location.
     *
     * @param address
     * @return
     * @throws InterruptedException
     * @throws ApiException
     * @throws IOException
     */
    @Override
    public GeocodingResult[] geocode(String address) throws InterruptedException, ApiException, IOException {
        GeoApiContext ctx = getGeoApiContext();

        return GeocodingApi.geocode(ctx, address).await();
    }
}
