package bossmonster.view;

public class OutputView {

    public void printBossMonsterHpInputMessage() {
        System.out.println("보스 몬스터의 HP를 입력해주세요.");
    }

    public void printPlayerNameInputMessage() {
        System.out.println("플레이어의 이름을 입력해주세요");
    }

    public void printPlayerStatus() {
        System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
    }

    public void printAttackCommandInputMessage() {
        System.out.println("어떤 공격을 하시겠습니까?");
        System.out.println("1. 물리 공격");
        System.out.println("2. 마법 공격");
    }

    public void printNewLine() {
        System.out.println();
    }
}
