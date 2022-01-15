package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTests {
private static final int N_NUMBERS = 100000;
private static final int N_RUNS = 100000;
MyStack myStack;
Stack<Integer> stack;
Integer elements[] = {
		10, -10, 20, 40, 40, -8, 3
};
	@BeforeEach
	void setUp() throws Exception {
		myStack = new MyStack();
		stack = new Stack<>();
		for(Integer num: elements) {
			myStack.push(num);
			stack.push(num);
		}
	}

	@Test
	void testPop() {
		allPops();
		boolean flException = false;
		try {
			myStack.pop();
		} catch (NoSuchElementException e) {
			flException = true;
		}
		assertTrue(flException);
	}
	
	private void allPops() {
		for (int i = 0; i < elements.length; i++) {
			assertEquals(stack.pop(), myStack.pop());
		}
	}

	@Test
	void testIsEmpty() {
		assertFalse(myStack.isEmpty());
		allPops();
		assertTrue(myStack.isEmpty());
	}

	@Test
	void testPush() {
		Integer num = 1000;
		stack.push(num);
		myStack.push(num);
		allPops();
	}

	@Test
	void testMax() {
		assertEquals(Collections.max(stack), myStack.max());
		int nPops = 3;
		pops(nPops);
		assertEquals(Collections.max(stack), myStack.max());
		nPops = 2;
		pops(nPops);
		assertEquals(Collections.max(stack), myStack.max());
	}

	private void pops(int nPops) {
		for(int i = 0; i < nPops; i++) {
			stack.pop();
			myStack.pop();
		}	
	}
	//Test as the example of comparing 0[N] with 0[1]
	void getMaxStandard() {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N_NUMBERS; i++) {
			stack.push((int)(Math.random() * Integer.MAX_VALUE));
		}
		for (int i = 0; i < N_RUNS; i++) {
			Collections.max(stack);
		}
	}
	@Test
	void getMaxMyStack() {
		MyStack stack = new MyStack();
		for (int i = 0; i < N_NUMBERS; i++) {
			stack.push((int)(Math.random() * Integer.MAX_VALUE));
		}
		for (int i = 0; i < N_RUNS; i++) {
			stack.max();
		}
	}
}

