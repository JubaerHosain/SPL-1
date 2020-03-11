package ArithmeticExpression;

public class PostfixToPrefix {
    private PostfixToInfix PI;
    private InfixToPrefix IP;

    public PostfixToPrefix(){
        PI = new PostfixToInfix();
        IP = new InfixToPrefix();
    }

    public String Converter(String Postfix){
       String Infix, Prefix;

       Infix = PI.Converter(Postfix);
       Prefix = IP.Converter(Infix);

       return Prefix;
    }

    public static void main(String args[]){
        PostfixToPrefix PI = new PostfixToPrefix();

        System.out.println(PI.Converter("abcd^efgh*+^-*+i-"));
    }
}
