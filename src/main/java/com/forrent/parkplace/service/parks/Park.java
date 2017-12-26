package com.forrent.parkplace.service.parks;

import com.google.maps.model.Geometry;
import com.google.maps.model.LatLng;

import java.util.Comparator;

/**
 * Park class used by the Park Service.
 */
public class Park {

    private String name;
    private String description;
    private String imageUrl;

    private double distance;
    private float rating;
    private Geometry geometry;
    private LatLng latLng;

    /**
     * Gets the geometry of the Park.
     *
     * @return
     */
    public Geometry getGeometry() {
        return geometry;
    }

    /**
     * Sets the geometry of the Park.
     *
     * @param geometry
     */
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    /**
     * Gets the name of the Park.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Park.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the Park.
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the Park.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the image url.
     * @return
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the image url.
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Gets the distance of the park from the location.
     *
     * @return
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets the distance of the park from the location.
     *
     * @param distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Gets the rating of the park.
     * @return
     */
    public float getRating() {
        return rating;
    }

    /**
     * Sets the rating of the park.
     *
     * @param rating
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * Gets the lat/lon of the park.
     *
     * @return
     */
    public LatLng getLatLng() {
        return latLng;
    }

    /**
     * Sets the lat/lon of the park.
     *
     * @param latLng
     */
    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    /**
     * Sorts a list of Parks according to distance from the current location.
     */
    public static class ParkComparator implements Comparator<Park> {

        @Override
        public int compare(Park o1, Park o2) {
            if (o1 == null && o2 == null)
                return 0;

            if (o1 == null && o2 != null)
                return 1;

            if (o1 != null && o2 == null)
                return -1;

            return (int) (o1.getDistance() - o2.getDistance());
        }
    }
}
