import Exceptions.EmptyListException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackTest {
    private LinkedStack<Integer> linkedStack = new LinkedStack<Integer>();

    @Test
    public void checkIfListIsInitialized(){
        assertFalse(linkedStack.list == null);
    }
    @Test
    public void listIsNotEmptyAfterAdditionToList()
    {
        linkedStack.push(1);
        assertFalse(linkedStack.list.isEmpty());
    }

    @Test
    public void addToStack(){
        linkedStack.push(2);
        linkedStack.push(3);
        assertTrue(linkedStack.list.size() != 0);
    }

    @Test
    public void getFromTheStackWhenItIsEmpty(){
        assertThrows(EmptyListException.class, ()-> linkedStack.pop());
    }

    @Test
    public void getFromTheStackWhenIsNotEmpty(){
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        assertTrue(!linkedStack.list.isEmpty());
    }



}
