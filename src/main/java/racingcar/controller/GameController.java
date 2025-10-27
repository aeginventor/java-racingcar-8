package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        try {
            List<String> carNames = getCarNames();
            int tryCount = getTryCount();

            RacingGame racingGame = new RacingGame(carNames);
            runRounds(racingGame, tryCount);

            showWinners(racingGame);

        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            throw e;
        }
    }

    private List<String> getCarNames() {
        String carNamesInput = inputView.readCarNames();

        List<String> carNames = Stream.of(carNamesInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    private int getTryCount() {
        String tryCountInput = inputView.readTryCount();
        return InputValidator.validateTryCount(tryCountInput);
    }

    private void runRounds(RacingGame racingGame, int tryCount) {
        outputView.printExecutionResultHeader();
        for (int i = 0; i < tryCount; i++) {
            racingGame.raceOneRound();
            outputView.printRoundResult(racingGame.getCars());
        }
    }

    private void showWinners(RacingGame racingGame) {
        List<Car> winners = racingGame.findWinners();
        outputView.printWinners(winners);
    }
}