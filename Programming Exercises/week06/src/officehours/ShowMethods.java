package officehours;



public class ShowMethods {
    
    
    // visibility scope return-type method-name (argument list)
    public static int getIntegerValue() {
        return 4;
    }
   
    
    
    
    public static void main(String[] args) {
        
        int value = getIntegerValue();
        
        
        String str = "Some String";
        System.out.println(str.length());
        
        String numString = String.valueOf(value);
        System.out.println(numString.length());

        
    }
    
    
    
    

}
