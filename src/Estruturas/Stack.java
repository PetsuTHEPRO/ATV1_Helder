package Estruturas;

import Util.EstruturaDeDados;
import java.util.EmptyStackException;
import java.util.List;

class Node<T> {
    private T element;
    private Node<T> next;

    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

public class Stack<T> implements EstruturaDeDados<T> {

    private Node<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public Stack(List<T> data) {
        this();
        this.createStructure(data);
    }

    @Override
    public void createStructure(List<T> data) {
        for (T dado : data) {
            push(dado);
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T element) {
        top = new Node<>(element, top);
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T elementRemoved = top.getElement();
        top = top.getNext();
        size--;

        return elementRemoved;
    }

    public T remove(T element) {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        if (top.getElement().equals(element)) {
            return pop();
        }

        Node<T> current = top;
        while (current.getNext() != null && !current.getNext().getElement().equals(element)) {
            current = current.getNext();
        }

        if (current.getNext() == null) {
            throw new RuntimeException("Element not found in the stack");
        }

        T elementRemoved = current.getNext().getElement();
        current.setNext(current.getNext().getNext());
        size--;

        return elementRemoved;
    }

    public boolean seek(T element) {
        Node<T> current = top;
        while (current != null) {
            if (current.getElement().equals(element)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public StringBuilder print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = top;
        while (current != null) {
            sb.append(current.getElement()).append(" ");
            current = current.getNext();
        }
        sb.append("]");

        return sb;
    }

    public int size() {
        return size;
    }
}
