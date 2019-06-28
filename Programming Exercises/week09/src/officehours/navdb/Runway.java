package officehours.navdb;

/**
 * The runway model for our navdb.
 */
public class Runway {
    
    private String identifier;
    private double latitude;
    private double longitude;
    private double elevation;
    private double length;
    private double width;
    private double gradient;
    private double magHeading;
    private double trueHeading;
    private RunwaySurface surface;
    private String instrumentApproach;
    
    /**
     * Default constructor
     */
    public Runway() {
        
    }
    
    /**
     * @param identifier
     * @param latitude
     * @param longitude
     * @param elevation
     * @param length
     * @param width
     * @param gradient
     * @param magHeading
     * @param trueHeading
     * @param surface
     * @param instrumentApproach
     */
    public Runway(String identifier, double latitude, double longitude, double elevation, double length, double width,
            double gradient, double magHeading, double trueHeading, RunwaySurface surface, String instrumentApproach) {
        super();
        this.identifier = identifier;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.length = length;
        this.width = width;
        this.gradient = gradient;
        this.magHeading = magHeading;
        this.trueHeading = trueHeading;
        this.surface = surface;
        this.instrumentApproach = instrumentApproach;
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
     * @return the gradient
     */
    public double getGradient() {
        return gradient;
    }

    /**
     * @param gradient the gradient to set
     */
    public void setGradient(double gradient) {
        this.gradient = gradient;
    }

    /**
     * @return the magHeading
     */
    public double getMagHeading() {
        return magHeading;
    }

    /**
     * @param magHeading the magHeading to set
     */
    public void setMagHeading(double magHeading) {
        this.magHeading = magHeading;
    }

    /**
     * @return the trueHeading
     */
    public double getTrueHeading() {
        return trueHeading;
    }

    /**
     * @param trueHeading the trueHeading to set
     */
    public void setTrueHeading(double trueHeading) {
        this.trueHeading = trueHeading;
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

    /**
     * @return the instrumentApproach
     */
    public String getInstrumentApproach() {
        return instrumentApproach;
    }

    /**
     * @param instrumentApproach the instrumentApproach to set
     */
    public void setInstrumentApproach(String instrumentApproach) {
        this.instrumentApproach = instrumentApproach;
    }

    
}