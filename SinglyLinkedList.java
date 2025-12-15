package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * CS-2420 Assignment 6: LinkedListStack. This class creates a singly linked
 * list that will be used in other classes to help simulate how a web browser
 * visits webpages.
 * 
 * @author Natalie Hicks and Judy Ojewia
 * @version 2/29/2024
 * @param <E> - any generic type to be used throughout the class
 */
public class SinglyLinkedList<E> implements List<E> {

	private Node head;
	private int elementCount;

	/**
	 * This constructor creates a new empty singly linked list.
	 */
	public SinglyLinkedList() {
		head = null;
		elementCount = 0;
	}

	/**
	 * This private nested class represents a node, and is used for node creation
	 * throughout the outer class
	 * 
	 * @author Natalie Hicks and Judy Ojewia
	 * @version 2/29/2024
	 */
	private class Node {
		public Node next;
		public E data;

		/**
		 * This constructor creates a new node object to be used in the outer class
		 * 
		 * @param data - the generic element to be added to the node
		 * @param next - the next node object to be linked
		 */
		public Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * This method inserts an element at the beginning of the linked list.
	 * 
	 * @param element - the generic element to be added to the node
	 */
	public void insertFirst(E element) {
		Node temp = head;
		head = new Node(element, temp);
		elementCount++;
	}

	/**
	 * This mthod inserts an element at a specific position in the list.
	 * 
	 * @param index   - the specified position
	 * @param element - the generic element to add
	 * @throws IndexOutOfBoundsException - this exception is thrown if the index is
	 *                                   out of range less than zero or greater than
	 *                                   the size of the list
	 */
	public void insert(int index, E element) throws IndexOutOfBoundsException {
		if (index < 0 || index > elementCount) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			insertFirst(element);
		} else {
			Node prevNode = getNode(index - 1);
			prevNode.next = new Node(element, prevNode.next);
			elementCount++;
		}
	}

	/**
	 * This method gets the first element in the list
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException - this exception is thrown if the list is
	 *                                empty
	 */
	public E getFirst() throws NoSuchElementException {
		if (elementCount <= 0) {
			throw new NoSuchElementException();
		}
		return head.data;
	}

	/**
	 * This method gets the element at a specific position in the list
	 * 
	 * @param index - an int reprepsenting the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException - this exception is thrown if the index is
	 *                                   out of range less than zero or greater than
	 *                                   the size of the list
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	/**
	 * This method deletes and returns the first element from the list
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	public E deleteFirst() throws NoSuchElementException {
		if (elementCount <= 0) {
			throw new NoSuchElementException();
		}
		Node temp = head;
		head = head.next;
		elementCount--;
		return temp.data;
	}

	/**
	 * This method deletes and returns the element at a specific position in the
	 * list. O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 ||
	 *                                   index >= size())
	 */
	public E delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		Node shifted = this.getNode(index - 1);
		Node deleted = this.getNode(index);
		shifted.next = getNode(index + 1);
		elementCount--;
		return deleted.data;

	}

	/**
	 * This method determines the index of the first occurrence of the specified
	 * element in the list, or -1 if this list does not contain the element.
	 * 
	 * @param element - the element to search for
	 * @return the index of the first occurrence or -1 if the element is not found
	 */
	public int indexOf(E element) {
		int index = 0;
		for (int i = 0; i <= elementCount; i++) {
			if (getNode(i).data.equals(element)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	/**
	 * This method return the numer of elements in the list
	 * 
	 * @return the number of elements in the list
	 */
	public int size() {
		return elementCount;
	}

	/**
	 * This method returns true if this collection contains no elements, and false
	 * otherwise
	 * 
	 * @return true if this collection contains no elements or false, otherwise
	 */
	public boolean isEmpty() {
		if (elementCount == 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method removes all of the elements from this list
	 */
	public void clear() {
		this.head = null;
		this.elementCount = 0;

	}

	/**
	 * This method generates an array containing all of the elements in this list in
	 * proper sequence (from first element to last element)
	 * 
	 * @return an array containing all of the elements in this list, in order
	 */
	public Object[] toArray() {
		if (this.size() == 0)
			return new Object[0];
		Object[] arr = new Object[elementCount];
		for (int i = 0; i < elementCount; i++) {
			arr[i] = getNode(i).data;
		}
		return arr;
	}

	/**
	 * This method creates and returns an iterator to iterate over the elements in
	 * proper sequence (from first to last element)
	 * 
	 * @return an iterator over the elements in this list in proper sequence (from
	 *         first element to last element)
	 */
	public Iterator<E> iterator() {
		return new SinglyLinkedListIterator();
	}

	/**
	 * This private helper method retrieves the node at the given position. NOTE: It
	 * is a precondition that pos >= 0.
	 * 
	 * @param pos - 0-indexed position of the node
	 * @return the node at int pos
	 */
	private Node getNode(int pos) {
		Node temp = head;
		for (int i = 0; i < pos; i++) {
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * This private class creates an iterator for use in the outer class.
	 * 
	 * @author Natalie Hicks and Judy Ojewia
	 * @version 2/29/2024
	 */
	private class SinglyLinkedListIterator implements Iterator<E> {
		int next = 0;
		boolean canRemove = false;

		/**
		 * This method returns true if there is an element that can still be iterated
		 * over and false if there are no more elements to iterate over
		 */
		public boolean hasNext() {
			return next < elementCount;
		}

		/**
		 * This method iterates over the next element of the list
		 */
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			canRemove = true;
			E current = get(next);
			next++;
			return current;
		}

		/**
		 * This method removes an element from the list
		 */
		public void remove() {
			if (!canRemove) {
				throw new IllegalStateException();
			}
			next--;
			canRemove = false;
			delete(next);
		}
	}

}
