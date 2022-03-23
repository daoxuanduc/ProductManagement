public class MyQueue<T> {
    Node<T> head;
    Node<T> tail;

    boolean isEmpty() {
        return (head==null);
    }

    void enqueue(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
    }
}
