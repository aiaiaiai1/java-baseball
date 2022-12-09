package baseball.view;

import baseball.domain.Command;
import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INVALID_INPUT_ERROR = "[ERROR] 숫자만 입력해주세요";
    private static final String RESTART_OR_QUIR_NOTICE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBERS_NOTICE = "숫자를 입력해주세요 : ";

    public Numbers readNumbers() {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (char character : String.valueOf(readOnlyNumber()).toCharArray()) {
                numbers.add(Integer.valueOf(String.valueOf(character)));
            }
            return new Numbers(numbers);
        } catch (IllegalArgumentException invalidNumbers) {
            notifyError(invalidNumbers);
            return readNumbers();
        }
    }

    public int readOnlyNumber() {
        try {
            String input = Console.readLine();
            return Integer.valueOf(input);
        } catch (IllegalArgumentException invalidInput) {
            System.out.println(INVALID_INPUT_ERROR);
            return readOnlyNumber();
        }
    }

    public Command readCommand() {
        try {
            Command command = Command.of(readOnlyNumber());
            return command;
        } catch (IllegalArgumentException invalidCommand) {
            notifyError(invalidCommand);
            return readCommand();
        }
    }

    public void notifyError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void notifyInputRestartOrQuit() {
        System.out.println(RESTART_OR_QUIR_NOTICE);
    }

    public void notifyInputNumbers() {
        System.out.print(INPUT_NUMBERS_NOTICE);
    }
}
