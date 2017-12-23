package com.forrent.parkplace.service.google;

import com.forrent.parkplace.util.Distances;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;

import java.io.IOException;

public class DefaultGoogleMapsPlacesService extends GoogleMapsClient implements GoogleMapsPlacesService {

    protected DefaultGoogleMapsPlacesService(GeoApiContext geoApiContext) {
        super(geoApiContext);
    }

    @Override
    public PlacesSearchResponse findParksNearBy(LatLng location) throws InterruptedException, ApiException, IOException {

        GeoApiContext ctx = getGeoApiContext();

        PlacesSearchResponse response = PlacesApi.nearbySearchQuery(ctx, location)
                .radius(Distances.MilesToMeters(10))
                //.rankby(RankBy.DISTANCE)
                .type(PlaceType.PARK)
                .await();

        return response;
    }
}
