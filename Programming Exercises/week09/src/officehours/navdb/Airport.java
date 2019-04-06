package officehours.navdb;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class Airport {

    private String identifier;
    private double latitude;
    private double longitude;
    private double elevation;
    private double magvar;
    private TimeZone timezone;
    private int zipcode;
    private List<Runway> runways;
    private List<Helipad> helipads;
    private List<Communication> communications;
    private List<AirportService> services;

    
    /**
     * Default constructor
     */
    public Airport() {
        runways = new ArrayList<Runway>();
        helipads = new ArrayList<Helipad>();
        communications = new ArrayList<Communication>();
        services = new ArrayList<AirportService>();
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
     * @return the magvar
     */
    public double getMagvar() {
        return magvar;
    }


    /**
     * @param magvar the magvar to set
     */
    public void setMagvar(double magvar) {
        this.magvar = magvar;
    }


    /**
     * @return the timezone
     */
    public TimeZone getTimezone() {
        return timezone;
    }


    /**
     * @param timezone the timezone to set
     */
    public void setTimezone(TimeZone timezone) {
        this.timezone = timezone;
    }


    /**
     * @return the zipcode
     */
    public int getZipcode() {
        return zipcode;
    }


    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }


    /**
     * @return the runways
     */
    public List<Runway> getRunways() {
        return runways;
    }


    /**
     * @return the helipads
     */
    public List<Helipad> getHelipads() {
        return helipads;
    }


    /**
     * @return the communications
     */
    public List<Communication> getCommunications() {
        return communications;
    }


    /**
     * @return the services
     */
    public List<AirportService> getServices() {
        return services;
    }
    
    
}