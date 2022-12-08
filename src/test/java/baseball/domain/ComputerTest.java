package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ComputerTest {
    @DisplayName("볼 갯수(같은숫자) 확인하기")
    @Test
    void countBall() {
        Computer computer = new Computer(){
            @Override
            protected List<Integer> generate(){
                return List.of(1,2,3);
            }
        };
        computer.initiateNumbers();
        int result = computer.countBall(List.of(1,3,2));
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("스트라이크 갯수(같은숫자 + 같은자리) 확인하기")
    @Test
    void countStrike() {
        Computer computer = new Computer(){
            @Override
            protected List<Integer> generate(){
                return List.of(1,2,3);
            }
        };
        computer.initiateNumbers();
        int result = computer.countStrike(List.of(1,3,2));
        assertThat(result).isEqualTo(1);
    }
}
