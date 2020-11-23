package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testAdd() {
        Object[] arr ={1,2,3,4,5};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        ImmutableLinkedList newLst = lst.add(10);
        assertEquals(newLst.get(5),10);
        newLst = lst.add(1, 4);
        assertEquals(newLst.get(1), 4);
        assertEquals(lst.get(1), 2);
    }

    @Test
    public void testAddAll() {
        Object[] arr = {1, 2, 3, 4, 5};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        Object[] arr1 = {6, 7, 8, 9};
        ImmutableLinkedList newLst = lst.addAll(arr1);
        assertEquals(newLst.get(7), 8);
        newLst = lst.addAll(3, arr1);
        assertEquals(newLst.get(5), 7);
        assertEquals(lst.get(4), 5);
    }

    @Test
    public void testSet(){
        Object[] arr = {5,6,7,4,3,9};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        ImmutableLinkedList newLst = lst.set(3, 8);
        assertEquals(newLst.get(3), 8);
        assertEquals(lst.get(3), 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmpty(){
        ImmutableLinkedList lst = new ImmutableLinkedList();
        ImmutableLinkedList newLst = lst.set(2, 2);
    }

    @Test
    public void testRemove(){
        Object[] arr = {5,6,7,4,3,9};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        ImmutableLinkedList newLst = lst.remove(3);
        assertEquals(newLst.get(3), 3);
        assertEquals(lst.get(3), 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmpty(){
        ImmutableLinkedList lst = new ImmutableLinkedList();
        ImmutableLinkedList newLst = lst.remove(3);
    }

    @Test
    public void testSize(){
        Object[] arr = {2,3,1,433,6,43,29,0};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        assertEquals(lst.size(), 8);
    }

    @Test
    public void testIndex(){
        Object[] arr = {"We","you","they","I","he"};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        assertEquals(lst.indexOf("you"),1);
    }

    @Test
    public void testIndexNotIn(){
        Object[] arr = {"We","you","they","I","he"};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        assertEquals(lst.indexOf("hello"),-1);
    }

    @Test
    public void testClear(){
        Object[] arr = {1,2,23,3221};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        ImmutableLinkedList newLst = lst.clear();
        assertEquals(newLst.size(), 0);
        assertEquals(lst.size(), 4);
    }

    @Test
    public void testIsEmpty(){
        Object[] arr = {1};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        ImmutableLinkedList ls = new ImmutableLinkedList();
        assertFalse(lst.isEmpty());
        assertTrue(ls.isEmpty());
    }

    @Test
    public void testToArray(){
        Object[] arr = {1,2,3,4,5,6};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        Object[] result = lst.toArray();
        assertArrayEquals(result, arr);
    }

    @Test
    public void testString(){
        Object[] arr = {"Hello,","World!"};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        String result = lst.toString();
        assertEquals(result,"Hello, World! ");
    }

    @Test
    public void testAddFirst(){
        Object[] arr = {1,32,21,11};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        ImmutableLinkedList newLst = lst.addFirst(23);
        assertEquals(newLst.getFirst(), 23);
    }

    @Test
    public void testRemoveFirst(){
        Object[] arr = {1,32,21,11};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        ImmutableLinkedList newLst = lst.removeFirst();
        assertEquals(newLst.getFirst(), 32);
    }

    @Test
    public void testAddLast(){
        Object[] arr = {1,32,21,11};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        ImmutableLinkedList newLst = lst.addLast(23);
        assertEquals(newLst.getLast(), 23);
    }

    @Test
    public void testRemoveLast(){
        Object[] arr = {1,32,21,11};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        ImmutableLinkedList newLst = lst.removeLast();
        assertEquals(newLst.getLast(), 21);
    }
}
