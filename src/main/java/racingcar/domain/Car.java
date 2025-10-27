package racingcar.domain;

public class Car {
    private static final int MOVE_CONDITION_THRESHOLD = 4;
    private static final String POSITION_VISUAL = "-";

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

    public String getPositionDisplay() {
        return POSITION_VISUAL.repeat(this.position);
    }
}
