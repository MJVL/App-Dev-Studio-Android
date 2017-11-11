package com.example.mjvl.positioncheck;

/**
 * Created by mjvl on 11/9/17.
 */

public class LibraryBounds {

    private final static double MAX_LAT = 39.35066;
    private final static double MIN_LAT = 39.35044;

    private final static double MAX_LON = 84.30696;
    private final static double MIN_LON = 84.30664;

    public static double getMaxLat() {
        return MAX_LAT;
    }

    public static double getMinLat() {
        return MIN_LAT;
    }

    public static double getMaxLon() {
        return MAX_LON;
    }

    public static double getMinLon() {
        return MIN_LON;
    }

    public static boolean checkBounds(double lat, double lon) {
        if (lat <= MAX_LAT && lat >= MIN_LAT && lon <= MAX_LON && lon >= MIN_LON) {
            return true;
        }
        return false;
    }

}

