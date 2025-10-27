package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printExecutionResultHeader() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            String carName = car.getName();
            String positionDisplay = car.getPositionDisplay();
            System.out.println(carName + " : " + positionDisplay);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}