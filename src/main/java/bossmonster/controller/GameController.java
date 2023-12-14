package bossmonster.controller;

import bossmonster.domain.BossMonster;
import bossmonster.view.OutputView;
import bossmonster.view.hanlder.InputHandler;

public class GameController {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public GameController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printBossMonsterHpInputMessage();
        int bossMonsterHp = inputHandler.receiveValidatedBossMonsterHp();
        outputView.printNewLine();

        BossMonster bossMonster = new BossMonster(bossMonsterHp);
    }
}
