package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private Game game;
    private Numbers numbers;

    @BeforeEach
    void set(){
        game = new Game(){
            @Override
            protected List<Integer> generateRandomNumbers(){
                return List.of(1,2,3);
            }
        };
        game.initiateComputer();
        numbers = new Numbers(List.of(1,3,2));
    }

    @DisplayName("볼 결과 확인")
    @Test
    void checkBallResult() {
        int result = game.getResult(numbers).getBall();
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("스트라이크 결과 확인")
    @Test
    void checkStrikeResult() {
        int result = game.getResult(numbers).getStrike();
        assertThat(result).isEqualTo(1);
    }
}
