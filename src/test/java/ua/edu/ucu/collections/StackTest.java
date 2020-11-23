package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testPushPop() {
        Stack  st = new Stack();
        for(int i = 0; i<11; i++){
            st.push(i);
        }
        for(int i = 0; i<4; i++){
            st.pop();
        }
        assertEquals(st.pop(),6);
    }
    
}
