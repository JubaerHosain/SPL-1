package ArithmeticExpression;

public class PostfixToInfix {
    private Stack<String> S;

    public PostfixToInfix(){
        S = new Stack<String>();
    }

    public String Converter(String Postfix){
        char postfix[] = Postfix.toCharArray();
        int i;
        String str1, str2;

        i=0;
        while (i < postfix.length){
            if(isOperand(postfix[i])){
                S.push(postfix[i] + "");
            }
            else if(isOperator(postfix[i])){
                str1 = S.top();
                S.pop();
                str2 = S.top();
                S.pop();

                S.push("(" + str2 + postfix[i] + str1 + ")");
            }
            i++;
        }

        return S.top();
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

    public static void main(String args[]){
        PostfixToInfix PI = new PostfixToInfix();

        System.out.println(PI.Converter("ABC/-AK/L-*"));
    }
}
