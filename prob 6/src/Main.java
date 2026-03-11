//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

/*
Author: VEERANJANEYA REDDY
Problem 6: Distributed Rate Limiter
*/

class TokenBucket {

    int tokens;
    int maxTokens;
    long lastRefill;

    TokenBucket(int maxTokens) {
        this.tokens = maxTokens;
        this.maxTokens = maxTokens;
        this.lastRefill = System.currentTimeMillis();
    }

    boolean allowRequest() {

        if (tokens > 0) {
            tokens--;
            return true;
        }

        return false;
    }
}

public class Main {

    static HashMap<String, TokenBucket> clients = new HashMap<>();

    public static boolean checkRateLimit(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(1000));

        TokenBucket bucket = clients.get(clientId);

        return bucket.allowRequest();
    }

    public static void main(String[] args) {

        String client = "abc123";

        for (int i = 0; i < 5; i++) {

            System.out.println(checkRateLimit(client)
                    ? "Request Allowed"
                    : "Rate Limit Exceeded");
        }
    }
}
