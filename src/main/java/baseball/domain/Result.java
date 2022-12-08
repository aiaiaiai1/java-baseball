package baseball.domain;

public class Result {
    private static final int WIN_CONDITION_STRIKE = 3;
    private static final int HINT_UPPER_RANGE = 3;
    private static final int HINT_LOWER_RANGE = 0;
    private static final String INVALID_ACCESS_ERROR = "[ERROR] 잘못된 접근입니다.";
    private final int ball;
    private final int strike;

    public Result(int ballCount, int strikeCount) {
        validate(ballCount,strikeCount);
        this.ball = ballCount-strikeCount;
        this.strike = strikeCount;
    }

    private void validate(int ballCount, int strikeCount) {
        if(!isInRange(ballCount) || !isInRange(strikeCount) || ballCount - strikeCount < 0){
            throw new IllegalArgumentException(INVALID_ACCESS_ERROR);
        }
    }

    private boolean isInRange(int hintCount) {
        return (hintCount >= HINT_LOWER_RANGE && hintCount <= HINT_UPPER_RANGE);
    }


    public boolean checkWin() {
        return strike == WIN_CONDITION_STRIKE;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean isOnlyBall() {
        return ball != 0 && strike == 0;
    }

    public boolean isOnlyStrike() {
        return ball == 0 && strike != 0;
    }

    public boolean hasBoth() {
        return ball != 0 && strike != 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
