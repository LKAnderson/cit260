package officehours.navdb;

public class Helipad {

    private String identifier;
    private double latitude;
    private double longitude;
    private double elevation;
    private double length;
    private double width;
    private RunwaySurface surface;
    
    
    /**
     * Default constructor
     */
    public Helipad() {
        
    }
    
    /**
     * @param identifier
     * @param latitude
     * @param longitude
     * @param elevation
     * @param length
     * @param width
     * @param surface
     */
    public Helipad(String identifier, double latitude, double longitude, double elevation, double length, double width,
            RunwaySurface surface) {
        super();
        this.identifier = identifier;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.length = length;
        this.width = width;
        this.surface = surface;
    }

    /**
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @param identifier the identifier to set
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the elevation
     */
    public double getElevation() {
        return elevation;
    }

    /**
     * @param elevation the elevation to set
     */
    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    /**
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the surface
     */
    public RunwaySurface getSurface() {
        return surface;
    }

    /**
     * @param surface the surface to set
     */
    public void setSurface(RunwaySurface surface) {
        this.surface = surface;
    }
    

    
    
}