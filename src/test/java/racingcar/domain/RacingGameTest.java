package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("이름 목록으로 Car 객체 목록을 생성한다.")
    void createRacingGameWithCars() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");

        // when
        RacingGame racingGame = new RacingGame(carNames);

        // then
        List<Car> cars = racingGame.getCars();
        assertThat(cars).hasSize(3);
        assertThat(cars.stream().map(Car::getName))
                .containsExactly("pobi", "woni", "jun");
    }
}