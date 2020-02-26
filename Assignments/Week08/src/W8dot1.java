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
        for (int i=0; i < rectangles.length; i++) {
            Rectangle rect = rectangles[i];
            System.out.format("Rectangle %d:\nheight = %.2f\nwidth = %.2f\narea = %.2f\npermiter: %.2f\n", 
                    i+1,
                    rect.getHeight(),
                    rect.getWidth(), 
                    rect.getArea(),
                    rect.getPerimeter());
            System.out.println();
        }
    }

}
