public enum OperatorTypes {
    PLUS('+', 1, 2),
    MINUS('-', 1, 2),
    MULTI('*', 2, 2),
    DIVIDE('/', 2, 2),
    SQUARE('^', 3, 2); // ,
//    ROUND_BRACKET_S('(', 4, 0),
//    ROUND_BRACKET_E(')', 4, 0),
//    PERCENT('%', 4, 1);


    private char operator;

    private int priority;

    private int operand;

    private OperatorTypes(char operator, int priority, int operand) {
        this.operator = operator;
        this.priority = priority;
        this.operand = operand;
    }

    public char operator(){
        return operator;
    }

    public int priority(){
        return priority;
    }

    public int operand(){
        return operand;
    }

    // 허용하는 연산자인가?
    public static boolean isOperator(char op){
        for(OperatorTypes i : OperatorTypes.values()){
            if (op == i.operator) return true;
        }
        return false;
    }

    public static boolean isOperator(String op){
        return isOperator(op.charAt(0));
    }

    // 이걸 해야하나? OperatorTypes를 받아서 연산하는게 맞지 않나?
    public static int getPriority(char op){
        for(OperatorTypes i : OperatorTypes.values()){
            if (op == i.operator) return i.priority;
        }
        return 0;
    }
    public static int getPriority(String op){
        return (getPriority(op.charAt(0)));
    }

    public static int getOperand(char op){
        for(OperatorTypes i : OperatorTypes.values()){
            if (op == i.operator) return i.operand;
        }
        return -1;
    }
    public static int getOperand(String op){
        return getOperand(op.charAt(0));
    }

    public static OperatorTypes toOperatorType(char op){
        for(OperatorTypes i : OperatorTypes.values()){
            if (op == i.operator) return i;
        }
        return null;
    }

    public static OperatorTypes toOperatorType(String op){
        return OperatorTypes.toOperatorType(op.charAt(0));
    }

}
