package bossmonster.domain;

import bossmonster.constant.GameValue;

public class AttackInfo {
    private static final int PHYSICAL_ATTACK_MP_CONSUMPTION = 10;
    private static final int MAGIC_ATTACK_MP_CONSUMPTION = 30;
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
            consumption = PHYSICAL_ATTACK_MP_CONSUMPTION;
            damage = GameValue.PHYSICAL_DAMAGE;
        }
        if (command.equals(GameValue.MAGIC_ATTACK)) {
            consumption = MAGIC_ATTACK_MP_CONSUMPTION;
            damage = GameValue.MAGIC_DAMAGE;
        }
        return new AttackInfo(damage, consumption);
    }

    public boolean isPhysicalAttack() {
        return damage == GameValue.PHYSICAL_DAMAGE;
    }

    public boolean isMagicAttack() {
        return damage == GameValue.MAGIC_DAMAGE;
    }

    public int getDamage() {
        return damage;
    }

    public int getConsumption() {
        return consumption;
    }
}
