package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    private static final int NUMBER_LOWER_INCLUSIVE = 1;
    private static final int NUMBER_UPPER_INCLUSIVE = 9;

    private static final String INVALID_NUMBER_ERROR = "유효하지 않는 숫자 입니다.";

    private final int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number > NUMBER_UPPER_INCLUSIVE || number < NUMBER_LOWER_INCLUSIVE) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR);
        }
    }

    public boolean isSame(int number) {
        return (this.number == number);
    }

    public int getNumber() {
        return number;
    }
}


