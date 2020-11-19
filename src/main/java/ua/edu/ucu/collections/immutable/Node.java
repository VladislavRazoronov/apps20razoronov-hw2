package ua.edu.ucu.collections.immutable;

public class Node{
    Object value;
    Node next;
    public Node(Object x, Node nxt){
        value = x;
        next = nxt;
    }

    public void setNext(Node nxt){
        next = nxt;
    }

    public Node getNext(){
        return next;
    }

    public Object getValue(){
        return value;
    }

    public void setValue(Object obj){
        value = obj;
    }
}