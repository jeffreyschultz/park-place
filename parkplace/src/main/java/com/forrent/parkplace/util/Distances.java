package com.forrent.parkplace.util;

public class Distances {

    public static int MilesToMeters(int miles) {
        return (int) Math.round(miles * 1609.344);
    }
}
