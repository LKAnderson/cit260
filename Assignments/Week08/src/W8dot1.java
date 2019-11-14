/**
 * Test program for Rectangle
 * @author kent
 */
public class W8dot1 {
    
    public static void main(String[] argv) {
        
        // Create the rectangles in an array.
        Rectangle[] rectangles = new Rectangle[2];
        rectangles[0] = new Rectangle(40, 4);
        rectangles[1] = new Rectangle(5, 3.5);
        
        // Print out the stats for each rectangle created.
        for (Rectangle rect: rectangles){
            System.out.printf("width: %.2f, height: %.2f, area; %.2f, permiter: %.2f%n", 
                    rect.getWidth(), 
                    rect.getHeight(),
                    rect.getArea(),
                    rect.getPerimeter());
        }
    }

}
