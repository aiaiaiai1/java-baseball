package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ComputerTest {
    @DisplayName("힌트결과 확인하기")
    @Test
    void checkHint() {
        Computer computer = new Computer(List.of(1,2,3));
        List<Integer> result = computer.checkHint(List.of(1,3,2));
        assertThat(result).isEqualTo(List.of(2,1));
    }
}
