import Exceptions.EmptyListException;

public class LinkedList<T> implements List<T>{
    Node<T> head;
    int size=0;

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public int size() {
        int size = 0;
        for(Node n = head; n.getNext() != null; n = n.getNext())
            size++;
        return size;
    }

    public void addToFront(T data)
    {
     Node<T> newNode = new Node<T>((T) data);
     newNode.setNext(head);
     head = newNode;
     size++;
    }


    @Override
    public T removeFirst() throws EmptyListException {
        if ( isEmpty() )
            throw new EmptyListException("LinkedList is empty");

        Node<T> temp = head;
        head = head.getNext();
        temp.setNext(null);
        size --;
        return temp.getData();
    }
}
