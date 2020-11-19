package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList{
    Node start;
    Node end;

    public ImmutableLinkedList(){
        start = null;
        end = null;
    }

    public ImmutableLinkedList(Object[] contents){
        start = new Node(contents[0],null);
        Node temp = start;
        for(int i = 1; i < contents.length; i++){
            temp.setNext(new Node(contents[i], null));
            temp = temp.getNext();
        }
        end = temp;
    }

    public ImmutableLinkedList CopyList(){
        ImmutableLinkedList newList = new ImmutableLinkedList();
        newList.start = new Node(start.getValue(),null);
        Node temp = start.getNext();
        Node temp1 = newList.start;
        while(temp.getNext() != null){
            temp1.setNext(new Node(temp.getValue(), null));
            if(temp1.getNext() == null)newList.end = temp1;
            temp = temp.getNext();
            temp1 = temp1.getNext();
        }

        return newList;
    }

    public ImmutableLinkedList add(Object obj){
        ImmutableLinkedList newList = CopyList();
        Node temp = newList.end;
        temp.setNext(new Node(obj, null));
        end = temp.getNext();
        return newList;
    }

    public ImmutableLinkedList add(int index, Object obj) throws IndexOutOfBoundsException{
        ImmutableLinkedList newList = CopyList();
        Node temp = newList.start;
        int count = 0;
        while(temp.getNext() != null){
            if(count == index){
                Node t = temp.getNext();
                temp.setNext(new Node(obj, t));
                if(t == null) end = temp.getNext();
                return newList;
            }
            count++;
            temp = temp.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    public ImmutableLinkedList addAll(Object[] values){
        ImmutableLinkedList newList = CopyList();
        Node temp = newList.end;
        for(Object obj: values){
            temp.setNext(new Node(obj, null));
            temp = temp.getNext();
        }
        end = temp;
        return newList;
    }

    public ImmutableLinkedList addAll(int index, Object[] values)throws IndexOutOfBoundsException{
        ImmutableLinkedList newList = CopyList();
        Node temp = newList.start;
        int count =0;
        while(temp.getNext() != null){
            if(count == index){
                Node t = temp.getNext();
                for(Object obj: values){
                    temp.setNext(new Node(obj, null));
                    temp = temp.getNext();
                }
                if(t == null){
                    end = temp;
                }
                temp.setNext(t);
                return newList;
            }
            count++;
            temp = temp.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    public Object get(int index)throws IndexOutOfBoundsException{
        Node temp = start;
        int count = 0;
        while(temp.getNext() != null){
            if(count == index){
                return temp.getValue();
            }
            count++;
            temp = temp.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    public ImmutableLinkedList remove(int index)throws IndexOutOfBoundsException{
        ImmutableLinkedList newList = CopyList();
        Node temp = newList.start;
        int count = 0;
        while(temp.getNext() != null){
            if(count == index - 1){
                temp.setNext(temp.getNext().getNext());
                return newList;
            }
            count++;
            temp = temp.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    public ImmutableLinkedList set(int index, Object obj)throws IndexOutOfBoundsException{
        ImmutableLinkedList newList = CopyList();
        Node temp = newList.start;
        int count = 0;
        while(temp.getNext() != null){
            if(count == index){
                temp.setValue(obj);
            }
            count++;
            temp = temp.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    public int indexOf(Object obj){
        Node temp = start;
        int count = 0;
        while(temp.getNext() != null){
            if(temp.getValue().equals(obj)){
                return count;
            }
            temp = temp.getNext();
            count++;
        }
        return -1;
    }

    public int size(){
        Node temp = start;
        int count = 0;
        while(temp.getNext() != null) {
            temp = temp.getNext();
            count++;
        }
        return count;
    }

    public ImmutableLinkedList clear(){
        return new ImmutableLinkedList();
    }

    public boolean isEmpty(){
        return start == null;
    }

    public Object[] toArray(){
        Object[] arr = new Object[size()];
        Node temp = start;
        int index = 0;
        while(temp.getNext() != null){
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
        while(temp.getNext() != null){
            str.append(temp.getValue());
            str.append(" ");
            temp = temp.getNext();
        }
        str.append("\n");
        return str.toString();
    }

    public ImmutableLinkedList addFirst(Object obj){
        ImmutableLinkedList newList = CopyList();
        Node temp = newList.start;
        newList.start = new Node(obj, temp);
        return newList;
    }

    public ImmutableLinkedList addLast(Object obj){
        ImmutableLinkedList newList = CopyList();
        newList.end.setNext(new Node(obj, null));
        newList.end = newList.end.getNext();
        return newList;
    }

    public Object getFirst(){
        return start.getValue();
    }

    public Object getLast(){
        return end.getValue();
    }

    public ImmutableLinkedList removeFirst(){
        ImmutableLinkedList newList = CopyList();
        newList.start = newList.start.getNext();
        return newList;
    }

    public ImmutableLinkedList removeLast(){
        ImmutableLinkedList newList = CopyList();
        Node temp = newList.start;
        while(temp.getNext().getNext() != null){
            temp = temp.getNext();
        }
        newList.end = temp;
        temp.setNext(null);
        return  newList;
    }
}
