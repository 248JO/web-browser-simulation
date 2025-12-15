package assign06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.awt.Point;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * CS-2420 Assignment 6: LinkedListStack This is the tester class for the
 * LinkedListStack class
 * 
 * @author Judy Ojewia and Natalie Hicks
 * @version 2/29/2024
 */
public class LinkedListStackTester {
	private LinkedListStack<Integer> test1, empty, large, expectedLarge;
	private LinkedListStack<String> small, oneValue;
	private LinkedListStack<Point> points, medium, expectedMedium;

	@BeforeEach
	public void setup() {
		test1 = new LinkedListStack<Integer>();
		empty = new LinkedListStack<Integer>();
		large = new LinkedListStack<Integer>();
		expectedLarge = new LinkedListStack<Integer>();
		small = new LinkedListStack<String>();
		oneValue = new LinkedListStack<String>();
		points = new LinkedListStack<Point>();
		medium = new LinkedListStack<Point>();
		expectedMedium = new LinkedListStack<Point>();

		test1.push(0);
		test1.push(1);
		test1.push(2);
		test1.push(3);
		test1.push(4);

		small.push("29");
		small.push("30");
		small.push("31");
		small.push("hello");

		oneValue.push("goodbye");

		points.push(new Point(0, 0));
		points.push(new Point(0, 1));
		points.push(new Point(0, 2));
		points.push(new Point(0, 3));
		points.push(new Point(0, 4));
		
		for(int j = 0; j < 15; j++) {
			medium.push(new Point(j,j));
			expectedMedium.push(new Point(j,j));
		}
		
		for (int i = 0; i < 50; i++) {
			large.push(i);
			expectedLarge.push(i);
		}

	}

	// test LinkedListStack() -------------------------------------------------

	@Test
	public void testLinkedListStack() {
		LinkedListStack<Integer> expected = new LinkedListStack<Integer>();
		expected.push(0);
		expected.push(1);
		expected.push(2);
		expected.push(3);
		expected.push(4);

		for (int i = 0; i < test1.size(); i++) {
			assertEquals(expected.pop(), test1.pop());
		}
	}

	@Test
	public void testLinkedListStackEmpty() {
		LinkedListStack<Integer> expected = new LinkedListStack<Integer>();
		assertEquals(expected.size(), empty.size());
	}

	@Test
	public void testLinkedListStackSmallList() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("29");
		expected.push("30");
		expected.push("31");
		expected.push("hello");

		for (int i = 0; i < small.size(); i++) {
			assertEquals(expected.pop(), small.pop());
		}
	}

	@Test
	public void testLinkedListStackMediumList() {
		for (int i = 0; i < medium.size(); i++) {
			assertEquals(expectedMedium.pop(), medium.pop());
		}
	}
	
	@Test
	public void testLinkedListStackLargeList() {
		for (int i = 0; i < large.size(); i++) {
			assertEquals(expectedLarge.pop(), large.pop());
		}
	}

	@Test
	public void testLinkedListStackOneValue() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("goodbye");
		assertEquals(expected.pop(), oneValue.pop());
	}

	@Test
	public void testLinkedListStackDifferentType() {
		LinkedListStack<Point> expected = new LinkedListStack<Point>();
		expected.push(new Point(0, 0));
		expected.push(new Point(0, 1));
		expected.push(new Point(0, 2));
		expected.push(new Point(0, 3));
		expected.push(new Point(0, 4));
		for (int i = 0; i < points.size(); i++) {
			assertEquals(expected.pop(), points.pop());
		}
	}

	// test clear() -------------------------------------------------

	@Test
	public void testclear() {
		LinkedListStack<Integer> expected = new LinkedListStack<Integer>();
		expected.push(0);
		expected.push(1);
		expected.push(2);
		expected.push(3);
		expected.push(4);
		expected.clear();
		test1.clear();
		assertEquals(expected.size(), test1.size());
	}

	@Test
	public void testclearEmpty() {
		LinkedListStack<Integer> expected = new LinkedListStack<Integer>();
		empty.clear();
		expected.clear();
		assertEquals(expected.size(), empty.size());
	}

	@Test
	public void testclearSmallList() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("29");
		expected.push("30");
		expected.push("31");
		expected.push("hello");
		expected.clear();
		small.clear();
		assertEquals(expected.size(), small.size());
	}
	
	@Test
	public void testclearMediumList() {
		expectedMedium.clear();
		medium.clear();
		assertEquals(expectedMedium.size(), medium.size());
	}

	@Test
	public void testclearLargeList() {
		expectedLarge.clear();
		large.clear();
		assertEquals(expectedLarge.size(), large.size());
	}

	@Test
	public void testclearOneValue() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("goodbye");
		expected.clear();
		oneValue.clear();
		assertEquals(expected.size(), oneValue.size());
	}

	@Test
	public void testclearDifferentType() {
		LinkedListStack<Point> expected = new LinkedListStack<Point>();
		expected.push(new Point(0, 0));
		expected.push(new Point(0, 1));
		expected.push(new Point(0, 2));
		expected.push(new Point(0, 3));
		expected.push(new Point(0, 4));
		expected.clear();
		points.clear();
		assertEquals(expected.size(), points.size());
	}

	// test isEmpty() -------------------------------------------------

	@Test
	public void testisEmpty() {
		LinkedListStack<Integer> expected = new LinkedListStack<Integer>();
		expected.push(0);
		expected.push(1);
		expected.push(2);
		expected.push(3);
		expected.push(4);
		assertEquals(expected.isEmpty(), test1.isEmpty());
	}

	@Test
	public void testisEmptyEmpty() {
		LinkedListStack<Integer> expected = new LinkedListStack<Integer>();
		assertEquals(expected.isEmpty(), empty.isEmpty());
	}

	@Test
	public void testisEmptySmall() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("29");
		expected.push("30");
		expected.push("31");
		expected.push("hello");
		assertEquals(expected.isEmpty(), small.isEmpty());
	}
	
	@Test
	public void testisEmptyMedium() {
		assertEquals(expectedMedium.isEmpty(), medium.isEmpty());
	}

	@Test
	public void testisEmptyLarge() {
		assertEquals(expectedLarge.isEmpty(), large.isEmpty());
	}

	@Test
	public void testisEmptyOneValue() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("goodbye");
		assertEquals(expected.isEmpty(), oneValue.isEmpty());
	}

	@Test
	public void testisEmptyDifferentType() {
		LinkedListStack<Point> expected = new LinkedListStack<Point>();
		expected.push(new Point(0, 0));
		expected.push(new Point(0, 1));
		expected.push(new Point(0, 2));
		expected.push(new Point(0, 3));
		expected.push(new Point(0, 4));
		assertEquals(expected.isEmpty(), points.isEmpty());
	}

	// test peek() -------------------------------------------------
	@Test
	public void testpeek() {
		LinkedListStack<Integer> expected = new LinkedListStack<Integer>();
		expected.push(0);
		expected.push(1);
		expected.push(2);
		expected.push(3);
		expected.push(4);
		assertEquals(expected.peek(), test1.peek());
	}

	@Test
	public void testpeekSmall() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("29");
		expected.push("30");
		expected.push("31");
		expected.push("hello");
		assertEquals(expected.peek(), small.peek());
	}

	@Test
	public void testpeekMedium() {
		assertEquals(expectedMedium.peek(), medium.peek());
	}
	
	@Test
	public void testpeekLarge() {
		assertEquals(expectedLarge.peek(), large.peek());
	}

	@Test
	public void testpeekOneValue() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("goodbye");
		assertEquals(expected.peek(), oneValue.peek());
	}

	@Test
	public void testpeekDifferentType() {
		LinkedListStack<Point> expected = new LinkedListStack<Point>();
		expected.push(new Point(0, 0));
		expected.push(new Point(0, 1));
		expected.push(new Point(0, 2));
		expected.push(new Point(0, 3));
		expected.push(new Point(0, 4));
		assertEquals(expected.peek(), points.peek());
	}

	@Test
	public void testpeekEmptyException() {
		assertThrows(NoSuchElementException.class, () -> {
			empty.peek();
		}, "The method failed to throw " + "the OutOfRangeException");
	}

	// test pop() -------------------------------------------------

	@Test
	public void testpop() {
		LinkedListStack<Integer> expected = new LinkedListStack<Integer>();
		expected.push(0);
		expected.push(1);
		expected.push(2);
		expected.push(3);
		expected.push(4);

		for (int i = 0; i < test1.size(); i++) {
			assertEquals(expected.pop(), test1.pop());
		}
	}

	@Test
	public void testpopSmall() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("29");
		expected.push("30");
		expected.push("31");
		expected.push("hello");

		for (int i = 0; i < small.size(); i++) {
			assertEquals(expected.pop(), small.pop());
		}
	}

	@Test
	public void testpopMedium() {
		for (int i = 0; i < medium.size(); i++) {
			assertEquals(expectedMedium.pop(), medium.pop());
		}
	}
	
	@Test
	public void testpopLarge() {
		for (int i = 0; i < large.size(); i++) {
			assertEquals(expectedLarge.pop(), large.pop());
		}
	}

	@Test
	public void testpopOneVlaue() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("goodbye");
		assertEquals(expected.pop(), oneValue.pop());
	}

	@Test
	public void testpopDifferentType() {
		LinkedListStack<Point> expected = new LinkedListStack<Point>();
		expected.push(new Point(0, 0));
		expected.push(new Point(0, 1));
		expected.push(new Point(0, 2));
		expected.push(new Point(0, 3));
		expected.push(new Point(0, 4));
		for (int i = 0; i < points.size(); i++) {
			assertEquals(expected.pop(), points.pop());
		}
	}

	@Test
	public void testpopEmptyException() {
		assertThrows(NoSuchElementException.class, () -> {
			empty.pop();
		}, "The method failed to throw " + "the OutOfRangeException");
	}

	// test push() -------------------------------------------------

	@Test
	public void testpush() {
		LinkedListStack<Integer> expected = new LinkedListStack<Integer>();
		expected.push(0);
		expected.push(1);
		expected.push(2);
		expected.push(3);
		expected.push(4);
		for (int i = 0; i < test1.size(); i++) {
			assertEquals(expected.pop(), test1.pop());
		}
	}

	@Test
	public void testpushEmpty() {
		LinkedListStack<Integer> expected = new LinkedListStack<Integer>();
		expected.push(1);
		empty.push(1);
		assertEquals(expected.size(), empty.size());
	}

	@Test
	public void testpushSmall() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("29");
		expected.push("30");
		expected.push("31");
		expected.push("hello");
		for (int i = 0; i < small.size(); i++) {
			assertEquals(expected.pop(), small.pop());
		}
	}

	@Test
	public void testpushMedium() {
		// medium list and medium list expected were already pushed in setup so to check
		// if the call worked we will pop off and compare each value
		for (int i = 0; i < medium.size(); i++) {
			assertEquals(expectedMedium.pop(), medium.pop());
		}
	}
	
	@Test
	public void testpushLarge() {
		// large list and large list expected were already pushed in setup so to check
		// if the call worked we will pop off and compare each value
		for (int i = 0; i < large.size(); i++) {
			assertEquals(expectedLarge.pop(), large.pop());
		}
	}

	@Test
	public void testpushOneVlaue() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("goodbye");
		assertEquals(expected.pop(), oneValue.pop());
	}

	@Test
	public void testpushDifferentType() {
		LinkedListStack<Point> expected = new LinkedListStack<Point>();
		expected.push(new Point(0, 0));
		expected.push(new Point(0, 1));
		expected.push(new Point(0, 2));
		expected.push(new Point(0, 3));
		expected.push(new Point(0, 4));
		for (int i = 0; i < points.size(); i++) {
			assertEquals(expected.pop(), points.pop());
		}
	}

	// test size() -------------------------------------------------

	@Test
	public void testsize() {
		LinkedListStack<Integer> expected = new LinkedListStack<Integer>();
		expected.push(0);
		expected.push(1);
		expected.push(2);
		expected.push(3);
		expected.push(4);
		assertEquals(expected.size(), test1.size());
	}

	@Test
	public void testsizeEmpty() {
		LinkedListStack<Integer> expected = new LinkedListStack<Integer>();
		assertEquals(expected.size(), empty.size());
	}

	@Test
	public void testsizeSmall() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("29");
		expected.push("30");
		expected.push("31");
		expected.push("hello");
		assertEquals(expected.size(), small.size());
	}
	
	@Test
	public void testsizeMedium() {
		assertEquals(expectedMedium.size(), medium.size());
	}

	@Test
	public void testsizeLarge() {
		assertEquals(expectedLarge.size(), large.size());
	}

	@Test
	public void testsizeOneVlaue() {
		LinkedListStack<String> expected = new LinkedListStack<String>();
		expected.push("goodbye");
		assertEquals(expected.size(), oneValue.size());
	}

	@Test
	public void testsizeDifferentType() {
		LinkedListStack<Point> expected = new LinkedListStack<Point>();
		expected.push(new Point(0, 0));
		expected.push(new Point(0, 1));
		expected.push(new Point(0, 2));
		expected.push(new Point(0, 3));
		expected.push(new Point(0, 4));
		for (int i = 0; i < points.size(); i++) {
			assertEquals(expected.size(), points.size());
		}
	}

}
