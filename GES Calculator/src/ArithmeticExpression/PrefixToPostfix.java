package ArithmeticExpression;

public class PrefixToPostfix {
    private PrefixToInfix PI;
    private InfixToPostfix IP;

    public PrefixToPostfix(){
        PI = new PrefixToInfix();
        IP = new InfixToPostfix();
    }

    public String Converter(String Prefix){
        String Infix, Postfix;
        Infix = PI.Converter(Prefix);
        Postfix = IP.Convert(Infix);

        return Postfix;
    }

    public static void main(String args[]){
        PrefixToPostfix PP = new PrefixToPostfix();

        System.out.println(PP.Converter("*-A/BC-/AKL"));
    }
}
