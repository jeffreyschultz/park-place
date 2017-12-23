package com.forrent.parkplace.service.parks;

import java.util.Comparator;

/**
 * Sorts a list of Parks according to distance from the current location.
 */
public class ParkComparator implements Comparator<Park> {

    @Override
    public int compare(Park o1, Park o2) {
        if (o1 == null && o2 == null)
            return 0;

        if (o1 == null && o2 != null)
            return 1;

        if (o1 != null && o2 == null)
            return -1;

        return o1.getDistance() - o2.getDistance();
    }
}
