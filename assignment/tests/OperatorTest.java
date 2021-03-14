import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    private Operator operator;

    @BeforeEach
    @Test
    public void addOperationToConstructor(){
        operator = new Operator(Operation.PLUS);
        assertTrue(operator.getOperation() != null);
    }

    @Test
    public void getOperationWhichIsNotInitialize()
    {
        operator = null;
        assertThrows(NullPointerException.class,() -> operator.getOperation());
    }



}