//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

/*
Author: VEERANJANEYA REDDY
Problem: Plagiarism Detection using HashMap
*/

class PlagiarismDetector{

    HashMap<String,Set<String>> index=new HashMap<>();

    public void addDocument(String docId,String text){

        String[] words=text.split(" ");

        for(int i=0;i<words.length-2;i++){

            String gram=words[i]+" "+words[i+1]+" "+words[i+2];

            index.computeIfAbsent(gram,k->new HashSet<>()).add(docId);
        }
    }

    public void check(String text){

        String[] words=text.split(" ");

        int matches=0;

        for(int i=0;i<words.length-2;i++){

            String gram=words[i]+" "+words[i+1]+" "+words[i+2];

            if(index.containsKey(gram)) matches++;
        }

        System.out.println("Matching grams:"+matches);
    }
}

public class Main{

    public static void main(String[] args){

        PlagiarismDetector p=new PlagiarismDetector();

        p.addDocument("doc1","java is a programming language used worldwide");

        p.check("java is a programming language");
    }
}