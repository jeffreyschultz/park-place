package com.forrent.parkplace.service.parks.google;

import com.forrent.parkplace.service.parks.Park;
import com.google.maps.model.PlacesSearchResult;

public class PlaceToParkAdapter {
    public static Park adapt(PlacesSearchResult place) {
        return new Park();
    }
}
