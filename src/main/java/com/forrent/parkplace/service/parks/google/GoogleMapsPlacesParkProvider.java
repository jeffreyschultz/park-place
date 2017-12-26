package com.forrent.parkplace.service.parks.google;

import com.forrent.parkplace.service.google.GoogleMapsPlacesService;
import com.forrent.parkplace.service.parks.Park;
import com.forrent.parkplace.service.parks.ParkProvider;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Park provider that uses Google Maps Places API to find parks near a specific location.
 */
public class GoogleMapsPlacesParkProvider implements ParkProvider {

    private GoogleMapsPlacesService googleMapsPlacesService;

    public GoogleMapsPlacesParkProvider(GoogleMapsPlacesService googleMapsPlacesService) {
        if (googleMapsPlacesService == null) {
            throw new IllegalArgumentException("GoogleMapsPlacesService must not be null.");
        }

        this.googleMapsPlacesService = googleMapsPlacesService;
    }

    /**
     * Find parks near the current location.
     *
     * @param latLng
     * @return
     */
    @Override
    public List<Park> findParks(LatLng latLng) {

        ArrayList<Park> parks = new ArrayList<>();
        try {
            PlacesSearchResponse response = googleMapsPlacesService.findParksNearBy(latLng);

            if (response != null) {
                for (PlacesSearchResult place : response.results) {
                    Park park = PlaceToParkMapper.map(latLng, place);

                    parks.add(park);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parks;
    }
}
