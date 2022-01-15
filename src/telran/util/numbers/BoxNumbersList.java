package telran.util.numbers;

import java.util.HashSet;

public abstract class BoxNumbersList extends BoxNumbersCollection {

	@Override
	public int removeRepeated() {
		//implementation based on HashSet helper
		HashSet<Integer> helper = new HashSet<>();
		return removeByPredicate(num -> !helper.add(num));
	}

}
