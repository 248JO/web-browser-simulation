package assign06;

import java.util.NoSuchElementException;

/**
 * CS-2420 Assignment 6: LinkedListStack. This class represents a stack which
 * will help to simulate how a web browser visits webpages.
 * 
 * @author Natalie Hicks and Judy Ojewia
 * @version 2/29/2024
 * @param <E> - any generic type to be used throughout the class
 */
public class LinkedListStack<E> implements Stack<E> {
	private SinglyLinkedList<E> list;

	/**
	 * This constructor initilizes the stack with its backing linked list
	 */
	public LinkedListStack() {
		this.list = new SinglyLinkedList<E>();
	}

	/**
	 * This method removes all of the elements from the stack.
	 */
	public void clear() {
		this.list.clear();

	}

	/**
	 * This method returns true if the stack contains no elements and false,
	 * otherwise.
	 * 
	 * @return true if the stack contains no elements and false, otherwise.
	 */
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	/**
	 * This method returns, but does not remove, the element at the top of the
	 * stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	public E peek() throws NoSuchElementException {
		if (this.list.size() == 0) {
			throw new NoSuchElementException();
		}
		return list.getFirst();

	}

	/**
	 * Returns and removes the item at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	public E pop() throws NoSuchElementException {
		if (this.list.size() == 0) {
			throw new NoSuchElementException();
		}
		return this.list.deleteFirst();
	}

	/**
	 * Adds a given element to the stack, putting it at the top of the stack.
	 * 
	 * @param element - the element to be added
	 */
	public void push(E element) {
		this.list.insertFirst(element);

	}

	/**
	 * This method returns the number of elements in the stack
	 * 
	 * @return the number of elements in the stack
	 */
	public int size() {
		return this.list.size();
	}

}
