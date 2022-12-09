package baseball;

import baseball.controller.GameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
    }

}
