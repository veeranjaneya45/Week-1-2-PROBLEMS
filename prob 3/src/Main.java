//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

/*
Author: VEERANJANEYA REDDY
Problem: DNS Cache with TTL
*/

class DNSEntry{

    String ip;
    long expiry;

    DNSEntry(String ip,int ttl){

        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl*1000;
    }
}

class DNSCache{

    HashMap<String,DNSEntry> cache=new HashMap<>();

    public String resolve(String domain){

        if(cache.containsKey(domain)){

            DNSEntry entry=cache.get(domain);

            if(System.currentTimeMillis()<entry.expiry){

                return "Cache HIT "+entry.ip;
            }
        }

        String newIP="172.217.14."+new Random().nextInt(255);

        cache.put(domain,new DNSEntry(newIP,300));

        return "Cache MISS "+newIP;
    }
}

public class Main{

    public static void main(String[] args){

        DNSCache dns=new DNSCache();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));
    }
}