/**
 * Temperature converter.
 */
public class W6dot2 {

    /**
     * Convert C to F
     * @param celsius the degrees in celsius
     * @return the equivalent degrees in fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (9.0/5 * celsius) + 32;
    }

    /**
     * Convert F to C
     * @param fahrenheit the degrees in fahrenheit
     * @return the equivalent degrees in celsius
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / (9.0/5);
    }


    public static void main(String[] argv) {

        String tableHeader = "Celsius   Fahrenheit   |   Fahrenheit   Celsius";
        String tableLine =   "-----------------------------------------------";
        
        String tableTemplate = "%-7.1f   %5.1f        |   %-10.1f   %5.2f\n";

        System.out.println(tableHeader);
        System.out.println(tableLine);

        double celsius = 40.0;
        double fahrenheit = 120.0;

        for (int i=0; i < 10; i++, celsius -= 1.0, fahrenheit -= 10.0 ){
            double c2f = celsiusToFahrenheit(celsius);
            double f2c = fahrenheitToCelsius(fahrenheit);

            System.out.printf(tableTemplate, celsius, c2f, fahrenheit, f2c);
        }
        
    }

}