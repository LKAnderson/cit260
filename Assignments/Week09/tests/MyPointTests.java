import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Provide unit tests for the MyPoint class.
 */
public class MyPointTests {

    @Test
    public void testDistance_xy() {
        var point = new MyPoint();
        var result = point.distance(10, 10);
        assertEquals(14.14, result, 0.01);
    }

    @Test
    public void testDistance_xy_nonZeroOrigin() {
        var point = new MyPoint(-5, -5);
        var result = point.distance(5, 5);
        assertEquals(14.14, result, 0.01);
    }

    @Test
    public void testDistance_point() {
        var point = new MyPoint();
        var otherPoint = new MyPoint(3, 4);
        var result = point.distance(otherPoint);
        assertEquals(5.0, result, 0.01);
    }

    @Test
    public void testDistance_static() {
        var point = new MyPoint();
        var otherPoint = new MyPoint(3, 4);
        var result = MyPoint.distance(point, otherPoint);
        assertEquals(5.0, result, 0.01);
    }
}
