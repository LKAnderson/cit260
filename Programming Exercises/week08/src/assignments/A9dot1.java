package assignments;

/**
 * Test program for Rectangle
 * @author kent
 */
public class A9dot1 {
    
    public static void main(String[] argv) {
        
        // Create the rectangles in an array.
        Rectangle[] rectangles = new Rectangle[2];
        rectangles[0] = new Rectangle(4, 40);
        rectangles[1] = new Rectangle(3.5, 35.9);
        
        // Print out the stats for each rectangle created.
        for (Rectangle rect: rectangles){
            System.out.printf("width: %f, height: %f, area; %f, permiter: %f\n", 
                    rect.getWidth(), 
                    rect.getHeight(),
                    rect.getArea(),
                    rect.getPerimeter());
        }
    }

}
