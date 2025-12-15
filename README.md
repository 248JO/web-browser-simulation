# Web Browser Simulation

A Java-based console application that simulates the core navigation functionality of a web browser, specifically the **Back** and **Forward** history features. The project focuses on demonstrating and comparing the performance of different data structures—including stacks and linked lists—in managing website visit history.

## Features

* **Browser Navigation Simulation:** Implements the logic for navigating between visited pages using simulated **Back** and **Forward** buttons.
* **Data Structure Comparison:** Utilizes and compares the efficiency of several data structures for tracking website visits:
    * Singly Linked List (`SinglyLinkedList`)
    * Array-based Stack (`ArrayStack`)
    * Linked List-based Stack (`LinkedListStack`)
* **Performance Analysis:** Includes testing and timing classes to measure and analyze the operational efficiency of different data structure implementations for navigation logic.
* **Object-Oriented Design:** The code is structured with dedicated interface/abstract classes for Stacks and Lists.

## Getting Started
These instructions will help you set up and run the project on your local machine.

### Prerequisites
You will need the Java Development Kit (JDK) installed on your system to compile and run the application.

### Installation and Execution

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/248JO/web-browser-simulation.git](https://github.com/248JO/web-browser-simulation.git)
    cd web-browser-simulation
    ```

2.  **Compile the Java files:**
    ```bash
    javac *.java
    ```

3.  **Run the simulation:**
    The main execution points are likely in the `WebBrowserTester` or one of the `Timer` classes. You can run the main simulation with:
    ```bash
    java WebBrowserTester
    ```
    Or, to run the performance testing:
    ```bash
    java LinkedListStackTimer
    # or
    java SinglyLinkedListTester
    ```

## Project Structure

The repository contains several key files implementing the data structures and the simulation logic:

| File Name | Description |
| :--- | :--- |
| `WebBrowser.java` | Contains the core logic for the browser simulation, handling the history, and implementing the `back()` and `forward()` functionality. |
| `WebBrowserTester.java` | The main driver program to run the browser simulation and test its functionality. |
| `Stack.java` | An interface defining the standard operations for a stack data structure (e.g., `push`, `pop`, `peek`). |
| `ArrayStack.java` | An implementation of the `Stack` interface using a standard Java array. |
| `LinkedListStack.java` | An implementation of the `Stack` interface using a linked list for the underlying storage. |
| `List.java` | An interface for a general list data structure. |
| `SinglyLinkedList.java` | An implementation of a singly linked list. |
| `*Tester.java` | Classes used to test the correctness and boundary conditions of the data structure implementations. |
| `*Timer.java` | Classes used to measure the execution time and compare the performance of different data structures. |

## Built With

* **Java**
