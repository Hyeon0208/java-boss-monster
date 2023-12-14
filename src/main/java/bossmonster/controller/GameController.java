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
    private int count;

    public GameController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
        this.count = 0;
    }

    public void start() {
        BossMonster bossMonster = setUpBossMonster();
        Player player = setUpPlayer();
        raid(player, bossMonster);
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


    private void raid(Player player, BossMonster bossMonster) {
        outputView.printRaidStartMessage();
        while (true) {
            showRaidProgressStage(player, bossMonster);
            attackOfPlayer(player, bossMonster);
            if (bossMonster.die()) {
                outputView.printPlayerWinningMessage(player, count);
                break;
            }
            attackOfBossMonster(bossMonster, player);
            if (player.die()) {
                outputView.printBossMonsterWinningMessage(bossMonster, player);
                break;
            }
        }
    }

    private void showRaidProgressStage(Player player, BossMonster bossMonster) {
        outputView.printBossMonsterStatus(bossMonster);
        if (count == 0) {
            outputView.printInitialBossMonsterAppearance();
        }
        if (count > 0) {
            outputView.printHitBossMonsterAppearance();
        }
        outputView.printPlayerStatus(player);
        count++;
    }

    private void attackOfPlayer(Player player, BossMonster bossMonster) {
        try {
            outputView.printAttackCommandInputMessage();
            String attackCommand = inputHandler.receiveValidatedAttackCommand();
            outputView.printNewLine();
            int playerAttackDamage = player.attack(AttackInfo.from(attackCommand));
            outputView.printPlayerAttackMessage(playerAttackDamage);
            bossMonster.reduceHpBy(playerAttackDamage);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            attackOfPlayer(player, bossMonster);
        }
    }

    private void attackOfBossMonster(BossMonster bossMonster, Player player) {
        int bossMonsterAttackDamage = bossMonster.attack(new RandomDamageGenerator());
        outputView.printBossMonsterAttackMessage(bossMonsterAttackDamage);
        player.reduceHpBy(bossMonsterAttackDamage);
    }
}
