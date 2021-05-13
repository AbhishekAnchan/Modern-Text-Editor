package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		
	    head = new LLNode<E>(null);
	    tail = new LLNode<E>(null);
	    size = 0;
	    head.next = tail;
	    tail.prev = head;
	    
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) {

	    	if(element == null) {
	    	    throw new NullPointerException();
	    	}
	    
	    	LLNode<E> N = new LLNode<E>(element);
	    	N.next = tail;
	    	N.prev = tail.prev;
	    	tail.prev = N;
	    	N.prev.next = N;
	    	size++;
	    	return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) {

	    	LLNode<E> current = head.next;
	    	int i=0;
	    	while(current != tail) {
	    	    if(i == index) {
	    		return current.data;
	    	    }
		
	    	    i++;
	    	    current = current.next;
	    	}
	    
	    	throw new IndexOutOfBoundsException();
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) {

	    if(element == null) {
		throw new NullPointerException();
	    }
	    
	    LLNode<E> current = head;
	    int i=-1;
	    boolean flag = false;
	    
	    while(current != tail) {
		if(i == index-1) {
		    LLNode<E> N = new LLNode<E>(element);
		    N.next = current.next;
		    N.prev = current;
		    N.prev.next = N;
		    N.next.prev = N;
		    size++;
		    flag = true;
		    break;
		}
		
		i++;
		current = current.next;
	    }
	    
	    if(flag == false) {
		throw new IndexOutOfBoundsException();
	    }
	}


	/** Return the size of the list */
	public int size() {
	    	
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {
	    
	    LLNode<E> current = head;
	    int i=-1;
	    E data;
	    while(current != tail) {
		if(i == index-1) {
		    data = current.next.data;
		    current.next = current.next.next;
		    current.next.prev = current;
		    size--;
		    return data;
		}
		
		i++;
		current = current.next;	
	    }
	    
	    throw new IndexOutOfBoundsException();
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) {
		
    	    	if(element == null) {
    	    	    throw new NullPointerException();
    	    	}
	    
	    	LLNode<E> current = head;
	    	int i=-1;
	    	E data;
	    	while(current != tail) {
	    	    if(i == index-1) {
	    		data = current.next.data;
	    		current.next.data = element;
	    		return data;
	    	    }
		
	    	    i++;
	    	    current = current.next;
	    	}
	    
	    	throw new IndexOutOfBoundsException();
	}
	
	
	
	public void display() {
	    LLNode<E> current = head.next;
	    while(current != tail) {
		System.out.print(current.data +" ");
		current = current.next;
	    }
	    
	    System.out.println();
	}
}

class LLNode<E> {
    
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}
}