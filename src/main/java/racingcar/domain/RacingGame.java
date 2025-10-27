package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

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
}