package Lezione12;

public class UnboundedListStack<E> implements Stack<E> {
    private int size = 0;
    private Node<E> head = null;

    @Override
    public void push(E e) {
        head = new Node<>(e, head);
        size++;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public E pop() {
        if (head == null) throw new EmptyStackException("Stack is empty");
        E info = head.info;
        head = head.next;
        size--;
        return info;
    }

    @Override
    public E top() {
        if (head == null) throw new EmptyStackException("Stack is empty");
        return head.info;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private static class Node<E> {
        E info;
        Node<E> next;

        public Node(E info, Node<E> next) {
            this.info = info;
            this.next = next;
        }
    }


}
