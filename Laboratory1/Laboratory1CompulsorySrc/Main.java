
public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");
        hello1();
        Main m = new Main();
        m.compulory();
        //int n = Integer.parseInt(args[0]); citire de la tastatura Homework
    }
    private void compulory() {

        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);//1 milion, pot scoate "_" dar il las pentru citire mai usoara

        n = n * 3;
        n = n + 0b10101;//21
        n = n + 0xFF;//225
        n = n * 6;

        int sum = 0;
        while(n > 0){//cum fac cu while( Homework)
            sum = sum + n % 10;
            n = n / 10;
        } System.out.println(sum);

        n = 0;
       while(sum > 0){
            n = n + sum % 10;
            sum = sum / 10;
        }
        if( n == 9)
            System.out.println(n);
        else {System.out.println("Not right!"); System.out.println(n);}

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
    private static void hello1(){ // a doua varianta o fac si pe ea statica  daca vrem sa mearga
        System.out.println("Hello!" + Math.random());
    }
}
//cfrasinaru