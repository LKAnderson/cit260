package officehours;

import java.util.SimpleTimeZone;

import officehours.navdb.Airport;
import officehours.navdb.AirportService;
import officehours.navdb.Communication;
import officehours.navdb.CommunicationType;
import officehours.navdb.Helipad;
import officehours.navdb.Runway;
import officehours.navdb.RunwaySurface;

public class AirportTest {

    public static void main(String[] argv) {

        Airport airport = new Airport();

        airport.setIdentifier("KSLC");
        airport.setLatitude(40.7883933);
        airport.setLongitude(-111.9777733);
        airport.setElevation(4230.9);
        airport.setMagvar(11);
        airport.setTimezone(new SimpleTimeZone(-7*60*60*1000, "UTC-7"));
        airport.setZipcode(84116);

        // Airport Comms
        airport.getCommunications().add(
            new Communication(CommunicationType.WX, 134425, 
                                "AWOS-3 at U42 (10 nm S)"));
        airport.getCommunications().add(
            new Communication(CommunicationType.WX, 119725,
                                "AWOS-3 at TVY (20 nm SW)"));

        airport.getCommunications().add(
            new Communication(CommunicationType.GND, 121900, "RWYS 17/35"));
        airport.getCommunications().add(
            new Communication(CommunicationType.GND, 123775, "RWYS 16R/34L & 16L/34R"));

        airport.getCommunications().add(
            new Communication(CommunicationType.APPR, 120900, "SOUTH OF 41 DEG LAT BLO 8,000"));
        airport.getCommunications().add(
            new Communication(CommunicationType.APPR, 121100, "NORTH OF 41 DEG LAT BLOW 8,000"));
        airport.getCommunications().add(
            new Communication(CommunicationType.APPR, 124300, "110-160 ABV 8,000 FT"));
        airport.getCommunications().add(
            new Communication(CommunicationType.APPR, 124900, "300-340 ABV 8,000 FT."));
        airport.getCommunications().add(
            new Communication(CommunicationType.APPR, 128100, "160-250 ABV 8,000 FT."));
        airport.getCommunications().add(
            new Communication(CommunicationType.APPR, 135500, "340-110 ABV 8,000 FT"));

        airport.getCommunications().add(
            new Communication(CommunicationType.DEPART, 120900, "SOUTH OF 41 DEG LAT BLO 8,000"));
        airport.getCommunications().add(
            new Communication(CommunicationType.DEPART, 121100, "NORTH OF 41 DEG LAT BLOW 8,000"));
        airport.getCommunications().add(
            new Communication(CommunicationType.DEPART, 124300, "110-160 ABV 8,000 FT"));
        airport.getCommunications().add(
            new Communication(CommunicationType.DEPART, 126200, " 250-300 ABV 8,000 FT"));
        airport.getCommunications().add(
            new Communication(CommunicationType.DEPART, 128100, "160-250 ABV 8,000 FT."));
        airport.getCommunications().add(
            new Communication(CommunicationType.DEPART, 135500, "340-110 ABV 8,000 FT"));

        airport.getCommunications().add(
            new Communication(CommunicationType.EMERG, 121500, "EMERGENCY"));
        airport.getCommunications().add(
            new Communication(CommunicationType.EMERG, 243000, "EMERGENCY"));
        
        // Airport services
        airport.getServices().add(new AirportService("Fuel available", "100LL JET-A1+"));
        airport.getServices().add(new AirportService("Parking", "hangars and tiedowns"));
        airport.getServices().add(new AirportService("Airframe service", "MAJOR"));
        airport.getServices().add(new AirportService("Powerplant service", "MAJOR"));
        airport.getServices().add(new AirportService("Bottled oxygen", "HIGH/LOW"));
        airport.getServices().add(new AirportService("Bulk oxygen", "HIGH/LOW"));

        // Runways
        airport.getRunways().add(
            new Runway("16L", 40.80745271666667, -111.97693213333334, 
                        4229.1, 12002, 150, 0.1, 164, 175, 
                        RunwaySurface.ASP, "ILS/DME"));
        airport.getRunways().add(
            new Runway("34R", 40.77464403333333, -111.97312683333334, 
                        4224.3, 12002, 150, 0.1, 344, 355, 
                        RunwaySurface.ASP, "ILS/DME"));

        airport.getRunways().add(
            new Runway("34L", 40.774976966666664, -111.9954698, 
                        4229.1, 12002, 150, 0.1, 164, 175, 
                        RunwaySurface.ASP, "ILS/DME"));
        airport.getRunways().add(
            new Runway("16R", 40.80777875, -111.99928561666667, 
                        4224.3, 12002, 150, 0.1, 344, 355, 
                        RunwaySurface.ASP, "ILS/DME"));

        airport.getRunways().add(
            new Runway("17", 40.79891786666666, -111.96207088333334, 
                        4221.7, 9596, 150, 0.1, 169, 180, 
                        RunwaySurface.ASP, "ILS/DME"));
        airport.getRunways().add(
            new Runway("35", 40.77258395, -111.96206933333333, 
                        4226.8, 9596, 150, 0.1, 349, 360, 
                        RunwaySurface.ASP, "ILS/DME"));

        airport.getRunways().add(
            new Runway("14", 40.785718, -111.97124058333333, 
                        4224.7, 4893, 150, 0.1, 142, 153, 
                        RunwaySurface.ASP, "none"));
        airport.getRunways().add(
            new Runway("32", 40.773755333333334, -111.96321986666666, 
                        4226.8, 4893, 150, 0.1, 322, 333, 
                        RunwaySurface.ASP, "none"));

        // Helipads
        airport.getHelipads().add(
            new Helipad("HB", 40.774189633333336, -111.95668228333334, 
                        4220.4, 60, 60, RunwaySurface.ASP));
        airport.getHelipads().add(
            new Helipad("HF", 40.774189633333336, -111.95668228333334, 
                        4220.4, 60, 60, RunwaySurface.ASP));

    }
}