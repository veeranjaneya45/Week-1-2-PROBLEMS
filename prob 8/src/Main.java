//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

/*
Author: VEERANJANEYA REDDY
Problem 8: Parking Lot Hashing
*/

public class Main {

    static String[] parking = new String[10];

    static int hash(String plate) {

        return Math.abs(plate.hashCode()) % parking.length;
    }

    static void park(String plate) {

        int index = hash(plate);

        while (parking[index] != null) {
            index = (index + 1) % parking.length;
        }

        parking[index] = plate;

        System.out.println(plate + " parked at spot " + index);
    }

    public static void main(String[] args) {

        park("ABC1234");
        park("XYZ9999");
        park("CAR5678");
    }
}
