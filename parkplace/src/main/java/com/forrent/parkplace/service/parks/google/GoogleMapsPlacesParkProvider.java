package com.forrent.parkplace.service.parks.google;

import com.forrent.parkplace.service.google.GoogleMapsPlacesService;
import com.forrent.parkplace.service.parks.Park;
import com.forrent.parkplace.service.parks.ParkProvider;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

import java.util.ArrayList;
import java.util.List;

public class GoogleMapsPlacesParkProvider implements ParkProvider {

    private GoogleMapsPlacesService googleMapsPlacesService;

    public GoogleMapsPlacesParkProvider(GoogleMapsPlacesService googleMapsPlacesService) {
        if (googleMapsPlacesService == null) {
            throw new IllegalArgumentException("GoogleMapsPlacesService must not be null.");
        }

        this.googleMapsPlacesService = googleMapsPlacesService;
    }

    @Override
    public List<Park> findParks(LatLng location) {

        ArrayList<Park> parks = new ArrayList<>();
        try {
            PlacesSearchResponse response = googleMapsPlacesService.findParksNearBy(location);

            if (response != null) {
                for (PlacesSearchResult place : response.results) {
                    Park park = PlaceToParkAdapter.adapt(place);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parks;
    }

}
