import java.util.Scanner;

public class Level1 {

    public static void main(String[] args) {

        String in;
        String operator;
        Scanner sc = new Scanner(System.in);

        int a, b;

        while (true) {
            System.out.println("Enter an integer. If you want to exit, type 'exit'");

            in = sc.nextLine();

            if (in.equals("exit")) return;

            System.out.println("1 : " + in + " | Enter next int");
            a = Integer.parseInt(in);

            b = sc.nextInt();

            System.out.println("1 : " + a + " | 2 : " + b);
            System.out.println("choose operator (+ - * /) : ");

            operator = sc.next();

            switch (operator) {
                case "+":
                    System.out.println(a + b);
                    break;
                case "-":
                    System.out.println(a - b);
                    break;
                case "*":
                    System.out.println(a * b);
                    break;
                case "/":
                    if(b==0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        break;
                    }
                    System.out.println(a / b);
                    break;
                default:
                    System.out.println("Invalid operator");
            }

            sc.nextLine();

        }
    }
}
