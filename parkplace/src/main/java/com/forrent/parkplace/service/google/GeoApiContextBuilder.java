package com.forrent.parkplace.service.google;

import com.google.common.base.Strings;
import com.google.maps.GeoApiContext;

public class GeoApiContextBuilder {

    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        if (Strings.isNullOrEmpty(apiKey)) {
            throw new IllegalArgumentException("apiKey cannot be empty.");
        }

        this.apiKey = apiKey;
    }

    public GeoApiContext build() {
        return new GeoApiContext.Builder()
                .apiKey(apiKey)
                .maxRetries(5)
                .queryRateLimit(5)
                .build();
    }
}
