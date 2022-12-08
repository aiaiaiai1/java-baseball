package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommandTest {

    @DisplayName("올바른 명령어인 경우")
    @ParameterizedTest
    @CsvSource(value = {"1,RESTART","2,QUIT"})
    void inputByCommand(int number,Command command){
        assertThat(Command.of(number)).isEqualTo(command);
    }

    @DisplayName("잘못된 명령어인 경우 예외 발생")
    @Test
    void inputByInvalidCommand(){
        assertThatThrownBy(
                () -> Command.of(3)).isInstanceOf(IllegalArgumentException.class);
    }
}
