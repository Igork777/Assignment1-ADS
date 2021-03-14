import Exceptions.EmptyListException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<Integer> linkedList = new LinkedList<Integer>();
    @Test
    public void aLinkedListIsEmpty(){
        assertTrue( linkedList.size() == 0);
    }

    @Test
    public void aLinkedListIsNotEmpty(){
        linkedList.addToFront(3);
        assertTrue(linkedList.size() > 0);
    }

    @Test
    public void testExceptionGetFirstElementWhenListIsEmpty(){
        assertThrows(EmptyListException.class, () -> linkedList.removeFirst());
    }

    @Test
    public void successfulyRemovingTheFirstItem() throws EmptyListException {
        linkedList.addToFront(3);
        linkedList.addToFront(4);
        linkedList.addToFront(5);
        assertTrue(linkedList.removeFirst() == 5);
    }
}