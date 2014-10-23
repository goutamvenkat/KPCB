import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BoundedQueueTest {
	int s1 = 10;
	BoundedQueue q;
	int[] array = {1,12,23,12,23,4};
	int[] array2 = {1,12,23,12,23,4,8,9,10,1,1};
	@Before
	public void setUp() throws Exception {
		q = new BoundedQueue(s1);
	}

	@Test
	public void testEnqueueLessThanS1() {
		for (int i : array) q.enqueue(i);
		assertEquals(q.size(), array.length);
	}
	@Test 
	public void testDequeueLessThanS1() {
		int i = 0;
		while (!q.isEmpty()) {
			assertEquals(q.dequeue(), Integer.toString(array[i++]));
		}
	}
	@Test 
	public void testEnqueueMoreThanS1() {
		for (int i : array2) q.enqueue(i);
		assertEquals(q.size(), 10);
	}
	@Test 
	public void testDequeueMoreThanS1() {
		int i = 0;
		while (!q.isEmpty()) {
			assertEquals(q.dequeue(), Integer.toString(array2[i++]));
		}
		assertEquals(q.dequeue(), "Queue is empty!");
	}
}
