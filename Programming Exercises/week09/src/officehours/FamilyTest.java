package officehours;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;




/**
 * Test our Family model
 * @author kent
 *
 */
public class FamilyTest {
    
    private static DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
    
    /**
     * Build a person description string that meets our needs.
     * We generally don't do this in a toString() method on the
     * Person class because we don't know where/how a Person 
     * class might be used.
     * 
     * @param person
     * @return string containing Name, Gender, age today
     */
    private static String getPersonString(Person person) {
        if (person == null) {
            return "None";
        }
        
        Calendar birthday = person.getDateOfBirth();
        
        StringBuilder sb = new StringBuilder();
        sb.append(person.getName())
        
          .append(", ")
          .append(person.getGender() == Gender.MALE ? "Male" : "Female")
          
          .append(", ")
          .append(dateFormat.format(person.getDateOfBirth().getTime()))
          
          
          .append(", ")
          .append("would be " + person.getAge() + " today");
        
        return sb.toString();
    }
    
    
    
    public static void main(String[] argv) {
        
        // Source of data: https://www.lds.org/study/ensign/2005/12/
        // family-of-joseph-smith-sr-and-lucy-mack-smith-the-
        // first-family-of-the-restoration?lang=eng
        
        Family family = new Family(
                new Person("Joseph Smith", Gender.MALE, 
                        new GregorianCalendar(1771, Calendar.JULY, 12)),
                new Person("Lucy Mack", Gender.FEMALE, 
                        new GregorianCalendar(1775, Calendar.JULY, 8)));
        
        
        family.addChild(new Person("Infant", Gender.MALE,
                new GregorianCalendar(1797, Calendar.JANUARY, 1)));
        
        family.addChild(new Person("Alvin", Gender.MALE,
                new GregorianCalendar(1798, Calendar.FEBRUARY, 11)));
        
        family.addChild(new Person("Hyrum", Gender.MALE,
                new GregorianCalendar(1800, Calendar.FEBRUARY, 9)));
        
        family.addChild(new Person("Sophronia", Gender.FEMALE,
                new GregorianCalendar(1803, Calendar.MAY, 17)));
        
        family.addChild(new Person("Joseph", Gender.MALE,
                new GregorianCalendar(1805, Calendar.DECEMBER, 23)));
        
        family.addChild(new Person("Samuel Harrison", Gender.MALE,
                new GregorianCalendar(1808, Calendar.MARCH, 13)));
        
        family.addChild(new Person("Ephraim", Gender.MALE,
                new GregorianCalendar(1810, Calendar.MARCH, 13)));
        
        family.addChild(new Person("William", Gender.MALE,
                new GregorianCalendar(1811, Calendar.MARCH, 13)));
        
        family.addChild(new Person("Katharine", Gender.FEMALE,
                new GregorianCalendar(1813, Calendar.JULY, 28)));
        
        family.addChild(new Person("Don Carlos", Gender.MALE,
                new GregorianCalendar(1816, Calendar.MARCH, 25)));
        
        family.addChild(new Person("Lucy", Gender.FEMALE,
                new GregorianCalendar(1821, Calendar.JULY, 18)));
        
        
        
        // Now print the family
        System.out.println(getPersonString(family.getFather()));
        System.out.println(getPersonString(family.getMother()));
        
        for (int i=0; i < family.getChildrenCount(); i++) {
            System.out.printf("%2d %s%n", i+1, getPersonString(family.getChild(i)));
        }
        
    }

}
