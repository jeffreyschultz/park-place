package com.forrent.parkplace.service.google;

import com.forrent.parkplace.util.Distances;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;

import java.io.IOException;

/**
 * Default implementation of the Google Maps Places API service.
 */
public class GoogleMapsPlacesServiceImpl extends GoogleMapsClient implements GoogleMapsPlacesService {

    protected GoogleMapsPlacesServiceImpl(GeoApiContext geoApiContext) {
        super(geoApiContext);
    }

    /**
     * Returns a response containing a list of parks near the specified location using the Google Maps Places API.
     *
     * @param location
     * @return
     * @throws InterruptedException
     * @throws ApiException
     * @throws IOException
     */
    @Override
    public PlacesSearchResponse findParksNearBy(LatLng location) throws InterruptedException, ApiException, IOException {

        GeoApiContext ctx = getGeoApiContext();

        double tenMiles = Math.round(Distances.milesToMeters(10));

        PlacesSearchResponse response = PlacesApi.nearbySearchQuery(ctx, location)
                .radius((int) Math.round(tenMiles))
                .type(PlaceType.PARK)
                .await();

        return response;
    }
}
