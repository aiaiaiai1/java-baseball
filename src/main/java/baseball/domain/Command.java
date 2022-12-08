package baseball.domain;

public enum Command {
    RESTART(1), QUIT(2);

    private static final String INVALID_COMMAND = "[ERROR] 유효하지 않는 명령어입니다.";
    private final int number;

    Command(int number) {
        this.number = number;
    }

    public boolean isSame(int number) {
        return this.number == number;
    }

    public static Command of(int number){
        for(Command command : Command.values()) {
            if (command.isSame(number)) {
                return command;
            }
        }
        throw new IllegalArgumentException(INVALID_COMMAND);
    }
}

