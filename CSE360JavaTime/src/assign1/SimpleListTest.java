//Author: Yamaan Khan
//Class ID: 439
//Assignment #: 1
//Description: Runs all the methods of the SimpleList class in junit tests 
//				to test for success of each method

package assign1;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimpleListTest {
	
	@Test
	public void testConstructor() {
		SimpleList testing = new SimpleList();
		//list is instantiated as 0 0 0 0 0 0 0 0 0 0
		//assertNull(testing);
		assertEquals(0, testing.count());
		assertEquals("", testing.toString());
	}

	@Test
	public void testAdd() {
		SimpleList testing = new SimpleList();
		testing.add(1);
		testing.add(2);
		testing.add(3);
		assertEquals("3 2 1", testing.toString());
		testing.add(4);
		testing.add(5);
		testing.add(6);
		testing.add(7);
		testing.add(8);
		testing.add(9);
		testing.add(10);
		//list = 10 9 8 7 6 5 4 3 2 1		
		testing.add(21);
		testing.add(22);
		testing.add(23);
		testing.add(24);
		testing.add(25);
		//list = 25 24 23 22 21 10 9 8 7 6
		assertTrue(testing.toString().equals("25 24 23 22 21 10 9 8 7 6"));
		assertFalse(testing.toString().equals("6 7 8 9 10 11 21 22 23 24 25"));
	}
	
	@Test
	public void testRemove() {
		SimpleList testing = new SimpleList();
		testing.add(1);
		testing.add(2);
		testing.add(3);
		testing.add(4);
		testing.add(5);
		testing.add(6);
		testing.add(7);
		testing.add(8);
		testing.add(9);
		testing.add(10);
		//list = 10 9 8 7 6 5 4 3 2 1
		testing.remove(7);
		testing.remove(3);
		testing.remove(9);
		//list = 10 8 6 5 4 2 1 0 0 0
		assertFalse(testing.toString().equals("10 8 6 5 4 2 1 0 0 0"));
		assertTrue(testing.toString().equals("10 8 6 5 4 2 1"));
	}
	
	@Test
	public void testCount() {
		SimpleList testing = new SimpleList();
		testing.add(5);
		testing.add(3);
		testing.add(2);
		testing.add(1);
		testing.add(51);
		//list = 51 1 2 3 5 0 0 0 0 0
		assertEquals(5, testing.count());	//expected 5 values in the list, 5 values were proven to be in the list
		assertNotEquals(4, testing.count());//expected 4 values in the list, 5 values are actually in the list
	}
	
	@Test
	public void testToString() {
		SimpleList testing = new SimpleList();
		testing.add(1);
		testing.add(2);
		testing.add(3);
		testing.add(4);
		//list = 4 3 2 1 0 0 0 0 0 0
		assertFalse(testing.toString().equals("4 3 2 1 0 0 0 0 0 0"));
		assertTrue(testing.toString().equals("4 3 2 1"));
	}
	
	@Test
	public void testSearch() {
		SimpleList testing = new SimpleList();
		testing.add(1);
		testing.add(2);
		testing.add(3);
		testing.add(4);
		testing.add(5);
		testing.add(6);
		testing.add(7);
		testing.add(8);
		testing.add(9);
		testing.add(10);
		//list = 10 9 8 7 6 5 4 3 2 1
		assertEquals(7, testing.search(3));		//expected 3 to be at index 7, was found at index 7
		assertNotEquals(9, testing.search(5));	//expected 5 to be at index 9, was found at index 5
		assertEquals(9, testing.search(1));	
	}
	
	//FAILED TEST
	@Test
	public void testNonExisting() {
		SimpleList testing = new SimpleList();
		testing.add(7);
		testing.add(5);
		testing.add(3);
		testing.add(3);
		testing.add(3);
		testing.add(3);
		testing.add(3);
		testing.add(3);
		testing.add(3);
		assertEquals(-1, testing.search(6));
		testing.add(3);
		assertEquals(-1, testing.search(6));
	}
	
	@Test
	public void testViewFirst() {
		SimpleList testing = new SimpleList();
		testing.add(6);
		testing.add(5);
		testing.add(5);
		testing.add(3);
		assertEquals(1 ,testing.search(5));
	}
	
	@Test
	public void testRemoveFirst() {
		SimpleList testing = new SimpleList();
		testing.add(6);
		testing.add(5);
		testing.add(3);
		testing.add(5);
		assertEquals("5 3 5 6", testing.toString());
		testing.remove(5);
		assertEquals("3 5 6", testing.toString());
	}
}
