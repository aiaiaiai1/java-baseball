package baseball.controller;

import baseball.domain.Command;
import baseball.domain.Game;
import baseball.domain.Numbers;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Game game = new Game();

    public void run() {
        outputView.notifyStart();
        while (true) {
            game.initiateComputer();
            play();
            outputView.notifyEnd();
            inputView.notifyInputRestartOrQuit();
            if (inputView.readCommand() == Command.QUIT) {
                break;
            }
        }
    }

    private void play() {
        while (true) {
            inputView.notifyInputNumbers();
            Numbers userNumbers = inputView.readNumbers();
            Result result = game.getResult(userNumbers);
            outputView.notifyHint(result);
            if (result.checkWin()) {
                break;
            }
        }
    }

}
