package collection;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.*;

class CollectionIntroductionTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void ImmutableCollection() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		boolean flException = false;
		Collection<Integer> list1 = new ArrayList<>(list);
		list1 = Collections.unmodifiableCollection(list1);
		try {
			list1.add(10);
		} catch (UnsupportedOperationException e) {
			flException = true;
		}
		assertTrue(flException);
	}
	@Test
	void sublistTest() {
		List<Integer> list = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));
		List<Integer> sublist = list.subList(1, 3);
		assertEquals(2, sublist.size());
		assertArrayEquals(new Integer[] {20, 30}, sublist.toArray(new Integer[0]));
		sublist.add(0, -20);
		sublist = list.subList(1, 3);
		assertArrayEquals(new Integer[] {-20, 20}, sublist.toArray(new Integer[0]));
		sublist.add(-30);
		sublist = list.subList(2, 4);
		assertArrayEquals(new Integer[] {20, -30}, sublist.toArray(new Integer[0]));
	}
	
	@Test
	void subSetTest() {
		TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
		assertNull(treeSet.floor(5));
		assertEquals(10,  treeSet.floor(15));
		assertNull(treeSet.ceiling(60));
		assertEquals(50, treeSet.ceiling(45));
		assertEquals(treeSet.floor(30), treeSet.ceiling(30));
		treeSet.subSet(20, true, 40, true).clear();
		assertArrayEquals(new Integer[] {10, 50}, treeSet.toArray(new Integer[0]));
		//use case of the homework #27
		Collection<Integer> treeCollection = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
		((TreeSet<Integer>)treeCollection).subSet(20, 40).clear();
		assertArrayEquals(new Integer[] {10, 40, 50}, treeCollection.toArray(new Integer[0]));
	}
}
