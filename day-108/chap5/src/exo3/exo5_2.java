package exo3;

import exo2.Date;

import java.util.ArrayList;

/*
Créez une liste de Date contenant quelques dates.
Triez-là ensuite à l'aide de Collections.sort().
Faites de même avec une liste de Person.
 */
public class exo5_2 {

    public static void main() {
        ArrayList<Date> list = Date.getRandomDates(3);
        Date.printDates(list);
        System.out.println(list.size());
    }
}
