//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

/*
Author: VEERANJANEYA REDDY
Problem 9: Fraud Detection Two-Sum
*/

public class Main {

    public static void findPair(int[] transactions, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int t : transactions) {

            int complement = target - t;

            if (map.containsKey(complement)) {

                System.out.println("Fraud Pair Found: "
                        + complement + " + " + t);

                return;
            }

            map.put(t, 1);
        }
    }

    public static void main(String[] args) {

        int[] transactions = {500, 300, 200};

        findPair(transactions, 500);
    }
}