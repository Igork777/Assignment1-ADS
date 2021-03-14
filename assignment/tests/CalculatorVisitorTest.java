import Exceptions.MalformedExpressionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorVisitorTest {
    private CalculatorVisitor calculatorVisitor = new CalculatorVisitor();

    @Test
    public void checkExceptionStackHasNotOnly1ResultAfterCalculation() {
        calculatorVisitor.visit(new Operand(5));
        calculatorVisitor.visit(new Operand(6));
        calculatorVisitor.visit(new Operand(7));
        calculatorVisitor.visit(new Operator(Operation.MINUS));
        assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    public void checkExceptionTryingToAddOperationInTheBeginning() {

        assertThrows(RuntimeException.class, () -> calculatorVisitor.visit(new Operator(Operation.MINUS)));
    }

    @Test
    public void checkExceptionPopFromEmptyStack() {
        assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    public void checkThePostFixExpressionResult() throws MalformedExpressionException {
        calculatorVisitor.visit(new Operand(5));
        calculatorVisitor.visit(new Operand(6));
        calculatorVisitor.visit(new Operand(7));
        calculatorVisitor.visit(new Operator(Operation.PLUS));
        calculatorVisitor.visit(new Operator(Operation.PLUS));
        assertTrue(calculatorVisitor.getResult() == 18);
    }
}
