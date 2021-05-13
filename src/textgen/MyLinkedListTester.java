/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    	shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet() {
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		    
		}
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove() {
	    
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		int b = longerList.remove(9);
		assertEquals("Remove: check a is correct ", 9, b);
		
		try {
			longerList.get(9);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		    
		}
		assertEquals("Remove: check size is correct ", 9, longerList.size());
		
		int c = longerList.remove(5);
		assertEquals("Remove: check a is correct ", 5, c);
		System.out.println(longerList.get(5));
		assertEquals("Remove: check element at position 5", (Integer)6, longerList.get(5));
		
		try {
			shortList.remove(3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		    
		}
		
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		    
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd() {

    	    shortList.add("C");
    	    assertEquals("Newly added element", "C", shortList.get(2));
    	    assertEquals("Check size", 3, shortList.size()); 
    	    
    	    try {
    		shortList.add(null);
    		fail("Check NullPointer");
    	    }
    	    catch (NullPointerException e) {
    	
    	    }
    	    
    	    emptyList.add(10);
    	    assertEquals("Newly added element ", (Integer)10, emptyList.get(0));
    	    assertEquals("Check size", 1, emptyList.size()); 
    	    
    	    longerList.add(11);
    	    longerList.add(12);
    	    longerList.add(13);
    	    assertEquals("Newly added element", (Integer)13, longerList.get(12));
    	    assertEquals("Check size", 13, longerList.size());    
	}

	
	/** Test the size of the list */
	@Test
	public void testSize() {

    	    	assertEquals("Check size of shortList", 2, shortList.size()); 
    	    	assertEquals("Check size of emptyLis", 0, emptyList.size()); 
    	    	assertEquals("Check size of longerList", 10, longerList.size());  
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex() {
	    
	    shortList.add(2, "C");
	    System.out.println(shortList.get(1));
	    assertEquals("Newly added element", "C", shortList.get(2));
	    assertEquals("Check size", 3, shortList.size()); 
	    
	    try {
		shortList.add(10, null);
		fail("Check NullPointer");
	    }
	    catch (NullPointerException e) {
	
	    }
	    
	    list1.add(0, 40);
	    assertEquals("Newly added element ", (Integer)40, list1.get(0));
	    assertEquals("element at position 1 ", (Integer)65, list1.get(1));
	    assertEquals("Check size", 4, list1.size());
	    
	    longerList.add(5, 10);
	    assertEquals("Newly added element ", (Integer)10, longerList.get(5));
	    assertEquals("Check size", 11, longerList.size());
	    
	    try {
		longerList.add(-1, 0);
		fail("Check Index Out of Bounds");
	    }
	    catch (IndexOutOfBoundsException e) {
	
	    }
	    
	    try {
		longerList.add(15, 15);
		fail("Check Index Out of Bounds");
	    }
	    catch (IndexOutOfBoundsException e) {
	
	    }	
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet() {
	    shortList.set(1, "C");
	    assertEquals("Newly set element", "C", shortList.get(1));
	    assertEquals("Check size", 2, shortList.size()); 
	    
	    try {
		shortList.set(0, null);
		fail("Check NullPointer");
	    }
	    catch (NullPointerException e) {
	
	    }
	    
	    list1.set(0, 40);
	    assertEquals("Newly set element ", (Integer)40, list1.get(0));
	    assertEquals("Check size", 3, list1.size());
	    
	    longerList.set(5, 15);
	    assertEquals("Newly added element ", (Integer)15, longerList.get(5));
	    assertEquals("Check size", 10, longerList.size());
	    
	    try {
		longerList.set(-1, 0);
		fail("Check Index Out of Bounds");
	    }
	    catch (IndexOutOfBoundsException e) {
	
	    }
	    
	    try {
		longerList.set(15, 15);
		fail("Check Index Out of Bounds");
	    }
	    catch (IndexOutOfBoundsException e) {
	
	    }    
	}
}
