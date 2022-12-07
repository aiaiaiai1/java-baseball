package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private static final int NUMBERS_LENGTH = 3;
    private final List<Number> numbers;

    public Numbers(List<Number> numbers){
        validateLength(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Number> numbers){
        if(numbers.size() != NUMBERS_LENGTH){
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplication(List<Number> numbers){
        List<Integer> tmp = new ArrayList<>();
        for(Number numnber : numbers){
            tmp.add(numnber.getNumber());
        }
        Set<Integer> tmp2 = new HashSet<>(tmp);
        if(tmp.size() != tmp2.size()){
            throw new IllegalArgumentException();
        }
    }

}
