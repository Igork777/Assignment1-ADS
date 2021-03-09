import Exceptions.MalformedExpressionException;

import java.util.ArrayList;
import java.util.Arrays;

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

        ArrayList<Token> tokenArrayList1 = new ArrayList<>(Arrays.asList(
            new Operand(5),
            new Operand(2),
            new Operator(Operation.PLUS),
            new Operand(1),
            new Operator(Operation.PLUS)
        ));
        System.out.println("5 + 2 + 1 = " + client.evaluateExpression(tokenArrayList1));

        ArrayList<Token> tokenArrayList2 = new ArrayList<>(Arrays.asList(
                new Operand(5),
                new Operand(2),
                new Operator(Operation.MINUS),
                new Operand(1),
                new Operator(Operation.MINUS)
        ));
        System.out.println("5 - 2 - 1 = " + client.evaluateExpression(tokenArrayList2));

        ArrayList<Token> tokenArrayList3 = new ArrayList<>(Arrays.asList(
                new Operand(5),
                new Operand(2),
                new Operator(Operation.MULTIPLY),
                new Operand(2),
                new Operator(Operation.MULTIPLY)
        ));
        System.out.println("5 * 2 * 2 = " + client.evaluateExpression(tokenArrayList3));
    }
}
