public class MyList<T> {
    Node<T> head;
    Node<T> tail;

    public MyList() {
    }

    public MyList(Node<T> head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return (head==null);
    }

    public int length() {
        int i=0;
        Node currentNode = head;
        while (currentNode!=null) {
            i++;
            currentNode = currentNode.next;
        }
        return i;
    }

    public void insert(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            head.next=tail;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    public void insertAfterPosition(int position, T item) {
        if (!isEmpty()&&position>=0) {
            int i=0;
            Node currentNode = head;
            while (i<=length()) {
                if (i==position) {
                    Node addNode = new Node(item,currentNode.next);
                    currentNode.next = addNode;
                }
                currentNode = currentNode.next;
                i++;
            }
        }
    }

    /*public void deleteTail() {
        Node currentNode = head;
        while (currentNode.next!=tail&&!isEmpty()) {
            currentNode = currentNode.next;
            if (currentNode.next==tail) {
                currentNode.next=null;
                break;
            }
        }
    }*/


    public void swap(Node<T> firstNode, Node<T> secondNode) {
        T info = firstNode.info;
        firstNode.info = secondNode.info;
        secondNode.info = info;
    }

    public void clear() {
        head.next = null;
    }
}
