package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    Object[] arr;

    public ImmutableArrayList() {
        arr = new Object[0];
    }

    public ImmutableArrayList(Object[] items) {
        arr = items.clone();
    }

    public void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index > size()) throw new IndexOutOfBoundsException();
    }

    public ImmutableArrayList add(Object obj) {
        Object[] item = {
                obj
        };
        return addAll(item);
    }

    public ImmutableArrayList add(int index, Object obj) {
        Object[] item = {
                obj
        };
        return addAll(index, item);
    }

    public ImmutableArrayList addAll(Object[] items) {
        return addAll(size(), items);
    }

    public ImmutableArrayList addAll(int index, Object[] items) throws IndexOutOfBoundsException {
        checkIndex(index);
        Object[] newArr = new Object[size() + items.length];
        for (int i = 0; i < newArr.length; i++) {
            if (i >= index && i < index + items.length) {
                newArr[i] = items[i - index];
            }
            else if (i >= index + items.length) {
                newArr[i] = arr[i - items.length];
            }
            else {
                newArr[i] = arr[i];
            }
        }
        return new ImmutableArrayList(newArr);
    }

    public int size() {
        return arr.length;
    }

    public Object get(int index) {
        return arr[index];
    }

    public ImmutableArrayList set(int index, Object obj) throws IndexOutOfBoundsException {
        checkIndex(index);
        Object[] newArr = arr.clone();
        newArr[index] = obj;
        return new ImmutableArrayList(newArr);
    }

    public ImmutableArrayList remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        Object[] newArr = new Object[size() - 1];
        int i = 0;
        while (i < index) {
            newArr[i] = arr[i];
            i++;
        }
        i++;
        while (i < size()) {
            newArr[i - 1] = arr[i];
            i++;
        }
        return new ImmutableArrayList(newArr);
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size(); i++) {
            if (arr[i].equals(obj)) {
                return i;
            }
        }
        return - 1;
    }

    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Object[] toArray() {
        return arr.clone();
    }

    @Override
    public String toString() {
        StringBuffer st = new StringBuffer();
        for (Object obj: arr) {
            st.append(obj);
            st.append(' ');
        }
        return st.toString();
    }
}