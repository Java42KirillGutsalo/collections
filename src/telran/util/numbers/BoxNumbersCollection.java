package telran.util.numbers;

import java.util.*;
import java.util.function.Predicate;

public abstract class BoxNumbersCollection implements BoxNumbers {
protected Collection<Integer> collection;

	@Override
	public Iterator<Integer> iterator() {
		return collection.iterator();
	}

	@Override
	public boolean addNumber(int num) {
		return collection.add(num);
	}

	@Override
	public boolean removeNumber(int num) {
		return collection.remove(num);
	}


	@Override
	public int removeByPredicate(Predicate<Integer> predicate) {
		int oldSize = collection.size();
		collection.removeIf(predicate);
		return oldSize - collection.size();
	}

	@Override
	public int removeInRange(int fromInclusive, int toExclusive) {
		return removeByPredicate(num -> num >= fromInclusive && num <= toExclusive);
	}

	@Override
	public boolean containsNumber(int num) {
		return collection.contains(num);
	}
}
