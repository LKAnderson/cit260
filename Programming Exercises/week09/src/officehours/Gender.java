
package officehours;

/**
 * Model the biological gender of a person.
 * 
 * An enum is a special kind of class that allows us 
 * to define all of the instances of the object that can
 * exist in our program. We treat them like constants, 
 * and their value is abstract. We don't need to model
 * what makes the value, just that it is the value. I know,
 * it's weird. But it's very powerful in programming.
 * 
 * Java's enum's are the best out there. This class shows 
 * the basic functionality: providing all of the distinct
 * values that a Gender object can have in our program.
 * 
 * @author kent
 *
 */
public enum Gender {

    MALE,
    FEMALE
}
