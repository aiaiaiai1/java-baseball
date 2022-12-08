package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Numbers numbers;
    private final RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();

    public void initiateNumbers(){
        this.numbers = new Numbers(generate());
    }

    protected List<Integer> generate(){
       return randomNumbersGenerator.generateNotDuplicateNumbers(3);
    }

    public int countBall(List<Integer> numbers){
        return this.numbers.contain(numbers);
    }

    public int countStrike(List<Integer> numbers){
        return this.numbers.match(numbers);
    }
}





