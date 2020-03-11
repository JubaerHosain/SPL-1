package ArithmeticExpression;

public class InfixToPostfix {
    private Stack<Character> S;

    public InfixToPostfix(){
        S = new Stack<Character>();
    }

    public String Convert(String infix){
        String Postfix = "";
        char Infix[] = infix.toCharArray();
        int i;

        i=0;
        while (i < Infix.length){
            if(isOperand(Infix[i])){
                Postfix += Infix[i];
            }
            else if(Infix[i] == '('){
                S.push(Infix[i]);
            }
            else if(Infix[i] == ')'){
                while (S.top() != '(' && !S.isEmpty()){
                    Postfix += S.top();
                    S.pop();
                }

                if(S.top() == '('){                        // Special case
                    S.pop();
                }
            }
            else if(isOperator(Infix[i])){
                while (!S.isEmpty() && precedence(S.top()) >= precedence(Infix[i])){
                    Postfix += S.top();
                    S.pop();
                }
                S.push(Infix[i]);
            }

            i++;
        }

        while (!S.isEmpty()){
            Postfix += S.top();
            S.pop();
        }

        return Postfix;
    }

    private boolean isOperand(char ch){
        if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isOperator(char ch){
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'){
            return true;
        }
        else {
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

    public static void main(String args[]){
        InfixToPostfix E = new InfixToPostfix();
        System.out.println(E.Convert("((a+(b*(((c^d)-e)^(f+(g*h)))))-i)"));
    }
}
