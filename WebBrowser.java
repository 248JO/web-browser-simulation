package assign06;

import java.net.URL;
import java.util.NoSuchElementException;

/**
 * CS-2420 Assignment 6: LinkedListStack. This class simulates how a web browser
 * visits webpages, especially how the back button shows the previous webpage
 * visited and how the forward button shows the next webpage.
 * 
 * @author Natalie Hicks and Judy Ojewia
 * @version 2/29/2024
 * @param <E> - any generic type to be used throughout the class
 */
public class WebBrowser {
	private LinkedListStack<URL> back;
	private LinkedListStack<URL> forward;
	private URL current;

	/**
	 * This constructor creates a new web browser with no previously-visited
	 * webpages and no webpages to visit next
	 */
	public WebBrowser() {
		this.back = new LinkedListStack<URL>();
		this.forward = new LinkedListStack<URL>();
	}

	/**
	 * This constructor creates a new web browser with a preloaded history of
	 * visited webpages, given as a list of URL objects
	 * 
	 * @param history - a list of URL objects
	 */
	public WebBrowser(SinglyLinkedList<URL> history) {
		this.forward = new LinkedListStack<URL>();
		this.back = new LinkedListStack<URL>();
		int size = history.size();
		for (int i = size - 1; i >= 0; i--) {
			forward.push(history.deleteFirst());
		}
		for (int i = size - 1; i >= 0; i--) {
			this.back.push(forward.pop());
		}
		if (back.size() > 0)
			this.current = back.pop();
	}

	/**
	 * This method simulates visiting a webpage, given a URL
	 * 
	 * @param webpage - a URL to simulate visiting a webpage
	 */
	public void visit(URL webpage) {
		this.forward.clear();
		if (current != null) {
			this.back.push(current);
		}
		this.current = webpage;
	}

	/**
	 * This method simulates using the back button, returning the URL visited
	 * 
	 * @return - the URL visited
	 * @throws NoSuchElementException - thrown if there is no previously-visited URL
	 */
	public URL back() {
		if (this.back.size() < 1)
			throw new NoSuchElementException("There are no previously visited URL's");
		this.forward.push(current);
		this.current = this.back.pop();
		return current;
	}

	/**
	 * This method simulates using the forward button, returning the URL visited
	 * 
	 * @return the URL visited
	 * @throws NoSuchElementException - this exception is thrown if there is no URL
	 *                                to visit next
	 */
	public URL forward() {
		if (this.forward.size() == 0)
			throw new NoSuchElementException("There are no previously visited URL's");
		this.back.push(current);
		current = this.forward.pop();
		return current;

	}

	/**
	 * This method generates a history of URLs visited, as a list of URL objects
	 * ordered from most recently visited to least recently visited
	 * 
	 * @return a list of URL objects ordered from most to least recent
	 */
	public SinglyLinkedList<URL> history() {
		SinglyLinkedList<URL> history = new SinglyLinkedList<URL>();
		LinkedListStack<URL> temp = new LinkedListStack<URL>();
		int size = back.size();
		for (int i = 0; i < size; i++) {
			temp.push(back.pop());
		}
		for (int j = size - 1; j >= 0; j--) {
			URL tempURL = temp.pop();
			history.insertFirst(tempURL);
			back.push(tempURL);
		}
		if (current != null) {
			history.insertFirst(current);
		}
		return history;
	}

}
