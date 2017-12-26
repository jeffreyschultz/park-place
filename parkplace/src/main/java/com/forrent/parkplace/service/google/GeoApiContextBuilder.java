package com.forrent.parkplace.service.google;

import com.google.common.base.Strings;
import com.google.maps.GeoApiContext;

/**
 * GeoApiContext builder to be used as a singleton for all Google Maps API clients.
 */
public class GeoApiContextBuilder {

    private String apiKey;

    /**
     * Gets the api key used by the builder.
     *
     * @return
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the api key used by the builder.
     * @param apiKey
     */
    public void setApiKey(String apiKey) {
        if (Strings.isNullOrEmpty(apiKey)) {
            throw new IllegalArgumentException("apiKey cannot be empty.");
        }

        this.apiKey = apiKey;
    }

    /**
     * Builds a new instance of GeoApiContext.
     * @return
     */
    public GeoApiContext build() {
        return new GeoApiContext.Builder()
                .apiKey(apiKey)
                .maxRetries(5)
                .queryRateLimit(5)
                .build();
    }
}
