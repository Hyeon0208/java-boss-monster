package bossmonster;

import bossmonster.controller.GameController;
import bossmonster.view.ErrorView;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import bossmonster.view.hanlder.InputHandler;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = initHandler();
        OutputView outputView = new OutputView();
        GameController controller = new GameController(inputHandler, outputView);
        controller.start();
    }

    private static InputHandler initHandler() {
        InputView inputView = new InputView();
        ErrorView errorView = new ErrorView();
        return new InputHandler(inputView, errorView);
    }
}
