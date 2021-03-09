import Exceptions.MalformedExpressionException;

import java.util.ArrayList;

public class Client {
    private CalculatorVisitor visitor = new CalculatorVisitor();

    public int evaluateExpression(ArrayList<Token> tokenList){
        for (Token t: tokenList) {
            t.accept(visitor);
        }
        try{
            return visitor.getResult();
        }catch (MalformedExpressionException e){
            throw new RuntimeException("Malformed Exception");
        }
    }

    public static void main(String[] args) {
        Client client = new Client();

        ArrayList<Token> tokenArrayList = new ArrayList<>();

        tokenArrayList.add(new Operand(5));
        tokenArrayList.add(new Operand(2));
        tokenArrayList.add(new Operator(Operation.PLUS));

        int res = client.evaluateExpression(tokenArrayList);
        System.out.println("5 + 2 = " + res);
    }
}
