package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultTest {
    @DisplayName("볼 확인하기")
    @Test
    void checkBall() {
        Result GameResult = new Result(2, 1);
        int result = GameResult.getBall();
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("스트라이크 확인하기")
    @Test
    void checkStrike() {
        Result GameResult = new Result(2, 2);
        int result = GameResult.getStrike();
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("잘못된 접근인경우 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"4,2", "1,2"})
    void checkStrike(int ballCount, int StrikeCount) {
        assertThatThrownBy(
                () -> new Result(ballCount, StrikeCount)).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("낫싱인지 아닌지 확인하기")
    @Test
    void isNothing() {
        Result gameResult = new Result(0, 0);
        boolean result = gameResult.isNothing();
        assertThat(result).isTrue();
    }

    @DisplayName("볼만 있는지 확인하기")
    @ParameterizedTest
    @CsvSource(value = {"2,0,true", "2,2,false"})
    void isOnlyBall(int ballCount, int StrikeCount, boolean expected) {
        Result gameResult = new Result(ballCount, StrikeCount);
        boolean result = gameResult.isOnlyBall();
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("스트라이크만 있는지 확인하기")
    @ParameterizedTest
    @CsvSource(value = {"2,2,true", "2,1,false"})
    void isOnlyStrike(int ballCount, int StrikeCount, boolean expected) {
        Result gameResult = new Result(ballCount, StrikeCount);
        boolean result = gameResult.isOnlyStrike();
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("볼과 스트라이크 둘다 있는지 확인하기")
    @ParameterizedTest
    @CsvSource(value = {"2,2,false", "2,1,true"})
    void hasBoth(int ballCount, int StrikeCount, boolean expected) {
        Result gameResult = new Result(ballCount, StrikeCount);
        boolean result = gameResult.hasBoth();
        assertThat(result).isEqualTo(expected);
    }
    @DisplayName("승리확인하기")
    @Test
    void checkWin(){
        Result gameResult = new Result(3,3);
        boolean result = gameResult.checkWin();
        assertThat(result).isTrue();
    }
}

