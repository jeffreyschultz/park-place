package com.forrent.parkplace.web.mvc.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.forrent.parkplace.support.Coord;
import com.forrent.parkplace.support.DoubleContextualSerializer;
import com.forrent.parkplace.support.Precision;

import java.util.Date;

/**
 * Park model used by the presentation and client-side scripts.
 */
public class ParkModel {

    private String name;
    private String imageUrl;
    private Coord coord;
    private double distance;
    private double rating;

    /**
     * Gets the current time for info purposes.
     *
     * @return
     */
    public Date getTimestamp() {
        return new Date();
    }

    /**
     * Gets the distance of the park from requested location.
     *
     * @return
     */
    @JsonSerialize(using = DoubleContextualSerializer.class)
    @Precision(precision = 2)
    public double getDistance() {
        return distance;
    }

    /**
     * Sets the distance.
     *
     * @param distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Gets the name of the park.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the park.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the image url.
     *
     * @return
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the image url.
     *
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Gets the rating of the park.
     *
     * @return
     */
    @JsonSerialize(using = DoubleContextualSerializer.class)
    @Precision(precision = 1)
    public double getRating() {
        return rating;
    }

    /**
     * Sets the rating of the park.
     *
     * @param rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Gets the coordinates of the park.
     *
     * @return
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * Sets the coordinates of the park.
     *
     * @param coord
     */
    public void setCoord(Coord coord) {
        this.coord = coord;
    }
}
