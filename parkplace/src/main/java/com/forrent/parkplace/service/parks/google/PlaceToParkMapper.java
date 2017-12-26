package com.forrent.parkplace.service.parks.google;

import com.forrent.parkplace.service.parks.Park;
import com.forrent.parkplace.util.Distances;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResult;

/**
 * Mapper class responsible for converting Google Map Places API's "place" type into an application
 * type that represents parks.
 */
public class PlaceToParkMapper {

    /**
     * Returns a Park instance dervied from a Place type returned from Google Maps Places API.
     *
     * @param latLng
     * @param place
     * @return
     */
    public static Park map(LatLng latLng, PlacesSearchResult place) {
        Park park = new Park();

        park.setName(place.name);

        //
        // Not sure if place.icon would ever be null, so just in case...
        //
        if (place.icon != null) {
            park.setImageUrl(place.icon.toString());
        }

        if (place.geometry != null) {
            park.setGeometry(place.geometry);

            //
            // If the place has a geometry with a location then calculate the distance between the
            // the two points and assign the value to the distance property.
            //
            if (place.geometry.location != null) {
                LatLng latLng2 = place.geometry.location;
                double distance = Distances.distance(
                        latLng.lat,
                        latLng2.lat,
                        latLng.lng,
                        latLng2.lng
                );
                park.setDistance(distance);
            }
        }

        park.setRating(place.rating);

        return park;
    }
}
