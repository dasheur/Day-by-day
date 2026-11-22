package labo04;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void testConstructor() {
        Car v = new Car("Citroen", "2cv");
        assertEquals("Citroen", v.getBrand());
        assertEquals("2cv", v.getModel());
    }

    @Test
    public void testToString() {
        Car v = new Car("Citroen", "2cv");
        assertEquals("Citroen 2cv", v.toString());
    }

    @Test
    public void testEquals() {
        Car v1 = new Car("Citroen", "2cv");
        Car v2 = new Car("Citroen", "2cv");
        Car v3 = new Car("Citroen", "DS");
        assertEquals(v1, v2);
        assertFalse(v1.equals(v3));
    }


    @Test
    public void testCompareTo() {
        Car v1 = new Car("Citroen", "2cv");
        Car v2 = new Car("Citroen", "2cv");
        Car v3 = new Car("Citroen", "DS");
        assertTrue(v1.compareTo(v2) == 0);
        assertTrue(v1.compareTo(v3) < 0);
        assertTrue(v3.compareTo(v1) > 0);
    }

}
