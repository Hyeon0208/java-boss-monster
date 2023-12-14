package bossmonster.domain;

public class BossMonster {
    private final int initialHp;
    private int hp;

    private BossMonster(int initialHp, int hp) {
        this.initialHp = initialHp;
        this.hp = hp;
    }

    public static BossMonster from(int hp) {
        return new BossMonster(hp, hp);
    }

    public int attack(NumberGenerator numberGenerator) {
        return numberGenerator.generate();
    }

    public void reduceHpBy(int damage) {
        if (hp - damage < 0) {
            hp = 0;
            return;
        }
        hp -= damage;
    }

    public boolean die() {
        return hp <= 0;
    }

    public int getInitialHp() {
        return initialHp;
    }

    public int getHp() {
        return hp;
    }
}
