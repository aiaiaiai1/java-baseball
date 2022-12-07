package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbersGenerator {
    private static final int NUMBERS_LENGTH = 3;
    public Numbers generate() {
        List<Number> numbers = new ArrayList<>();
        while (numbers.size() < NUMBERS_LENGTH) {
            numbers.add(new Number());
        }
        try {
            return new Numbers(numbers);
        } catch (IllegalArgumentException e) {
            return generate();
        }
    }
}
