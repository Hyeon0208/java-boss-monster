package bossmonster.controller;

import bossmonster.domain.AttackInfo;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.domain.RandomDamageGenerator;
import bossmonster.view.OutputView;
import bossmonster.view.hanlder.InputHandler;

public class GameController {
    private final InputHandler inputHandler;
    private final OutputView outputView;
    private int count = 0;

    public GameController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void start() {
        BossMonster bossMonster = setUpBossMonster();
        Player player = setUpPlayer();

        outputView.printRaidStartMessage();
        outputView.printNewLine();

        while (true) {
            outputView.printBossMonsterStatus(bossMonster);
            if (count == 0) {
                outputView.printInitialBossMonsterAppearance();
            }
            if (count > 0) {
                outputView.printHitBossMonsterAppearance();
            }
            outputView.printPlayerStatus(player);

            outputView.printAttackCommandInputMessage();
            String attackCommand = inputHandler.receiveValidatedAttackCommand();
            outputView.printNewLine();
            AttackInfo attackInfo = AttackInfo.from(attackCommand);

            int playerAttackDamage = player.attack(attackInfo);
            outputView.printPlayerAttackMessage(playerAttackDamage);
            bossMonster.reduceHpBy(playerAttackDamage);
            if (bossMonster.die()) {
                outputView.printPlayerWinningMessage(player, count);
                break;
            }

            int bossMonsterAttackDamage = bossMonster.attack(new RandomDamageGenerator());
            outputView.printBossMonsterAttackMessage(bossMonsterAttackDamage);
            outputView.printNewLine();
            player.reduceHpBy(bossMonsterAttackDamage);
            if (player.die()) {
                outputView.printBossMonsterWinningMessage(bossMonster, player);
                break;
            }
            count++;
        }
    }

    private BossMonster setUpBossMonster() {
        outputView.printBossMonsterHpInputMessage();
        int bossMonsterHp = inputHandler.receiveValidatedBossMonsterHp();
        outputView.printNewLine();
        return BossMonster.from(bossMonsterHp);
    }

    private Player setUpPlayer() {
        outputView.printPlayerNameInputMessage();
        String playerName = inputHandler.receiveValidatedPlayerName();
        outputView.printNewLine();
        outputView.printPlayerStatusInputMessage();
        int[] status = inputHandler.receiveValidatedPlayerStatus();
        outputView.printNewLine();
        return Player.of(playerName, status);
    }
}
