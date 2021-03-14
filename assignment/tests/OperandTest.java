import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperandTest {
    private Operand operand;
    @BeforeEach
    @Test
    public void addValueToOperandUsingConstructor(){
        operand = new Operand(4);
        assertTrue(operand.getValue() != 0);
    }

    @Test
    public void getOperandValueWhichIsNotInitialize()
    {
        operand = null;
        assertThrows(NullPointerException.class, ()-> operand.getValue());
    }
}