import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest<T> {

    private Node node;

    @BeforeEach
    @Test
    public void dataIsAddedByConstructor()
    {
        node = new Node(3);
        assertTrue((int) node.getData() == 3);
    }

    @Test
    public void getDataInsertedData(){
        int number = (int) node.getData();
        assertTrue(number== 3);
    }

    @Test
    public void getNullableData()
    {
        node.setData(null);
        assertTrue(node.getData() == null);
    }

    @Test
    public void setNode(){
        node.setNext(new Node(4));
        assertTrue(node.getNext() != null);
    }

    @Test
    public void getNullableNext(){
        assertTrue(node.getNext() == null);
    }


}