package officehours;

public class PublicClassExample {
    

   
    public static void printPerson(Person person) {
        System.out.println(person.getName());
        System.out.println(person.getNameLength());
    }
    
    
    public static void main(String[] argv) {
        
       Person person = new Person("Debbie Murdock", 25);

       
       printPerson(person);
       
       person.setName(null);
       printPerson(person);
       
       
    }
    

}


