package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testEnQueueDequeue() {
        Queue que = new Queue();
        for(int i = 0; i<11; i++){
            que.enQueue(i);
        }
        for(int i = 0; i<5; i++){
            que.deQueue();
        }
        assertEquals(que.deQueue(),5);
    }
    
}
