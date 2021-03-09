import java.util.EmptyStackException;
import java.util.LinkedList;

public class LinkedStack<T> implements Stack<T> {

    private LinkedList<T> list = new LinkedList<T>();

    @Override
    public void push(T elem) {
        list.add(elem);
    }

    @Override
    public T pop() throws EmptyStackException {
        return list.pop();
    }
}
