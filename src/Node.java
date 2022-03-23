public class Node<T> {
    T info;
    Node next;

    public Node() {
    }

    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }

    public String toString() {
        return info.toString();
    }
}
