package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("자동차 이름이 5자를 초과하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,javaji", "woni,pobiii"})
    void validateCarNames_ShouldThrowException_WhenNameLengthIsInvalid(String input) {
        // when & then
        assertThatThrownBy(() -> InputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @DisplayName("자동차 이름에 공백이나 빈 값이 포함되면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,,jun", "pobi, ,jun", ",pobi,woni"})
    void validateCarNames_ShouldThrowException_WhenNameIsBlank(String input) {
        // when & then
        assertThatThrownBy(() -> InputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백이거나 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("모든 자동차 이름이 유효하면 예외를 발생시키지 않는다.")
    void validateCarNames_ShouldNotThrowException_WhenNamesAreValid() {
        // given
        String validNames = "pobi,woni,jun";

        // when & then
        // 예외가 발생하지 않음을 검증
        assertThatCode(() -> InputValidator.validateCarNames(validNames))
                .doesNotThrowAnyException();
    }
}
