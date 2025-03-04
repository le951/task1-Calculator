import java.util.Scanner;

public class Level2 {

    public static void main(String[] args) {

        Level2_Calculator calculator = new Level2_Calculator();
        Scanner sc = new Scanner(System.in);

        String input;

        while (true) {
            System.out.println("Enter an integer. If you want to exit, type 'exit'");
            System.out.println("if you want to show previous results, enter 'previous'");

            input = sc.nextLine();

            switch (input) {
                case "exit" -> {
                    return;
                }
                case "previous" -> {
                    System.out.println(calculator.previous());
                    System.out.println("""
                            If you want to remove previous results, enter 'remove'
                            if you want to remove ALL previous results, enter 'clear'
                            
                            """);
                }
                case "remove" -> calculator.remove();
                case "clear" -> calculator.clear();
                default -> {
                    System.out.println("1 : " + input + " | Enter next int");
                    calculator.in1(Integer.parseInt(input));

                    calculator.in2(sc.nextInt());

                    System.out.println("1 : " + calculator.in1() + " | 2 : " + calculator.in2());
                    System.out.println("choose operator (+ - * /) : ");

                    calculator.operator(sc.next().charAt(0));

                    System.out.println(calculator.result());

                    sc.nextLine();
                }
            }

        }
    }
}
