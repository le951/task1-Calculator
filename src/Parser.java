import java.util.*;


public class Parser {
    // 중위식 : 연산 순서를 분석하여 통째로 Queue. 직전과 이어지는건? 끊어지는건?
    // 후위식 : 값과 연산자를 분리하여 Queue
    // 미완성 식 분석 (GUI 실시간 반영용)

    // 중위식, 후위식은 return 할 때 선택?

    // 입력은 모두 중위식
    ArrayList<String> input = new ArrayList<>();
    private LinkedList<String> infix = new LinkedList<String>(), postfix = new LinkedList<String>();

    // infix를 사용한다면 LinkedList 그대로 제공. 우선순위 연산.
    // postfix를 사용한다면 Queue로 제공. Stack으로 순차 연산.
    // Stack에 숫자와 연산자가 그대로 들어가야 하는데. 그냥 String으로 통합해서 넣자. 어차피 아직 변환 안했잖아.

    // 결과적으로 infix는 Parser가 짧아지되 Calculator가 길어지고
    // postfix는 반대. Parser가 길어지되 Calculator는 짧아진다.

    // infix: 451 + 984 * 815 * ( 87 + 84 )
    // postfix: 451 984 815 * 87 84 + * +

    Parser(String input) {
        this.input.add(input);

        // 공백 제거.
        input = input.replace(" ", "");


        // infix: 연산자 탐색 후 분할
        // Operator 탐색 (지원 문자열 한정. 그 외 오류처리 필요)

        int current = 0;

        // 이거 필요한가? 그냥 합쳤더니 필요 없어진거 같은데. 일단 완성하고 필요한 것만 남기자.
        LinkedHashMap<Integer, OperatorTypes> operator_Index = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            for (OperatorTypes op : OperatorTypes.values()) {
                if (input.charAt(i) == op.operator()) {

                    infix.add(input.substring(current, i));
                    infix.add(input.substring(i, i + 1));
                    current = i + 1;

                    operator_Index.put(infix.size() - 1, op);
                }
            }
        }

        infix.add(input.substring(current));

        // throw 오류 처리 필요. 검사를 먼저 싹 진행하는게 맞나? 괄호, 불완전 식, 입력 제한,
        // 입력 값 제한. (허용 문자만. 숫자, 연산자)

        // 괄호 짝 확인
        // 연산자 별 연산에 사용할 값 확인.
        // 위는 Parser 후 처리.
        // 입력 제한은 GUI에서 실시간으로? eventListener?
        if (operator_Index.isEmpty()) return;


        // postfix: 연산 우선순위에 따라 처리
        // % = 직전 1개.
        // () = 순서 조절

        // 연산 순서에 따라 차곡차곡 전환하는게 될까?
        // infix: 451 + 984 * 815 * ( 87 + 84 )
        // postfix: 451 984 815 * 87 84 + * +

        // 451 984 +
        // 451 984 815 * +
        // 451 984 815 * 87 84 + * +

        // 51 * 5 ^ 2 - 5 + 3 / 2

        // 51 5 *
        // 51 5 2 ^ *
        // 51 5 2 ^ * 5 -
        // 51 5 2 ^ * 5 - 3 +
        // 51 5 2 ^ * 5 - 3 2 / +

        // 일단 첫 숫자는 집어넣고, 연산자에 따라 행동?
        // 피연산자가 없으면 연속된 숫자로 판단한다. 연산자가 아닌 입력 중 공백은 제거하고, 나머지는 오류를 반환한다.
        // () :
        // * : 이전 연산자와 우선순위 판별 후 높으면 <-, 낮거나 같으면 ->
        // n항연산. 현재는 1항 / 2항만. 3항부터는 f()로 만드는게 낫겠는데?

        // 숫자 / 연산자를 판별한다.
        // 숫자인 경우 집어넣는다.
        // 연산자인 경우 직전 연산자와 우선순위를 비교한다.
        // 다음 피연산자를 먼저 넣는다.
        //

        // () 들어갈 때가 문제네. 아직 감이 안잡혀. 빼고 구현.
        // 첫 연산자는 비교할게 없는데. 어차피 비교하려면 이전 좌표가 있어야 하네.
        // 굳이 operator_index 필요 없이 int 하나면 되겠고.
        // % 일 때, () 일 때, 이런거 묶어낼 방법이 없나?


        current = 0;
        OperatorTypes current_operator = null;

        // operator_Index 0번 값을 읽는다.
        // 직전 필드의 값을 push 한다.
        // 2항 이상의 연산자인 경우

        // 시작이 () 일 때가 문제인가? 숫자값이 들어올 때 까지
        // 이러면 괄호가 스킵되어 버리는데. 다시 분리해야 하나. for문 두 번 돌려서?

        // (10)% 같은게 가능하지. 이거 처리해줘야 하네.

        for (int i : operator_Index.keySet()) {
            if (current == 0) {
                if (operator_Index.get(i).operand() != 0) {
                    postfix.add(infix.get(i - 1));
                    current = i;
                    current_operator = operator_Index.get(i);
                    break;
                }
            }
        }

        for (int i : operator_Index.keySet()) {
            if (current == i){

            }

            // operand? name? priority?
            // operand 대로 묶음. 0은 별도 처리를 위해 빼둠. 괄호 말고 또 0에 들어갈게 있나?
            switch (operator_Index.get(i)) {
                // 괄호는 별도로 빼서 toPostfix 하고 통째로 피연산자 취급해서 더해야 하나?
//                case ROUND_BRACKET_S:
//                case ROUND_BRACKET_E:
//                    break;
                case PLUS:
                case MINUS:
                case MULTI:
                case DIVIDE:
                case SQUARE:
                    if(operator_Index.get(i).priority() > current_operator.priority()){
                        postfix.add(current, infix.get(i+1));
                        postfix.add(current+1, infix.get(i));
                        current_operator = operator_Index.get(i);
                        current++;
                    } else {
                        postfix.add(infix.get(i+1));
                        postfix.add(infix.get(i));
                        current_operator = operator_Index.get(i);
                        current = postfix.size()-1;
                    }
//                    System.out.println(postfix);
                    break;

                // 현재 방식 (첫 숫자 .add / 이후 피연산자 + 연산자 하나씩 add)
                // 이 방식으로는 operand 1개 경우 오류 발생.
//                case PERCENT:
//                    if(operator_Index.get(i).priority() > current_operator.priority()){
//                        postfix.add(current, infix.get(i+1));
//                        postfix.add(current+1, infix.get(i));
//                        current_operator = operator_Index.get(i);
//                        current++;
//                    } else {
//                        postfix.add(infix.get(i+1));
//                        postfix.add(infix.get(i));
//                        current_operator = operator_Index.get(i);
//                        current = postfix.size()-1;
//                    }
//                    break;
//                default:
//                    throw new IllegalStateException("Unexpected value: " + operator_Index.get(i));
            }
        }

    }


    public LinkedList<String> infix() {
        return this.infix;
    }


    // 굳이 List 대신 Queue를 고집할 필요는 없지.
    // LinkedList도 Queue Interface 상속받고.
    // 이후 실시간 구현한다 하면 LinkedList로 바꾸는게 낫겠네. 어차피 상속받으니.
    // 이거 Queue로 무언가 제한해줄 수 있다고 했던거 같은데.
    public LinkedList<String> postfix() {
        return this.postfix;
    }

}
