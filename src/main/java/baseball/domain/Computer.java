package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Numbers numbers;

    public Computer(){
        generateNumbers();
    }

    public void generateNumbers() {
        List<Number> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            numbers.add(new Number());
        }
        try {
            this.numbers = new Numbers(numbers);
        } catch (IllegalArgumentException e) {
            generateNumbers();
        }
    }
}

