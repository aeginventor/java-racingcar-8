package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외를 발생시킨다.")
    void validateCarNames_ShouldThrowException_WhenNameLengthIsInvalid() {
        List<String> invalidNames = List.of("pobi", "javaji");
        assertThatThrownBy(() -> InputValidator.validateCarNames(invalidNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름에 공백이나 빈 값이 포함되면 예외를 발생시킨다.")
    void validateCarNames_ShouldThrowException_WhenNameIsBlank() {
        List<String> invalidNames = List.of("pobi", " ", "");
        assertThatThrownBy(() -> InputValidator.validateCarNames(invalidNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백이거나 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("모든 자동차 이름이 유효하면 예외를 발생시키지 않는다.")
    void validateCarNames_ShouldNotThrowException_WhenNamesAreValid() {
        // given
        List<String>  validNames = List.of("pobi", "jun", "woni");;

        // when & then
        // 예외가 발생하지 않음을 검증
        assertThatCode(() -> InputValidator.validateCarNames(validNames))
                .doesNotThrowAnyException();
    }

    @DisplayName("시도 횟수가 숫자가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "1 2", "pobi"})
    void validateTryCount_ShouldThrowException_WhenNotNumeric(String input) {
        // when & then
        assertThatThrownBy(() -> InputValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자여야 합니다.");
    }

    @DisplayName("시도 횟수가 1 미만이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    void validateTryCount_ShouldThrowException_WhenLessThanOne(String input) {
        // when & then
        assertThatThrownBy(() -> InputValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 유효하면(1 이상) 숫자를 반환한다.")
    void validateTryCount_ShouldReturnNumber_WhenValid() {
        // given
        String validCount = "5";

        // when
        int tryCount = InputValidator.validateTryCount(validCount);

        // then
        // 예외가 발생하지 않으면서, 정확한 int 값이 반환되었는지 검증
        assertThat(tryCount).isEqualTo(5);
    }

    @DisplayName("자동차 이름이 중복되면 예외가 발생한다.")
    @Test
    void validateCarNamesDuplicated() {
        // given
        List<String> duplicateNames = List.of("pobi", "woni", "pobi");

        // when & then
        assertThatThrownBy(() -> InputValidator.validateCarNames(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }
}
