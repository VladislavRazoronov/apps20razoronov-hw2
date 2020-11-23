package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test
    public void testAdd() {
        Object[] arr ={1,2,3,4,5};
        ImmutableArrayList lst = new ImmutableArrayList(arr);
        ImmutableArrayList newLst = lst.add(10);
        assertEquals(newLst.get(5),10);
        newLst = lst.add(1, 4);
        assertEquals(newLst.get(1), 4);
        assertEquals(lst.get(1), 2);
    }

    @Test
    public void testAddAll() {
        Object[] arr = {1, 2, 3, 4, 5};
        ImmutableArrayList lst = new ImmutableArrayList(arr);
        Object[] arr1 = {6, 7, 8, 9};
        ImmutableArrayList newLst = lst.addAll(arr1);
        assertEquals(newLst.get(7), 8);
        newLst = lst.addAll(3, arr1);
        assertEquals(newLst.get(4), 7);
        assertEquals(lst.get(4), 5);
    }

    @Test
    public void testSet(){
        Object[] arr = {5,6,7,4,3,9};
        ImmutableArrayList lst = new ImmutableArrayList(arr);
        ImmutableArrayList newLst = lst.set(3, 8);
        assertEquals(newLst.get(3), 8);
        assertEquals(lst.get(3), 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmpty(){
        ImmutableArrayList lst = new ImmutableArrayList();
        ImmutableArrayList newLst = lst.set(2, 2);
    }

    @Test
    public void testRemove(){
        Object[] arr = {5,6,7,4,3,9};
        ImmutableArrayList lst = new ImmutableArrayList(arr);
        ImmutableArrayList newLst = lst.remove(3);
        assertEquals(newLst.get(3), 3);
        assertEquals(lst.get(3), 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmpty(){
        ImmutableArrayList lst = new ImmutableArrayList();
        ImmutableArrayList newLst = lst.remove(3);
    }

    @Test
    public void testSize(){
        Object[] arr = {2,3,1,433,6,43,29,0};
        ImmutableArrayList lst = new ImmutableArrayList(arr);
        assertEquals(lst.size(), 8);
    }

    @Test
    public void testIndex(){
        Object[] arr = {"We","you","they","I","he"};
        ImmutableArrayList lst = new ImmutableArrayList(arr);
        assertEquals(lst.indexOf("you"),1);
    }

    @Test
    public void testIndexNotIn(){
        Object[] arr = {"We","you","they","I","he"};
        ImmutableArrayList lst = new ImmutableArrayList(arr);
        assertEquals(lst.indexOf("hello"),-1);
    }

    @Test
    public void testClear(){
        Object[] arr = {1,2,23,3221};
        ImmutableArrayList lst = new ImmutableArrayList(arr);
        ImmutableArrayList newLst = lst.clear();
        assertEquals(newLst.size(), 0);
        assertEquals(lst.size(), 4);
    }

    @Test
    public void testIsEmpty(){
        Object[] arr = {1};
        ImmutableArrayList lst = new ImmutableArrayList(arr);
        ImmutableArrayList ls = new ImmutableArrayList();
        assertFalse(lst.isEmpty());
        assertTrue(ls.isEmpty());
    }

    @Test
    public void testToArray(){
        Object[] arr = {1,2,3,4,5,6};
        ImmutableArrayList lst = new ImmutableArrayList(arr);
        Object[] result = lst.toArray();
        assertArrayEquals(result, arr);
    }

    @Test
    public void testString(){
        Object[] arr = {"Hello,","World!"};
        ImmutableArrayList lst = new ImmutableArrayList(arr);
        String result = lst.toString();
        assertEquals(result,"Hello, World! ");
    }

}
