package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private RacingGame racingGame;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(List.of("pobi", "woni", "jun"));
        cars = racingGame.getCars();
    }

    @Test
    @DisplayName("이름 목록으로 Car 객체 목록을 생성한다.")
    void createRacingGameWithCars() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");

        // when
        // @BeforeEach의 racingGame과 중복되지 않도록 localRacingGame 사용
        RacingGame localRacingGame = new RacingGame(carNames);

        // then
        List<Car> localCars = localRacingGame.getCars();
        assertThat(localCars).hasSize(3);
        assertThat(localCars.stream().map(Car::getName))
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("가장 멀리 전진한 자동차 한 명을 우승자로 선정한다.")
    void findWinners_ShouldReturnSingleWinner() {
        // given: pobi=2, woni=1, jun=0 상태를 만듦
        cars.get(0).move(4);
        cars.get(0).move(4);
        cars.get(1).move(4);

        // when
        List<Car> winners = racingGame.findWinners();

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners.stream().map(Car::getName))
                .containsExactly("pobi");
    }

    @Test
    @DisplayName("가장 멀리 전진한 자동차가 여러 명이면 공동 우승자로 선정한다.")
    void findWinners_ShouldReturnMultipleWinners() {
        // given: pobi=2, woni=1, jun=2 상태를 만듦
        cars.get(0).move(4);
        cars.get(0).move(4);
        cars.get(1).move(4);
        cars.get(2).move(4);
        cars.get(2).move(4);

        // when
        List<Car> winners = racingGame.findWinners();

        // then
        assertThat(winners).hasSize(2);
        assertThat(winners.stream().map(Car::getName))
                .containsExactly("pobi", "jun");
    }
}