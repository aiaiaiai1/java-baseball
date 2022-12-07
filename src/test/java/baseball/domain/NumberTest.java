package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;

public class NumberTest {

    @DisplayName("1~9사이의 랜덤숫자 생성")
    @RepeatedTest(5)
    void generateRandomNumber() {
        try {
            Number number = new Number();
            Field field = number.getClass().getDeclaredField("number");
            field.setAccessible(true);
            int result = (int) field.get(number);

            assertThat(result >= 1 && result <= 9).isTrue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("숫자 생성")
    void generateNumber() {
        try {
            Number number = new Number(5);
            Field field = number.getClass().getDeclaredField("number");
            field.setAccessible(true);
            int result = (int) field.get(number);

            assertThat(result).isEqualTo(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("1~9사이의 수가 아니면 예외 발생")
    @ParameterizedTest()
    @ValueSource(ints = {0, 10, 15})
    void generatedNumberButInvaild(int number) {
        assertThatThrownBy(
                () -> new Number(number)).isInstanceOf(IllegalArgumentException.class);

    }
}
