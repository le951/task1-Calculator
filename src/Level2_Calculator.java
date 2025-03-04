import java.util.ArrayList;

public class Level2_Calculator {

    private int in1, in2;

    private char operator;

    private ArrayList<String> results = new ArrayList<>();

    public Level2_Calculator() {
        in1 = 0;
        in2 = 0;
        operator = ' ';
    }

    public void in1(int i){
        in1 = i;
    }

    public void in2(int i){
        in2 = i;
    }

    public void operator(char c){
        operator = c;
    }

    public int in1(){
        return in1;
    }

    public int in2(){
        return in2;
    }

    public char operator(){
        return operator;
    }

    public Level2_Calculator(int in1, int in2) {
        this.in1 = in1;
        this.in2 = in2;
    }

    public Level2_Calculator(int in1, int in2, char operator) {
        this.in1 = in1;
        this.in2 = in2;
        this.operator = operator;
    }

    public String result() {
        double result;
        switch (operator) {
            case '+':
                result = in1 + in2;
                break;
            case '-':
                result = in1 - in2;
                break;
            case '*':
                result = in1 * in2;
                break;
            case '/':
                result = (double) in1 / in2;
                break;
            default:
                return "Unknown operator";
        }
        results.add(in1 + " " + operator + " " + in2 + " = " + result);

        return results.getLast();
    }

    public String previous() {
        return results.toString();
    }

    // 사용성을 생각하면 마지막을 지우거나, results에 번호를 매겨 입력받아 지우는게 맞겠지만,
    // 일단 과제대로 마지막만 지움. 솔직히 귀찮기도 하고.
    public void remove(){
        results.removeLast();
    }

    public void clear(){
        results.clear();
    }


}
