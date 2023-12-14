package bossmonster.view.hanlder;

import bossmonster.util.Separator;
import bossmonster.util.StringConvertor;
import bossmonster.view.ErrorView;
import bossmonster.view.InputView;
import java.util.function.Supplier;

public class InputHandler {
    private final InputView inputView;
    private final ErrorView errorView;

    public InputHandler(InputView inputView, ErrorView errorView) {
        this.inputView = inputView;
        this.errorView = errorView;
    }

    public int receiveValidatedBossMonsterHp() {
        String bossMonsterHp = receiveValidatedInput(inputView::inputBossMonsterHp);
        return StringConvertor.convertToInt(bossMonsterHp);
    }

    public String receiveValidatedPlayerName() {
        return receiveValidatedInput(inputView::inputPlayerName);
    }

    public int[] receiveValidatedPlayerStatus() {
        String status = receiveValidatedInput(inputView::inputPlayerStatus);
        return StringConvertor.convertStringArrayToIntArray(Separator.COMMA.split(status));
    }

    private <T> T receiveValidatedInput(Supplier<T> inputView) {
        while (true) {
            try {
                return inputView.get();
            } catch (IllegalArgumentException exception) {
                errorView.printErrorMessage(exception.getMessage());
            }
        }
    }
}