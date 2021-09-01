public class DoublyLinkedList <T> implements Iterable <T> {
    private int size = 0;
    private Node <T> head = null;
    private Node <T> tail = null;

    private class Node<T> {

        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        @Override public String toString() {
            return data.toString();
        }
    }

    public void clear() {
        Node<T> trav = head;
        while(trav != null){
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }
}