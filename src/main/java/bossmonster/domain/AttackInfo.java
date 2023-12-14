package bossmonster.domain;

import bossmonster.constant.GameValue;

public class AttackInfo {
    private final int damage;
    private final int consumption;

    private AttackInfo(int damage, int consumption) {
        this.damage = damage;
        this.consumption = consumption;
    }

    public static AttackInfo from(String command) {
        int damage = 0;
        int consumption = 0;
        if (command.equals(GameValue.PHYSICAL_ATTACK)) {
            consumption = 10;
            damage = 10;
        }
        if (command.equals(GameValue.MAGIC_ATTACK)) {
            consumption = 30;
            damage = 20;
        }
        return new AttackInfo(damage, consumption);
    }

    public int getDamage() {
        return damage;
    }

    public int getConsumption() {
        return consumption;
    }
}
