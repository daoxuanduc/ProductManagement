public class MyStack<T> {
    Node<T> head;

    void push(T item) {
        Node<T> newNode = new Node<>(item, head);
        head = newNode;
    }
}
