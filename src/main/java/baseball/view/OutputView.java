package baseball.view;

import baseball.domain.Result;

import java.util.List;

public class OutputView {
    private static final String BLANK = " ";
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String START_NOTICE = "숫자 야구 게임을 시작합니다.";
    private static final String END_NOTICE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";



    public void notifyStart() {
        System.out.println(START_NOTICE);
    }

    public void notifyEnd() {
        System.out.println(END_NOTICE);
    }

    public void notifyHint(Result result) {
        printNothing(result);
        printOnlyBall(result);
        printOnlyStrike(result);
        printBoth(result);
    }

    private void printNothing(Result result) {
        if (result.isNothing()) {
            System.out.println(NOTHING);
        }
    }

    private void printOnlyBall(Result result) {
        if (result.isOnlyBall()) {
            System.out.println(result.getBall() + BALL);
        }
    }

    private void printOnlyStrike(Result result) {
        if (result.isOnlyStrike()) {
            System.out.println(result.getStrike() + STRIKE);
        }
    }

    private void printBoth(Result result) {
        if (result.hasBoth()) {
            System.out.println(result.getBall() + BALL + BLANK + result.getStrike() + STRIKE);
        }
    }

}
