package bossmonster.domain;

import bossmonster.constant.GameValue;

public class Player {
    private final String name;
    private final int initialHp;
    private final int initialMp;
    private int hp;
    private int mp;

    private Player(String name, int hp, int mp) {
        this.name = name;
        this.initialHp = hp;
        this.initialMp = mp;
        this.hp = hp;
        this.mp = mp;
    }

    public static Player of(String name, int[] status) {
        return new Player(name, status[GameValue.HP_INDEX], status[GameValue.MP_INDEX]);
    }

    public int attack(AttackInfo attackInfo) {
        if (isLowMp(attackInfo.getConsumption())) {
            throw new IllegalArgumentException("[ERROR] mp가 부족합니다.");
        }
        if (attackInfo.getDamage() == 10) {
            increaseMp(attackInfo.getConsumption());
        }
        if (attackInfo.getDamage() == 20) {
            reduceMpBy(attackInfo.getConsumption());
        }
        return attackInfo.getDamage();
    }

    public void reduceHpBy(int damage) {
        hp -= damage;
    }

    private void reduceMpBy(int consumption) {
        mp -= consumption;
    }

    private void increaseMp(int consumption) {
        if ((mp + consumption) < initialMp) {
            mp += consumption;
        }
    }

    private boolean isLowMp(int consumption) {
        return mp - consumption < 0;
    }

    public boolean die() {
        return hp <= 0;
    }

    public String getName() {
        return name;
    }

    public int getInitialHp() {
        return initialHp;
    }

    public int getInitialMp() {
        return initialMp;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }
}
