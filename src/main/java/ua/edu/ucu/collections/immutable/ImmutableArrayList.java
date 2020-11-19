package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList {
    Object[] arr;

    public ImmutableArrayList(){
        arr = new Object[0];
    }

    public ImmutableArrayList(Object[] items){
        arr = items.clone();
    }

    public ImmutableArrayList add(Object obj){
        Object[] item = {obj};
        return addAll(item);
    }

    public ImmutableArrayList add(int index, Object obj){
        Object[] item = {obj};
        return addAll(index, item);
    }

    public ImmutableArrayList addAll(Object[] items){
        return addAll(size(), items);
    }

    public ImmutableArrayList addAll(int index, Object[] items) throws IndexOutOfBoundsException{
        if( index > size()){
            throw new IndexOutOfBoundsException();
        }
        Object[] newArr = new Object[size()+items.length];
        for(int i = 0; i< newArr.length; i++){
            if(i >= index && i < index+ items.length){
                newArr[i] = items[i - index];
            }
            else if( i >= index + items.length){
                newArr[i] = arr[i - items.length];
            }
            else{
                newArr[i] = arr[i];
            }
        }
        return new ImmutableArrayList(newArr);
    }

    public int size(){
        return arr.length;
    }
    
}
