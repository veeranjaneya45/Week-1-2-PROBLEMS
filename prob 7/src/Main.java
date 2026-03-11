//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

/*
Author: VEERANJANEYA REDDY
Problem 7: Autocomplete System
*/

class Autocomplete {

    HashMap<String, Integer> queries = new HashMap<>();

    void addQuery(String query) {

        queries.put(query, queries.getOrDefault(query, 0) + 1);
    }

    List<String> search(String prefix) {

        List<String> results = new ArrayList<>();

        for (String q : queries.keySet()) {

            if (q.startsWith(prefix)) {
                results.add(q);
            }
        }

        return results;
    }
}

public class Main{

    public static void main(String[] args) {

        Autocomplete ac = new Autocomplete();

        ac.addQuery("java tutorial");
        ac.addQuery("javascript");
        ac.addQuery("java download");

        System.out.println(ac.search("jav"));
    }
}
