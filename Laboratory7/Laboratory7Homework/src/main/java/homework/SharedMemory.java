package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SharedMemory {
    private final List<Token> tokenList;
    private int flag = 0;
    public SharedMemory(int n) {
        this.tokenList = new ArrayList<>();
        for (int index = 1; index <= Math.pow(n, 3); index++) {
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
            if (index >= this.tokenList.size()) {
                break;
            }
            if(this.tokenList.size() == 3){
                extracted.addAll(this.tokenList);
                this.tokenList.removeAll(this.tokenList);
                break;
            }else {
                extracted.add(this.tokenList.get(index));
                this.tokenList.remove(index);
            }
        }
        return extracted;
    }
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        System.out.println("The flag was set on 1");
        this.flag = flag;
    }
}