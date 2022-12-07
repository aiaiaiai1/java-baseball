package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Numbers numbers;

    public Computer(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public List<Integer> checkHint(List<Integer> numbers){
        List<Integer> result = new ArrayList<>();
        int ball = this.numbers.contain(numbers);
        int strike = this.numbers.match(numbers);
        result.add(ball-strike);
        result.add(strike);
        return result;
    }

}





