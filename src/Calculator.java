import java.util.ArrayDeque;
import java.util.LinkedList;

public class Calculator {

    public Calculator () {}

    public static double postfix(LinkedList<String> postfix){

        ArrayDeque<Double> q = new ArrayDeque<>();

        // temp 안 쓰고 pop 순서와 계산 순서가 맞아 떨어지게 할 방법이 있을까?
        double temp;

        for(int i=0; i < postfix.size(); i++){
            if(OperatorTypes.isOperator(postfix.get(i))){
                switch(OperatorTypes.toOperatorType(postfix.get(i))){
                    case PLUS:
                        temp = q.pop();
                        q.push(q.pop() + temp);
                        break;
                    case MINUS:
                        temp = q.pop();
                        q.push(q.pop() - temp);
                        break;
                    case MULTI:
                        temp = q.pop();
                        q.push(q.pop() * temp);
                        break;
                    case DIVIDE:
                        temp = q.pop();
                        if(temp == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");

                        q.push(q.pop() / temp);
                        break;
                    case SQUARE:
                        temp = q.pop();
                        q.push(Math.pow(q.pop(),temp));
                        break;
//                    case ROUND_BRACKET_S:
//                        break;
//                    case ROUND_BRACKET_E:
//                        break;
//                    case PERCENT:
//                        q.push(q.pop()/100);
//                        break;
                }
            } else q.push(Double.parseDouble(postfix.get(i)));
        }
        return q.pop();
    }

}
