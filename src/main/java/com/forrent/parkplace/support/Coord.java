package com.forrent.parkplace.support;

/**
 * Coordinate model used to support the presentation.
 */
public class Coord {

    private double lat;
    private double lng;

    public Coord(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * Gets the lat value.
     *
     * @return
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets the lat value.
     *
     * @param lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * Gets the lng value.
     *
     * @return
     */
    public double getLng() {
        return lng;
    }

    /**
     * Sets the lng value.
     *
     * @param lng
     */
    public void setLng(double lng) {
        this.lng = lng;
    }
}
