package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final List<Car> cars;

    public RacingGame(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        // 외부에서 cars 리스트를 수정하는 것을 방지 (e.g., cars.add(...))
        return Collections.unmodifiableList(cars);
    }

    public void raceOneRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            car.move(randomNumber);
        }
    }
}