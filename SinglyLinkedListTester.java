package assign06;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * CS-2420 Assignment 6: LinkedListStack. This is the tester class for the
 * SinglyLinkedList class
 * 
 * @author Judy Ojewia and Natalie Hicks
 * @version 2/29/2024
 */
public class SinglyLinkedListTester {

	private SinglyLinkedList<Integer> empty, small, med, large, one;
	private SinglyLinkedList<String> string;
	private Iterator itr, emptyItr;

	@BeforeEach
	public void setup() {
		empty = new SinglyLinkedList<Integer>();
		emptyItr = empty.iterator();

		small = new SinglyLinkedList<Integer>();
		small.insert(0, 1);
		small.insert(1, 2);
		small.insert(2, 3);

		med = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 50; i++)
			med.insert(i, i + 1);

		large = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 200; i++)
			large.insert(i, i + 1);
		itr = large.iterator();

		string = new SinglyLinkedList<String>();
		string.insert(0, "I'm joe");
		string.insert(1, "Stacy");
		string.insert(2, "Greg Heffley");
		string.insert(3, "a");
		string.insert(4, "b");
		string.insert(5, "c");

		one = new SinglyLinkedList<Integer>();
		one.insertFirst(99);

	}

//	 SinglyLinkedList() tests --------------------------------------------------------------------------

	@Test
	public void testSinglyLinkedList() {
		SinglyLinkedList<Integer> expected = new SinglyLinkedList<Integer>();
		expected.insert(0, 1);
		expected.insert(1, 2);
		expected.insert(2, 3);

		for (int i = 0; i < small.size(); i++) {
			assertEquals(expected.get(i), small.get(i));
		}
	}

	@Test
	public void testSinglyLinkedListEmpty() {
		SinglyLinkedList<Integer> expected = new SinglyLinkedList<Integer>();
		assertEquals(expected.size(), empty.size());
	}

//insertFirst tests-------------------------------------------------------------------------------------------
	@Test
	public void testInsertFirstSmallSinglyLinkedList() {
		large.insertFirst(15);
		assertEquals(0, large.indexOf(15));
	}

	@Test
	public void testInsertFirstMediumSinglyLinkedList() {
		large.insertFirst(8910);
		assertEquals(0, large.indexOf(8910));
	}

	@Test
	public void testInsertFirstLargeSinglyLinkedList() {
		large.insertFirst(389);
		assertEquals(0, large.indexOf(389));
	}

	@Test
	public void testInsertFirstStringSinglyLinkedList() {
		string.insertFirst("yolo");
		assertEquals(0, string.indexOf("yolo"));
	}

//insert tests------------------------------------------------------------------------------------------------
	@Test
	public void testInsertSmallSinglyLinkedList() {
		for (int i = 0; i < 3; i++)
			assertEquals(i + 1, small.get(i));
	}

	@Test
	public void testInsertMediumSinglyLinkedList() {
		for (int i = 0; i < 50; i++)
			assertEquals(i + 1, med.get(i));
	}

	@Test
	public void testInsertLargeSinglyLinkedList() {
		for (int i = 0; i < 200; i++)
			assertEquals(i + 1, large.get(i));
	}

	@Test
	public void testInsertSinglyLinkedListException() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			large.insert(300, 5);
		}, "Failed to throw exeption if index is out of bounds");
	}

//Get First tests------------------------------------------------------------------------------------------------
	@Test
	public void testGetFirstSmallSinglyLinkedList() {
		assertEquals(1, small.getFirst());
	}

	@Test
	public void testGetFirstMediumSinglyLinkedList() {
		assertEquals(1, med.getFirst());
	}

	@Test
	public void testGetFirstLargeSinglyLinkedList() {
		assertEquals(1, large.getFirst());
	}

	@Test
	public void testGetFirstSinglyLinkedListException() {
		assertThrows(NoSuchElementException.class, () -> {
			empty.getFirst();
		}, "Failed to throw exeption if the SinglyLInkedList is empty");
	}

//Get tests-----------------------------------------------------------------------------------------------------
	@Test
	public void testGetSmallSinglyLinkedList() {
		assertEquals(3, small.get(2));
	}

	@Test
	public void testGetMediumSinglyLinkedList() {
		assertEquals(46, med.get(45));
	}

	@Test
	public void testGetLargeSinglyLinkedList() {
		assertEquals(178, large.get(177));
	}

	@Test
	public void testGetSinglyLinkedListException() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			med.get(700);
		}, "Failed to throw exeption if the index is out of bounds");
	}

//DeleteFirst tests-----------------------------------------------------------------------------------------------------	
	@Test
	public void testDeleteFirstSmallSinglyLinkedList() {
		small.deleteFirst();
		assertEquals(0, small.indexOf(2));
	}

	@Test
	public void testDeleteFirstMediumSinglyLinkedList() {
		med.deleteFirst();
		assertEquals(0, med.indexOf(2));
	}

	@Test
	public void testDeleteFirstLargeSinglyLinkedList() {
		large.deleteFirst();
		assertEquals(0, large.indexOf(2));
	}

	@Test
	public void testDeleteFirstSinglyLinkedListException() {
		assertThrows(NoSuchElementException.class, () -> {
			empty.deleteFirst();
		}, "Failed to throw exeption if the list is empty");
	}

//Delete tests-----------------------------------------------------------------------------------------------------
	@Test
	public void testDeleteSmallSinglyLinkedList() {
		small.delete(1);
		assertEquals(1, small.indexOf(3));
	}

	@Test
	public void testDeleteMediumSinglyLinkedList() {
		med.deleteFirst();
		assertEquals(0, med.indexOf(2));
	}

	@Test
	public void testDeleteLargeSinglyList() {
		large.delete(37);
		assertEquals(37, large.indexOf(39));
	}

	@Test
	public void testDeleteOneElementSinglyList() {
		one.delete(0);
		assertEquals(0, one.size());
	}

	@Test
	public void testDeleteSinglyLinkedListException() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			med.delete(1000);
		}, "Failed to throw exeption if the list is empty");
	}

//IndexOf tests-----------------------------------------------------------------------------------------------------
	@Test
	public void testIndexOfSmallSinglyLinkedList() {
		assertEquals(2, small.indexOf(3));
	}

	@Test
	public void testIndexOfMediumSinglyLinkedList() {
		assertEquals(26, med.indexOf(27));
	}

	@Test
	public void testIndexOfLargeSinglyLinkedList() {
		assertEquals(110, large.indexOf(111));
	}

//Size tests-----------------------------------------------------------------------------------------------------
	@Test
	public void testSizeSmallSinglyLinkedList() {
		assertEquals(3, small.size());
	}

	@Test
	public void testSizeMediumSinglyLinkedList() {
		med.insertFirst(8910);
		assertEquals(51, med.size());
	}

	@Test
	public void testSizeFirstLargeSinglyLinkedList() {
		assertEquals(200, large.size());
	}

	@Test
	public void testSizeStringSinglyLinkedList() {
		string.insertFirst("yolo");
		assertEquals(7, string.size());
	}

//isEmpty tests-----------------------------------------------------------------------------------------------------
	@Test
	public void testSIsEmptySmallSinglyLinkedList() {
		assertFalse(small.isEmpty());
	}

	@Test
	public void testIsEmptyMediumSinglyLinkedList() {
		assertFalse(med.isEmpty());
	}

	@Test
	public void testIsEmptyFirstLargeSinglyLinkedList() {
		assertFalse(large.isEmpty());
	}

	@Test
	public void testIsEmptyStringSinglyLinkedList() {
		assertFalse(string.isEmpty());
	}

//Clear tests-----------------------------------------------------------------------------------------------------
	@Test
	public void testClearSmallSinglyLinkedList() {
		small.clear();
		assertTrue(small.size() == 0);
	}

	@Test
	public void testClearMediumSinglyLinkedList() {
		med.clear();
		assertTrue(med.size() == 0);
	}

	@Test
	public void testClearFirstLargeSinglyLinkedList() {
		large.clear();
		assertTrue(large.size() == 0);
	}

	@Test
	public void testClearFirstEmptySinglyLinkedList() {
		empty.clear();
		assertTrue(empty.size() == 0);
	}

	@Test
	public void testClearStringSinglyLinkedList() {
		string.clear();
		assertTrue(string.size() == 0);
	}

//toArray tests-----------------------------------------------------------------------------------------------------
	@Test
	public void testToArraySmallSinglyLinkedList() {
		Object[] expected = new Object[3];
		for (int i = 0; i < expected.length; i++)
			expected[i] = i + 1;
		assertArrayEquals(expected, small.toArray());
	}

	@Test
	public void testToArrayMediumSinglyLinkedList() {
		Object[] expected = new Object[50];
		for (int i = 0; i < expected.length; i++)
			expected[i] = i + 1;
		assertArrayEquals(expected, med.toArray());
	}

	@Test
	public void testTArrayFirstLargeSinglyLinkedList() {
		Object[] expected = new Object[200];
		for (int i = 0; i < expected.length; i++)
			expected[i] = i + 1;
		assertArrayEquals(expected, large.toArray());
	}

	@Test
	public void testToArrayFirstEmptySinglyLinkedList() {
		Object[] expected = new Object[0];
		;
		assertArrayEquals(expected, empty.toArray());
	}

	@Test
	public void testToArrayStringSinglyLinkedList() {
		Object[] expected = string.toArray();
		assertEquals("b", expected[4]);
	}

//Iterator tests----------------------------------------------------------------------------------------------------

	@Test
	public void testIteratorHasNextTrue() {
		assertTrue(itr.hasNext());
	}

	@Test
	public void testIteratorHasNext() {
		for (int i = 0; i < 200; i++)
			itr.next();
		assertFalse(itr.hasNext());
	}

	@Test
	public void testIteratorNext() {
		for (int i = 0; i < 200; i++) {
			assertEquals(i + 1, itr.next());
		}
	}

	@Test
	public void testIteratorNextThrowsException() {
		assertThrows(NoSuchElementException.class, () -> {
			emptyItr.next();
		}, "Failed to throw exeption if the SinglyLInkedList is empty");
	}

	@Test
	public void testIteratorRemove() {
		for (int i = 0; i < 200; i++) {
			itr.next();
			itr.remove();
		}
		assertEquals(0, large.size());
	}

	@Test
	public void testIteratorRemoveThrowsException() {
		assertThrows(IllegalStateException.class, () -> {
			emptyItr.remove();
		}, "Failed to throw exeption if the SinglyLInkedList is empty");
	}

}
