package QLTT_GiangDay;

public class LK<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LK() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
    public void insertAtEnd(E data) {
        Node newNode = new Node(data, null);
        if (isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
}
