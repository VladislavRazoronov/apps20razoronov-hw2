package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList buffer;

    public Stack() {
        buffer = new ImmutableLinkedList();
    }

    public void push(Object obj) {
        buffer = buffer.addFirst(obj);
    }

    public Object pop() {
        Object itm = buffer.getFirst();
        buffer = buffer.removeFirst();
        return itm;
    }

}