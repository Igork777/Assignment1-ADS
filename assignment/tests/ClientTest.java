import Exceptions.MalformedExpressionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class ClientTest {
    private Client client;
    @Test
    public void InitializeAClient(){
        client = new Client();
        assertTrue(client != null);
    }

    @Test
    public void checkExceptionGetFromEmptyStack(){
        assertThrows(NullPointerException.class,()-> client.evaluateExpression(new ArrayList<>()));
    }

    @Test
    public void checkExceptionGetMoreThan1ResultInStack(){
        ArrayList<Token> tokenArrayList1 = new ArrayList<>(Arrays.asList(
                new Operand(5),
                new Operand(2),
                new Operator(Operation.PLUS),
                new Operand(1),
                new Operand(19),
                new Operator(Operation.PLUS)
        ));
       assertThrows(RuntimeException.class, ()->client.evaluateExpression(tokenArrayList1));
    }

    @Test
    public void checkCorrectResultInStack(){
        client = new Client();
        ArrayList<Token> tokenArrayList1 = new ArrayList<>(Arrays.asList(
                new Operand(5),
                new Operand(2),
                new Operator(Operation.PLUS),
                new Operand(1),
                new Operator(Operation.PLUS)
        ));
        assertTrue(client.evaluateExpression(tokenArrayList1) == 8);
    }
}
