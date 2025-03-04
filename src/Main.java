import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s;

        while(true) {

            s = sc.nextLine();
            if(s.equals("exit")) return;
            System.out.println(s);
        }

    }
}