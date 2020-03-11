package ArithmeticExpression;

public class InfixEvaluation {
    private Stack<Long> Numbers;
    private Stack<Character> Operator;

    public InfixEvaluation(){
        Numbers = new Stack<Long>();
        Operator = new Stack<Character>();
    }

    public long evaluate(String infix){
        char Infix[] = infix.toCharArray();
        long output;
        int i;
        char ch;

        i=0;
        while (i < Infix.length) {
            ch = Infix[i];

            if(isDigit(ch)) {
                long number = 0;

                while (isDigit(ch)){
                    number = number * 10 + (ch - '0');
                    i++;
                    if(i < Infix.length){
                        ch = Infix[i];
                    }
                    else {
                        break;
                    }
                }
                i--;
                Numbers.push(number);
            }
            else if(ch == '('){
                Operator.push(ch);
            }
            else if(ch == ')'){
                while (Operator.top() != '(' && !Operator.isEmpty()){
                    output = performOperation();
                    Numbers.push(output);
                }
                Operator.pop();
            }
            else if(isOperator(ch)){
                 while (!Operator.isEmpty() && precedence(ch) < precedence(Operator.top())){
                     output = performOperation();
                     Numbers.push(output);
                 }
                 Operator.push(ch);
            }
            i++;
        }

        while (!Operator.isEmpty()){
            output = performOperation();
            Numbers.push(output);
        }

        return Numbers.top();
    }

    private boolean isDigit(char ch){
        if( ch>='0' && ch<='9' ){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
            return true;
        } else {
            return false;
        }
    }

    private int precedence(char ch){
        switch(ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            default:
                return -1;
        }
    }

    private long performOperation(){
        long a = Numbers.top();
        Numbers.pop();
        long b = Numbers.top();
        Numbers.pop();
        char operation = Operator.top();
        Operator.pop();
        long output;

        switch (operation){
            case '+':
                output = a + b;
                break;

            case '-':
                output = b - a;
                break;
            case '*':
                output = a * b;
                break;
            case '/':
                if (a == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return b / a;
            case '^':
                output = (long)Math.pow(b, a);
                break;
            default:
                output = 0;
        }

        return output;
    }

    public static void main(String args[]){
        InfixEvaluation i = new InfixEvaluation();

        System.out.println(i.evaluate("(500-200)-(34/5)^2+4"));
    }
}
