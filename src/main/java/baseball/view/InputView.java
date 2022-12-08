package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_ONLY_NUMBERS = "[ERROR] 숫자를 입력해주세요";

    public List<Integer> readNumbers() {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (char character : Console.readLine().toCharArray()) {
                numbers.add(Integer.parseInt(String.valueOf(character)));
            }
            return numbers;
        } catch (IllegalArgumentException notNumbers) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBERS);
        }
    }

    public int readCommand() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (IllegalArgumentException notNumbers) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBERS);
        }
    }
}
