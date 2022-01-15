package telran.util.numbers;

import java.util.function.Predicate;

public interface BoxNumbers extends Iterable<Integer> {
boolean addNumber(int num);
boolean removeNumber(int num);
int removeRepeated();//returns amount of removed numbers
int removeByPredicate(Predicate<Integer> predicate);
int removeInRange(int fromInclusive, int toExclusive);
boolean containsNumber(int num);
}
