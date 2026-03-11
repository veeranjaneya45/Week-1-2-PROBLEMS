//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

/*
Author: VEERANJANEYA REDDY
Problem 10: Multi-Level Cache
*/

class Cache {

    LinkedHashMap<String, String> l1 = new LinkedHashMap<>();
    HashMap<String, String> l2 = new HashMap<>();

    String getVideo(String id) {

        if (l1.containsKey(id)) {

            return "L1 Cache HIT";
        }

        if (l2.containsKey(id)) {

            l1.put(id, l2.get(id));
            return "L2 Cache HIT -> Promoted to L1";
        }

        l2.put(id, "VideoData");

        return "Database HIT -> Stored in L2";
    }
}

public class Main {

    public static void main(String[] args) {

        Cache cache = new Cache();

        System.out.println(cache.getVideo("video123"));
        System.out.println(cache.getVideo("video123"));
    }
}
