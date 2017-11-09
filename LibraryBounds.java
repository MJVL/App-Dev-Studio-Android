public class LibraryBounds {

    private final static double MAX_LAT = 39.35066;
    private final static double MIN_LAT = 39.35044;

    private final static double MAX_LON = 84.30696;
    private final static double MIN_LON = 84.30664;

    public static boolean checkBounds(double lat, double lon) {
        if (lat < MAX_LAT && lat > MIN_LAT && lon < MAX_LON && lon > MIN_LON) {
            return true;
        }
        return false;
    }

}
