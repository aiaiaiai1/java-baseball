package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    private static final int NUMBER_LOWER_INCLUSIVE = 1;
    private static final int NUMBER_UPPER_INCLUSIVE = 9;

    private final int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    public Number(){
        this.number = Randoms.pickNumberInRange(NUMBER_LOWER_INCLUSIVE, NUMBER_UPPER_INCLUSIVE);
    }

    private void validate(int number){
        if(number > NUMBER_UPPER_INCLUSIVE || number < NUMBER_LOWER_INCLUSIVE){
            throw new IllegalArgumentException();
        }
    }
}
