package compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SharedMemory {
    private final List<Token> tokenList;

    public SharedMemory(int n) {
        this.tokenList = new ArrayList<>();
        for (int index = 0; index < Math.pow(n, 3); index++) {
            this.tokenList.add(new Token(index));
        }
        Collections.shuffle(this.tokenList);
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int index = 0; index < howMany; index++) {
            if (this.tokenList.isEmpty()) {
                break;
            }
            if(index>=this.tokenList.size()){
                break;
            }
            extracted.add(this.tokenList.get(index));
            this.tokenList.remove(index);
        }
        return extracted;
    }


}