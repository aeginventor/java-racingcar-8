package racingcar.validator;

import java.util.Arrays;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String COMMA_DELIMITER = ",";

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String ERROR_NAME_LENGTH = ERROR_PREFIX + "자동차 이름은 " + MAX_NAME_LENGTH + "자 이하만 가능합니다.";
    private static final String ERROR_NAME_BLANK = ERROR_PREFIX + "자동차 이름은 공백이거나 비어있을 수 없습니다.";

    // private 생성자로 객체 생성 방지
    private InputValidator() {
    }

    public static void validateCarNames(String carNamesInput) {
        String[] names = carNamesInput.split(COMMA_DELIMITER, -1);

        Arrays.stream(names)
                .forEach(InputValidator::validateSingleCarName);
    }

    private static void validateSingleCarName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ERROR_NAME_BLANK);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }
}
