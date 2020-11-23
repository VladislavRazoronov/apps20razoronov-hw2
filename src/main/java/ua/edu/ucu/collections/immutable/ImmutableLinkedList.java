package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    Node start;

    public ImmutableLinkedList() {
        start = new Node(null, null);
    }

    public ImmutableLinkedList(Object[] contents) {
        start = new Node(contents[0], null);
        Node temp = start;
        for (int i = 1; i < contents.length; i++) {
            temp.setNext(new Node(contents[i], null));
            temp = temp.getNext();
        }
    }

    public Node end() {
        Node temp = start;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp;
    }

    public ImmutableLinkedList CopyList() {
        ImmutableLinkedList newList = new ImmutableLinkedList();
        newList.start = new Node(start.getValue(), null);
        Node temp = start.getNext();
        Node temp1 = newList.start;
        while (temp != null) {
            temp1.setNext(new Node(temp.getValue(), null));
            temp = temp.getNext();
            temp1 = temp1.getNext();
        }

        return newList;
    }

    public ImmutableLinkedList add(Object obj) {
        ImmutableLinkedList newList = CopyList();
        if (newList.start.getValue() == null) {
            newList.start.setValue(obj);
            return newList;
        }
        newList.end().setNext(new Node(obj, null));
        return newList;
    }

    public ImmutableLinkedList add(int index, Object obj) throws IndexOutOfBoundsException {
        ImmutableLinkedList newList = CopyList();
        if (newList.start.getValue() == null) {
            if (index > 1) throw new IndexOutOfBoundsException();
            newList.start.setValue(obj);
            return newList;
        }
        Node temp = newList.start;
        int count = 1;
        while (temp.getNext() != null) {
            if (count == index) {
                Node t = temp.getNext();
                temp.setNext(new Node(obj, t));
                return newList;
            }
            count++;
            temp = temp.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    public ImmutableLinkedList addAll(Object[] values) {
        ImmutableLinkedList newList = CopyList();
        int i = 0;
        if (newList.start.getValue() == null) {
            newList.start.setValue(values[0]);
            i = 1;
        }
        Node temp = newList.end();
        while (i < values.length) {
            temp.setNext(new Node(values[i], null));
            temp = temp.getNext();
            i++;
        }
        return newList;
    }

    public ImmutableLinkedList addAll(int index, Object[] values) throws IndexOutOfBoundsException {
        if (start.getValue() == null) {
            if (index > 1) throw new IndexOutOfBoundsException();
            return add(values);
        }
        ImmutableLinkedList newList = CopyList();
        Node temp = newList.start;
        int count = 0;
        while (temp.getNext() != null) {
            if (count == index) {
                Node t = temp.getNext();
                for (Object obj: values) {
                    temp.setNext(new Node(obj, null));
                    temp = temp.getNext();
                }
                temp.setNext(t);
                return newList;
            }
            count++;
            temp = temp.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        Node temp = start;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                if (temp.getValue() == null) throw new IndexOutOfBoundsException();
                return temp.getValue();
            }
            count++;
            temp = temp.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    public ImmutableLinkedList remove(int index) throws IndexOutOfBoundsException {
        if (start.getValue() == null) throw new IndexOutOfBoundsException();
        ImmutableLinkedList newList = CopyList();
        Node temp = newList.start;
        int count = 0;
        while (temp.getNext() != null) {
            if (count == index - 1) {
                temp.setNext(temp.getNext().getNext());
                return newList;
            }
            count++;
            temp = temp.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    public ImmutableLinkedList set(int index, Object obj) throws IndexOutOfBoundsException {
        if (start.getValue() == null) throw new IndexOutOfBoundsException();
        ImmutableLinkedList newList = CopyList();
        Node temp = newList.start;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                temp.setValue(obj);
                return newList;
            }
            count++;
            temp = temp.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    public int indexOf(Object obj) {
        if (start.getValue() == null) return - 1;
        Node temp = start;
        int count = 0;
        while (temp.getNext() != null) {
            if (temp.getValue().equals(obj)) {
                return count;
            }
            temp = temp.getNext();
            count++;
        }
        return - 1;
    }

    public int size() {
        if (start.getValue() == null) return 0;
        Node temp = start;
        int count = 0;
        while (temp != null) {
            temp = temp.getNext();
            count++;
        }
        return count;
    }

    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    public boolean isEmpty() {
        return start.getValue() == null;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size()];
        Node temp = start;
        int index = 0;
        while (temp.getNext() != null) {
            arr[index] = temp.getValue();
            temp = temp.getNext();
            index++;
        }
        arr[index] = temp.getValue();
        return arr;
    }

    @Override
    public String toString() {
        Node temp = start;
        StringBuilder str = new StringBuilder();
        while (temp != null) {
            str.append(temp.getValue());
            str.append(" ");
            temp = temp.getNext();
        }
        return str.toString();
    }

    public ImmutableLinkedList addFirst(Object obj) {
        ImmutableLinkedList newList = CopyList();
        Node temp = newList.start;
        newList.start = new Node(obj, temp);
        return newList;
    }

    public ImmutableLinkedList addLast(Object obj) {
        ImmutableLinkedList newList = CopyList();
        if (newList.start.getValue() == null) {
            newList.start.setValue(obj);
            return newList;
        }
        Node temp = newList.end();
        temp.setNext(new Node(obj, null));
        return newList;
    }

    public Object getFirst() {
        return start.getValue();
    }

    public Object getLast() {
        return end().getValue();
    }

    public ImmutableLinkedList removeFirst() {
        ImmutableLinkedList newList = CopyList();
        if (start.getValue() == null) {
            return newList;
        }
        newList.start = newList.start.getNext();
        return newList;
    }

    public ImmutableLinkedList removeLast() {
        ImmutableLinkedList newList = CopyList();
        if (start.getValue() == null) {
            return newList;
        }
        Node temp = newList.start;
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        return newList;
    }
}