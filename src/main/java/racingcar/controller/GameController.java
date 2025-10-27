package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        try {
            String carNamesInput = inputView.readCarNames();

            String[] carNameArray = carNamesInput.split(",");
            List<String> carNames = new ArrayList<>();
            for (String name : carNameArray) {
                carNames.add(name.trim());
            }

            InputValidator.validateCarNames(carNames);

            String tryCountInput = inputView.readTryCount();
            int tryCount = InputValidator.validateTryCount(tryCountInput);

            RacingGame racingGame = new RacingGame(carNames);

            outputView.printExecutionResultHeader();
            for (int i = 0; i < tryCount; i++) {
                racingGame.raceOneRound();
                outputView.printRoundResult(racingGame.getCars());
            }

            List<Car> winners = racingGame.findWinners();
            outputView.printWinners(winners);

        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }
}
