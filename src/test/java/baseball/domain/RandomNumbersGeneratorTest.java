package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomNumbersGeneratorTest {
    @DisplayName("1~9범위의 중복되지않는 3자리 숫자 생성하기")
    @Test
    void generateRandomNumbers(){
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
        List<Integer> result = randomNumbersGenerator.generateNotDuplicateNumbers(3);
        assertThat(result).doesNotContain(0).doesNotHaveDuplicates().hasSize(3);
    }
}
