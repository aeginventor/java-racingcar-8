package racingcar.domain;

public class Car {
    // 1주차 피드백: '매직 넘버'를 의미 있는 상수로 변경
    private static final int MOVE_CONDITION_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION_THRESHOLD) {
            this.position++;
        }
    }
}
