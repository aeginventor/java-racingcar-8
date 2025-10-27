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

    @Test
    @DisplayName("전진 조건(4 이상)을 만족하면 position이 1 증가한다.")
    void moveCarWhenConditionMet() {
        // given
        Car car = new Car("pobi");
        int forwardConditionValue = 4;

        // when
        car.move(forwardConditionValue);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("멈춤 조건(3 이하)을 만족하면 position이 변하지 않는다.")
    void stopCarWhenConditionNotMet() {
        // given
        Car car = new Car("pobi");
        int stopConditionValue = 3;

        // when
        car.move(stopConditionValue);

        // then
        assertThat(car.getPosition()).isZero(); // 0에서 변하지 않음
    }

}
