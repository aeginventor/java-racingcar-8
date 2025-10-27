package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차는 이름을 가지고 생성된다.")
    void createCar() {
        // given
        String carName = "pobi";

        // when
        Car car = new Car(carName);

        // then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차는 처음 생성 시 위치(position)가 0이다.")
    void createCarWithInitialPosition() {
        // given
        Car car = new Car("pobi");

        // when
        int position = car.getPosition();

        // then
        assertThat(position).isZero();
    }

}
