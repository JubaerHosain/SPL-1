package ArithmeticExpression;



public class InfixToPrefix {
    private Stack<Character> S;
    private InfixToPostfix IP;

    public InfixToPrefix(){
        S = new Stack<Character>();
        IP = new InfixToPostfix();
    }

    public String Converter(String Infix){
        String Postfix, Prefix;

        Infix = reverse(Infix);
        Postfix = IP.Convert(Infix);
        Prefix = reverse(Postfix);


        return Prefix;
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
        InfixToPrefix ip = new InfixToPrefix();

        System.out.println(ip.Converter("(A-(B/C)*(A/K)-L)"));
    }
}
