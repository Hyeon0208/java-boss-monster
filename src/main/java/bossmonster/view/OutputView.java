package bossmonster.view;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;

public class OutputView {

    public void printBossMonsterHpInputMessage() {
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
    }

    public void printPlayerNameInputMessage() {
        System.out.println("플레이어의 이름을 입력해주세요");
    }

    public void printPlayerStatusInputMessage() {
        System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
    }

    public void printRaidStartMessage() {
        System.out.println("보스 레이드를 시작합니다!");
    }

    public void printBossMonsterStatus(BossMonster bossMonster) {
        System.out.println("============================");
        System.out.printf("BOSS HP [%d/%d]\n", bossMonster.getHp(), bossMonster.getInitialHp());
    }

    public void printInitialBossMonsterAppearance() {
        System.out.println("""
        ____________________________
           ^-^
         / 0 0 \\
        (   "   )
         \\  -  /
          - ^ -
        ____________________________
        """);
    }

    public void printHitBossMonsterAppearance() {
        System.out.println("""
        ____________________________
           ^-^
         / x x \\
        (   "\\  )
         \\  ^  /
          - ^ -
        ____________________________
        """);
    }

    public void printPlayerStatus(Player player) {
        System.out.printf("%s HP [%d/%d] MP [%d/%d]\n", player.getName(), player.getHp(), player.getInitialHp(),
                player.getMp(), player.getInitialMp());
        System.out.println("============================");
        printNewLine();
    }

    public void printAttackCommandInputMessage() {
        System.out.println("어떤 공격을 하시겠습니까?");
        System.out.println("1. 물리 공격");
        System.out.println("2. 마법 공격");
    }

    public void printPlayerAttackMessage(int damge) {
        if (damge == 10) {
            System.out.printf("물리 공격을 했습니다. (입힌 데미지: %d)\n", damge);
        }
        if (damge == 20) {
            System.out.printf("마법 공격을 했습니다. (입힌 데미지: %d)\n", damge);
        }
    }

    public void printBossMonsterAttackMessage(int damage) {
        System.out.printf("보스가 공격 했습니다. (입힌 데미지: %d)\n", damage);
    }

    public void printPlayerWinningMessage(Player player, int count) {
        printNewLine();
        System.out.printf("%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다.\n", player.getName(), count);
    }

    public void printBossMonsterWinningMessage(BossMonster bossMonster, Player player) {
        printBossMonsterStatus(bossMonster);
        System.out.println("""
        ____________________________
           ^-^
         / ^ ^ \\
        (   "   )
         \\  3  /
          - ^ -
        ____________________________
        """);
        printPlayerStatus(player);
        System.out.printf("%s의 HP가 0이 되었습니다.\n", player.getName());
        System.out.println("보스 레이드에 실패했습니다.");
    }

    public void printNewLine() {
        System.out.println();
    }
}
