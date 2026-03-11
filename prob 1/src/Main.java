//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

/*
Author: VEERANJANEYA REDDY
Problem: Username Availability Checker using HashMap
*/

class UsernameChecker {

    private HashMap<String,Integer> users = new HashMap<>();
    private HashMap<String,Integer> attempts = new HashMap<>();

    public UsernameChecker(){

        users.put("john_doe",1);
        users.put("admin",2);
        users.put("user123",3);
    }

    public boolean checkAvailability(String username){

        attempts.put(username,attempts.getOrDefault(username,0)+1);

        return !users.containsKey(username);
    }

    public List<String> suggest(String username){

        List<String> suggestions = new ArrayList<>();

        suggestions.add(username+"1");
        suggestions.add(username+"2");
        suggestions.add(username.replace("_","."));

        return suggestions;
    }

    public String mostAttempted(){

        String maxUser="";
        int max=0;

        for(String u:attempts.keySet()){

            if(attempts.get(u)>max){

                max=attempts.get(u);
                maxUser=u;
            }
        }

        return maxUser;
    }
}

public class Main{

    public static void main(String[] args){

        UsernameChecker checker=new UsernameChecker();

        System.out.println(checker.checkAvailability("john_doe"));
        System.out.println(checker.checkAvailability("jane_smith"));

        System.out.println(checker.suggest("john_doe"));

        System.out.println("Most attempted:"+checker.mostAttempted());
    }
}