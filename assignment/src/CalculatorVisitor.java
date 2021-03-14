import Exceptions.EmptyListException;
import Exceptions.MalformedExpressionException;

public class CalculatorVisitor implements Visitor, Calculator {

    private final LinkedStack<Token> tokenStack = new LinkedStack<Token>();

    @Override
    public int getResult() throws MalformedExpressionException {
        if (tokenStack.list.size != 1) {
            throw new MalformedExpressionException();
        } else {
            try {
                return ((Operand) tokenStack.pop()).getValue();
            } catch (EmptyListException e) {
                throw new MalformedExpressionException();
            }
        }
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
        try {
            performOperation(operator);
        } catch (MalformedExpressionException e) {
            throw new RuntimeException("Malformed Expression Exception");
        }
    }

    private void performOperation(Operator operator) throws MalformedExpressionException {
        Token op1;
        Token op2;

        try {
            op1 = tokenStack.pop();
            op2 = tokenStack.pop();
        } catch (EmptyListException e) {
            throw new MalformedExpressionException();
        }

        if (!(op1 instanceof Operand) || !(op2 instanceof Operand)) {
            throw new MalformedExpressionException();
        }

        Operand operator1 = (Operand) op1;
        Operand operator2 = (Operand) op2;

        if (operator.getOperation() == Operation.PLUS) {
            Operand result = new Operand(operator2.getValue() + operator1.getValue());
            tokenStack.push(result);
        } else if (operator.getOperation() == Operation.MINUS) {
            Operand result = new Operand(operator2.getValue() - operator1.getValue());
            tokenStack.push(result);
        } else if (operator.getOperation() == Operation.MULTIPLY) {
            Operand result = new Operand(operator2.getValue() * operator1.getValue());
            tokenStack.push(result);
        }

    }
}
