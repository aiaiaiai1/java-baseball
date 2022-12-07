package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    @DisplayName("3자리의 숫자가 아닌경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {2, 4})
    void createNumbersByNotThreeDigits(int length) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            numbers.add(i + 1);
        }
        assertThatThrownBy(
                () -> new Numbers(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자인 경우 예외 발생")
    @Test
    void createNumbersByDuplicateNumber() {
        List<Integer> numbers = List.of(1,2,2);
        assertThatThrownBy(
                () -> new Numbers(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은숫자 포함개수 확인")
    @ParameterizedTest
    void containNumbers() {
        Numbers numbers = new Numbers(List.of(1,2,3));
        int result = numbers.contain(List.of(1,4,2));
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("같은숫자이면서 같은자리인 숫자개수 확인")
    @Test
    void matchNumbers() {
        Numbers numbers = new Numbers(List.of(1,2,3));
        int result = numbers.match(List.of(1,4,2));
        assertThat(result).isEqualTo(1);
    }

}
