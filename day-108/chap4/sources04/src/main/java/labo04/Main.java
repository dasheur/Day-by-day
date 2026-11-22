package labo04;

public class Main {
    public static void main(String[] args) {
        Garage g = new Garage(4);
        Car v1 = new Car("C", "a");
        Car v2 = new Car("A", "c");
        Garage g1 = new Garage(4);
        g1.add(v1);
        g1.add(v2);
        g1.sort();
        System.out.println(g1);
    }
}
