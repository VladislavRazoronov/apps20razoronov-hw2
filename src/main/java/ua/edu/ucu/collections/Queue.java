package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList buffer;

    public Queue() {
        buffer = new ImmutableLinkedList();
    }

    public void enQueue(Object obj) {
        buffer = buffer.addFirst(obj);
    }

    public Object deQueue() {
        Object item = buffer.getLast();
        buffer = buffer.removeLast();
        return item;
    }
}