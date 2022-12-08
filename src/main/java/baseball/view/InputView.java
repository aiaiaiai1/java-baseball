package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_ONLY_NUMBERS = "[ERROR] 숫자를 입력해주세요";

    public int readNumbers() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
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
