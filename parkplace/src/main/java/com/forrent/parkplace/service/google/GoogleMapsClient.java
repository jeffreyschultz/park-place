package com.forrent.parkplace.service.google;

import com.google.maps.GeoApiContext;

/**
 * Base class for all Google Maps API clients.
 */
public abstract class GoogleMapsClient {

    private GeoApiContext geoApiContext;

    protected GoogleMapsClient(GeoApiContext geoApiContext) {
        if (geoApiContext == null) {
            throw new IllegalArgumentException("GeoApiContext cannot be null.");
        }

        this.geoApiContext = geoApiContext;
    }

    /**
     * Gets the GeoApiContext to be used by this GoogleMapsClient.
     *
     * @return
     */
    protected GeoApiContext getGeoApiContext() {
        if (geoApiContext == null) {
            throw new IllegalStateException("GeoApiContext cannot be null.");
        }
        return geoApiContext;
    }
}
