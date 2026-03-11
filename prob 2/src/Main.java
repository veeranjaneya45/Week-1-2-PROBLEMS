//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

/*
Author: VEERANJANEYA REDDY
Problem: Flash Sale Inventory Manager
*/

class InventoryManager{

    HashMap<String,Integer> stock = new HashMap<>();
    Queue<Integer> waitingList = new LinkedList<>();

    public InventoryManager(){

        stock.put("IPHONE15",100);
    }

    public void checkStock(String product){

        System.out.println(stock.get(product)+" units available");
    }

    public void purchase(String product,int userId){

        int available=stock.get(product);

        if(available>0){

            stock.put(product,available-1);

            System.out.println("User "+userId+" purchase success. Remaining:"+stock.get(product));
        }

        else{

            waitingList.offer(userId);

            System.out.println("Added to waiting list. Position:"+waitingList.size());
        }
    }
}

public class FlashSaleInventoryManager{

    public static void main(String[] args){

        InventoryManager manager=new InventoryManager();

        manager.checkStock("IPHONE15");

        manager.purchase("IPHONE15",101);
        manager.purchase("IPHONE15",102);
    }
}