package assign06;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * CS-2420 Assignment 6: LinkedListStack This is the tester class for the
 * WebBrowser class
 * 
 * @author Judy Ojewia and Natalie Hicks
 * @version 2/29/2024
 */
public class WebBrowserTester {
	private WebBrowser one, empty, filled;
	private SinglyLinkedList<URL> history;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setup() throws MalformedURLException {
		history = new SinglyLinkedList<URL>();
		one = new WebBrowser();
		for (int i = 0; i < 25; i++) {
			URL url = new URL("https://google" + i + ".com");
			history.insert(i, url);
		}
		filled = new WebBrowser(history);

	}

//	 test WebBrowser() ------------------------------------------------------------------------------------
	@Test
	public void testWebBrowser() {
		WebBrowser test1 = new WebBrowser(history);

		assertThrows(NoSuchElementException.class, () -> {
			test1.forward();
		}, "The method failed to throw " + "the NoSuchElementException");

	}

	@Test
	public void testWebBrowserTwo() {
		WebBrowser test2 = new WebBrowser(history);

		assertThrows(NoSuchElementException.class, () -> {
			test2.forward();
		}, "The method failed to throw " + "the NoSuchElementException");

	}

//	 test WebBrowser() - list ---------------------------------------------------------------------------

	@SuppressWarnings("deprecation")
	@Test
	public void testWebBrowserList() throws MalformedURLException {
		URL expected = new URL("https://google.com");
		for (int i = 0; i > 25; i++) {
			expected = new URL("https://google" + i + ".com");
			assertEquals(expected, filled.back());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testWebBrowserListTwo() throws MalformedURLException {
		URL expected = new URL("https://google.com");
		for (int i = 1; i < 25; i++) {
			expected = new URL("https://google" + i + ".com");
			assertEquals(expected, filled.back());
		}
	}

//	 test visit() -------------------------------------------------------------------------------------

	@SuppressWarnings("deprecation")
	@Test
	public void testVisit() throws MalformedURLException {
		URL expected = new URL("https://google0.com");
		filled.visit(expected);
		assertThrows(NoSuchElementException.class, () -> {
			filled.forward();
		}, "The method failed to throw " + "the NoSuchElementException");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testVisitOneURL() throws MalformedURLException {
		URL expected = new URL("https://google0.com");
		one.visit(expected);
		assertThrows(NoSuchElementException.class, () -> {
			one.back();
		}, "The method failed to throw " + "the NoSuchElementException");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testVisitNewURL() throws MalformedURLException {
		URL expected = new URL("https://google5.com");
		filled.visit(expected);
		assertThrows(NoSuchElementException.class, () -> {
			filled.forward();
		}, "The method failed to throw " + "the NoSuchElementException");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testVisitTwoURLs() throws MalformedURLException {
		URL expected1 = new URL("https://google12.com");
		URL expected2 = new URL("https://google123.com");
		filled.visit(expected1);
		filled.visit(expected2);
		URL expected = new URL("https://google12.com");
		assertEquals(expected, filled.back());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testVisitReturnHistory() throws MalformedURLException {
		URL expected = new URL("https://google12.com");
		int size = filled.history().size();
		for (int i = 0; i > 25; i++) {
			expected = new URL("https://google" + i + i + ".com");
			filled.visit(expected);
			assertEquals(expected, filled.history().get(size - i - 1));
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testVisitBackThenForward() throws MalformedURLException {
		URL expected1 = new URL("https://google12.com");
		URL expected2 = new URL("https://google123.com");
		URL expected3 = new URL("https://google1234.com");
		filled.visit(expected1);
		filled.visit(expected2);
		filled.visit(expected3);
		filled.back();
		filled.forward();
		URL expected = new URL("https://google123.com");
		assertEquals(expected, filled.back());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testVisitBack() throws MalformedURLException {
		URL expected = new URL("https://google.com");
		for (int i = 0; i > 25; i++) {
			expected = new URL("https://google" + i + ".com");
			filled.visit(expected);
			assertEquals(expected, filled.back());
		}
	}

//	 test back() --------------------------------------------------------------------------------------

	@SuppressWarnings("deprecation")
	@Test
	public void testBack() throws MalformedURLException {
		URL expected = new URL("https://google.com");
		for (int i = 0; i > 25; i++) {
			expected = new URL("https://google" + i + ".com");
			assertEquals(expected, filled.back());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBackToBeginning() throws MalformedURLException {
		URL expected = new URL("https://google.com");
		for (int i = 1; i > 25; i++) {
			expected = new URL("https://google" + i++ + ".com");
			assertEquals(expected, filled.back());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBackForwardBack() throws MalformedURLException {
		filled.back();
		filled.forward();
		filled.back();
		URL expected = new URL("https://google2.com");
		assertEquals(expected, filled.back());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBackThenVisit() throws MalformedURLException {
		URL url = new URL("https://google20909.com");
		filled.visit(url);
		filled.visit(url);
		filled.visit(url);
		filled.back();
		URL expected = new URL("https://google20909.com");
		assertEquals(expected, filled.back());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBackException() throws MalformedURLException {
		URL expected = new URL("https://google0.com");
		one.visit(expected);
		assertThrows(NoSuchElementException.class, () -> {
			one.back();
		}, "The method failed to throw " + "the NoSuchElementException");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testBackOneURL() throws MalformedURLException {
		URL expected = new URL("https://google0.com");
		one.visit(expected);
		assertThrows(NoSuchElementException.class, () -> {
			one.forward();
		}, "The method failed to throw " + "the NoSuchElementException");
	}

//	test forward() --------------------------------------------------------------------------------------

	@Test
	public void testForwardThrowsException() throws MalformedURLException {
		WebBrowser test = new WebBrowser(history);
		assertThrows(NoSuchElementException.class, () -> {
			test.forward();
		}, "Failed to throw exception if the SinglyLinkedList is empty");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testForwardAfterVisit() throws MalformedURLException {
		WebBrowser test = new WebBrowser(history);
		test.visit(new URL("https://google27.com"));
		assertThrows(NoSuchElementException.class, () -> {
			test.forward();
		}, "Failed to throw exception if the SinglyLinkedList is empty");
	}

	@Test
	public void testForwardEmptyBrowser() throws MalformedURLException {
		empty = new WebBrowser(history);
		assertThrows(NoSuchElementException.class, () -> {
			empty.forward();
		}, "Failed to throw exception if the SinglyLinkedList is empty");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testForwardSetsCorrectCurrent() throws MalformedURLException {
		WebBrowser test = new WebBrowser();
		for (int i = 0; i < 25; i++) {
			URL url = new URL("https://google" + i + ".com");
			test.visit(url);
		}
		test.back();
		test.back();
		assertEquals(new URL("https://google23.com"), test.forward());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testForwardWoerksAfterVisit() throws MalformedURLException {
		WebBrowser test = new WebBrowser();
		for (int i = 0; i < 25; i++) {
			URL url = new URL("https://google" + i + ".com");
			test.visit(url);
		}
		test.back();
		test.back();
		assertEquals(new URL("https://google23.com"), test.forward());
		test.visit(new URL("https://google999.com"));
		test.back();
		assertEquals(new URL("https://google999.com"), test.forward());
	}

//	 test history()----------------------------------------------------------------------------------

	@SuppressWarnings("deprecation")
	@Test
	public void testHistoryAfterGoingBack() throws MalformedURLException {
		WebBrowser test = new WebBrowser();
		for (int i = 0; i < 25; i++) {
			URL url = new URL("https://google" + i + ".com");
			test.visit(url);
		}
		for (int i = 0; i < 24; i++) {
			test.back();
		}
		assertEquals(1, test.history().size());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testHistorySize() throws MalformedURLException {
		WebBrowser test = new WebBrowser();
		for (int i = 0; i < 25; i++) {
			URL url = new URL("https://google" + i + ".com");
			test.visit(url);
		}
		for (int i = 0; i < 25; i++) {
			assertEquals(25, test.history().size());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testHistoryBigBrowser() throws MalformedURLException {
		WebBrowser test = new WebBrowser();
		for (int i = 0; i < 200; i++) {
			URL url = new URL("https://google" + i + ".com");
			test.visit(url);
		}
		for (int i = 0; i < 200; i++) {
			assertEquals(200, test.history().size());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testHistory() throws MalformedURLException {
		URL expected = new URL("https://google.com");
		WebBrowser one = new WebBrowser();
		for (int i = 0; i < 5; i++) {
			URL url = new URL("https://google" + i + ".com");
			one.visit(url);
		}
		int size = one.history().size();
		for (int i = size - 1; i >= 0; i--) {
			expected = new URL("https://google" + i + ".com");
			assertEquals(expected, one.history().get(size - i - 1));
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testHistoryTwo() throws MalformedURLException {
		URL expected = new URL("https://google.com");

		WebBrowser one = new WebBrowser();
		for (int i = 0; i < 5; i++) {
			URL url = new URL("https://google" + i + ".com");
			one.visit(url);
		}
		int size = one.history().size();

		for (int i = size - 1; i >= 0; i--) {
			expected = new URL("https://google" + i + ".com");
			assertEquals(expected, one.history().get(size - i - 1));
		}
	}

}
