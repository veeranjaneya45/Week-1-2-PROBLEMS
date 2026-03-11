//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

/*
Author: VEERANJANEYA REDDY
Problem: Two Sum Fraud Detection
*/

public class Main{

    public static void findTwoSum(int[] nums,int target){

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums){

            int complement=target-num;

            if(map.containsKey(complement)){

                System.out.println("Pair:"+num+" "+complement);
                return;
            }

            map.put(num,1);
        }
    }

    public static void main(String[] args){

        int[] transactions={500,300,200};

        findTwoSum(transactions,500);
    }
}