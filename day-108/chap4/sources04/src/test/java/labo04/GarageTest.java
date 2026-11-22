package labo04;

import static org.junit.Assert.*;

import org.junit.Test;

public class GarageTest {
    @Test
    public void testBasicOperations() {
        Garage g = new Garage();
        Car v = new Car("A", "b");
        assertTrue(g.isEmpty());
        assertFalse(g.isFull());
        assertTrue(g.add(v));
        assertSame(1, g.numberOfCars());
        assertEquals(v, g.getCar(1));
        assertTrue(g.contains(v));
        assertFalse(g.isEmpty());
        assertFalse(g.isFull());
    }

    @Test
    public void testInsertWhenGarageIfFull() {
        Garage g = new Garage(2);
        Car v1 = new Car("A", "a");
        Car v2 = new Car("B", "b");
        Car v3 = new Car("C", "c");
        assertTrue(g.add(v1));
        assertTrue(g.add(v2));
        assertFalse(g.add(v3));

        assertEquals(2, g.numberOfCars());
        assertTrue(g.contains(v1));
        assertTrue(g.contains(v2));
        assertFalse(g.contains(v3));
        assertSame(v1, g.getCar(1));
        assertSame(v2, g.getCar(2));

        assertEquals(null, g.getCar(3));
        assertEquals(null, g.getCar(0));

        assertFalse(g.isEmpty());
        assertTrue(g.isFull());
        assertFalse(g.add(v2));
    }

    @Test
    public void testRemove() {
        Garage g = new Garage(3);
        Car v1 = new Car("A", "a");
        Car v2 = new Car("B", "b");
        Car v3 = new Car("C", "c");
        g.add(v1);
        g.add(v2);
        g.add(v3);

        assertEquals(3, g.numberOfCars());
        assertTrue(g.removeLastCar());
        assertEquals(2, g.numberOfCars());
        assertSame(v1, g.getCar(1));
        assertSame(v2, g.getCar(2));
        assertFalse(g.contains(v3));

        assertTrue(g.removeLastCar());
        assertTrue(g.removeLastCar());
        assertTrue(g.isEmpty());
        assertFalse(g.isFull());
        assertEquals(0, g.numberOfCars());

        assertFalse(g.removeLastCar());
    }

    @Test
    public void testSort() {
        Garage g = new Garage(4);
        Car v1 = new Car("A", "a");
        Car v2 = new Car("C", "c");
        Car v3 = new Car("B", "b");
        Car v4 = new Car("A", "b");
        g.add(v1);
        g.add(v2);
        g.add(v3);
        g.add(v4);
        g.sort();
        assertSame(v1, g.getCar(1));
        assertSame(v4, g.getCar(2));
        assertSame(v3, g.getCar(3));
        assertSame(v2, g.getCar(4));
    }

    @Test
    public void testToString() {
        Garage g = new Garage(2);
        Car v1 = new Car("Citroen", "2cv");
        Car v2 = new Car("Citroen", "DS");
        g.add(v1);
        g.add(v2);

        String expected = "Garage : \n  1) " + v1 + "\n  2) " + v2 + "\n";
        assertEquals(expected, g.toString());
    }

}
