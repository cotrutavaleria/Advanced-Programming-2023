package homework;
public class Token{
    private final int number;
    public Token (int n){
        this.number = n;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Token{" +
                "number=" + number +
                '}';
    }
}