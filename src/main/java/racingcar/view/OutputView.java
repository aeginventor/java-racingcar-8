package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String HEADER_EXECUTION_RESULT = "\n실행 결과";
    private static final String CAR_POSITION_FORMAT = " : ";
    private static final String WINNER_ANNOUNCEMENT_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printExecutionResultHeader() {
        System.out.println(HEADER_EXECUTION_RESULT);
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            String carName = car.getName();
            String positionDisplay = car.getPositionDisplay();
            System.out.println(carName + CAR_POSITION_FORMAT + positionDisplay);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));

        System.out.println(WINNER_ANNOUNCEMENT_PREFIX + winnerNames);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}