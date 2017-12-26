package com.forrent.parkplace.util;

public class Distances {

    /**
     * Calculate the conversion of miles to meters.
     *
     * @param mi
     * @return
     */
    public static double milesToMeters(double mi) {
        return mi * 1609.344;
    }

    /**
     * Calculate the conversion of meters to miles.
     *
     * @param m
     * @return
     */
    public static double metersToMiles(double m) {
        return m / 1609.344;
    }

    /**
     * Calculate distance between two points in latitude and longitude. Uses the Haversine method.
     *
     * @param lat1
     * @param lat2
     * @param lng1
     * @param lng2
     * @returns Distance in Meters
     */
    public static double distance(double lat1, double lat2, double lng1, double lng2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lng2 - lng1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        return Math.sqrt(distance);
    }
}
