import Exceptions.MalformedExpressionException;

import java.util.LinkedList;

public class CalculatorVisitor implements Visitor, Calculator {

    private LinkedList<Token> tokenStack;

    @Override
    public int getResult() throws MalformedExpressionException {
        return 0;
    }

    @Override
    public void visit(Operand operand) {
        pushOperand(operand);
    }

    private void pushOperand(Operand operand) {
        tokenStack.push(operand);
    }

    @Override
    public void visit(Operator operator) {
        try{
            performOperation(operator);
        }catch (MalformedExpressionException e) {
            throw new RuntimeException("Malformed Expression Exception");
        }
    }

    private void performOperation(Operator operator) throws MalformedExpressionException {
        Token op1 = tokenStack.pop();
        Token op2 = tokenStack.pop();

        if(!(op1 instanceof Operand) || !(op2 instanceof Operand)){
           throw new MalformedExpressionException();
        }

        Operand operator1 = (Operand) op1;
        Operand operator2 = (Operand) op2;


        if( operator.getOperation() == Operation.PLUS){
            Operand result = new Operand(operator1.getValue() + operator2.getValue());
            tokenStack.push(result);
        }

    }
}
