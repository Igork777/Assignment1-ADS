public class Node<T> {
    T data;
    Node next;
    public Node(T data) { //constructor is not on the class diagram
        this.data = data;
    }

    void setData(T data){
        data = data;
    }
    T getData(){
        return data;
    }
    void setNext(Node Node){
        next = Node;
    }
    Node getNext(){
        return next;
    }
}
