package compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SharedMemory {
    private final List<Token> tokens = new ArrayList<>();
    public SharedMemory(int n) {
        for(int i=1; i<=n; i++){
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
    }
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        synchronized (tokens) {
            for (int i = 0; i < howMany; i++) {
                if (tokens.isEmpty()) {
                    break;
                }
                extracted.add(tokens.get(0));
                tokens.remove(tokens.get(0));
            }
            return extracted;
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }


}
