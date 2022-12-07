package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private static final int NUMBERS_LENGTH = 3;
    private final List<Number> numbers = new ArrayList<>();

    public Numbers(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        set(numbers);
    }

    private void set(List<Integer> numbers) {
        for (Integer number : numbers) {
            this.numbers.add(new Number(number));
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> NotDuplicateNumbers = new HashSet<>(numbers);
        if (numbers.size() != NotDuplicateNumbers.size())
            throw new IllegalArgumentException();
    }
}

