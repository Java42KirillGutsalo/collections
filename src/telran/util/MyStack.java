package telran.util;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 
 * all specified below methods should be written with complexity O[1]
 *
 */
public class MyStack {
private LinkedList<Integer> numbers = new LinkedList<>();
private LinkedList<Integer> maxNumbers = new LinkedList<>();
	/**
	 * removes the last element and returns it
	 * if the stack is empty an exception "NoSuchElementException" should be thrown
	 * @return
	 */
	Integer pop() {
		if (numbers.isEmpty()) {
			throw new NoSuchElementException();
		}
		int res = numbers.removeLast();
		if (res == maxNumbers.getLast()) {
			maxNumbers.removeLast();
		}
		return res;
	}
	/**
	 * 
	 * @return true if the stack is empty
	 */
	boolean isEmpty() {
		return numbers.isEmpty();
	}
	/**
	 * adds the given element at the end of the stack
	 * @param element
	 */
	void push(Integer element) {
		numbers.add(element);
		if (maxNumbers.isEmpty() || element >= maxNumbers.getLast()) {
			maxNumbers.add(element);
		}
	}
	/**
	 * 
	 * @return maximal element existing in the stack
	 */
	Integer max() {
		if (maxNumbers.isEmpty()) {
			throw new NoSuchElementException();
		}
		return maxNumbers.getLast();
	}
}
