package telran.util.numbers;

import java.util.TreeSet;

public class BoxNumbersTreeSet extends BoxNumbersSet {
	public BoxNumbersTreeSet() {
		this.collection = new TreeSet<Integer>();
	}
	@Override
	public int removeInRange(int fromInclusive, int toExclusive) {
		int oldSize = collection.size();
		((TreeSet<Integer>)collection).subSet(fromInclusive, toExclusive).clear();
		return oldSize - collection.size();
	}
}
