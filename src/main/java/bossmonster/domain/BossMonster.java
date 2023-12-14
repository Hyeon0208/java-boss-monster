package bossmonster.domain;

public class BossMonster {
    private int hp;

    public BossMonster(int hp) {
        this.hp = hp;
    }

    public int attack(NumberGenerator numberGenerator) {
        return numberGenerator.generate();
    }

    public void reduceHpBy(int damage) {
        hp -= damage;
    }

    public boolean die() {
        return hp <= 0;
    }
}
