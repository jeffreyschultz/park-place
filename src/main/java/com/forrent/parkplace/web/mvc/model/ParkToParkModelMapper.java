package com.forrent.parkplace.web.mvc.model;

import com.forrent.parkplace.service.parks.Park;
import com.forrent.parkplace.support.Coord;
import com.forrent.parkplace.util.Distances;
import com.google.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper class responsible for converting between the Park data object owned by Park Service subsystem and the
 * UI-specific ParkModel model used by the presentation.
 */
public class ParkToParkModelMapper {

    /**
     * Returns a ParkModel derived a Park instance.
     *
     * @param park
     * @return
     */
    public static ParkModel map(Park park) {
        ParkModel model = new ParkModel();

        model.setName(park.getName());
        model.setImageUrl(park.getImageUrl());
        model.setRating(park.getRating());

        double d = Distances.metersToMiles(park.getDistance());
        model.setDistance(d);

        if (park.getGeometry() != null && park.getGeometry().location != null) {
            LatLng latLng = park.getGeometry().location;

            model.setCoord(new Coord(latLng.lat, latLng.lng));
        }

        return model;
    }

    /**
     * Returns a list of ParkModels derived from Park instances.
     *
     * @param parks
     * @return
     */
    public static List<ParkModel> map(List<Park> parks) {
        List<ParkModel> parkModels = new ArrayList<>();

        if (parks == null)
            return parkModels;

        for (Park park : parks) {
            ParkModel parkModel = map(park);
            parkModels.add(parkModel);
        }

        return parkModels;
    }
}
