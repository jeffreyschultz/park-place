package com.forrent.parkplace.service.parks;

import com.google.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ParkService {

    private Set<ParkProvider> parkProviders;

    public Set<ParkProvider> getParkProviders() {
        return parkProviders;
    }

    public void setParkProviders(Set<ParkProvider> parkProviders) {
        this.parkProviders = parkProviders;
    }

    public List<Park> findParks(LatLng location) {

        List<Park> allParks = new ArrayList<>();

        if (parkProviders == null)
            return allParks;

        for (ParkProvider parkProvider : parkProviders) {
            List<Park> parks = parkProvider.findParks(location);

            if (parks == null || parks.size() == 0)
                continue;

            allParks.addAll(parks);
        }

        //
        // Sort the parks according to distance from the current location.
        //
        allParks.sort(new ParkComparator());

        return allParks;
    }
}
