package ArithmeticExpression;

public class PrefixToInfix {
    private Stack<String> S;
    private PostfixToInfix PI;

    public PrefixToInfix(){
        S = new Stack<String>();
        PI = new PostfixToInfix();
    }

    public String Converter(String Prefix){
        String Infix;

        Prefix = reverse(Prefix);
        Infix = PI.Converter(Prefix);
        Infix = reverse(Infix);


        return Infix;
    }

    private String reverse(String S){
        char string[] = S.toCharArray();
        int i, j, length;
        char temp;
        length = string.length;

        for(i=0,j=length-1;  i<=length/2;  i++,j--){
            if(string[j]=='(')
            {
                string[j]=')';
            }
            else if(string[j]==')')
            {
                string[j]='(';
            }

            temp = string[j];

            if(string[i]=='(')
            {
                string[i]=')';
            }
            else if(string[i]==')')
            {
                string[i]='(';
            }

            string[j]=string[i];
            string[i]=temp;
        }

        return String.valueOf(string);
    }

    public static void main(String args[]){
        PrefixToInfix pi = new PrefixToInfix();

        System.out.println(pi.Converter("*-A/BC-/AKL"));
    }
}
