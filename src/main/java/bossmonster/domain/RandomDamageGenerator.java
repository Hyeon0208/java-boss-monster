package bossmonster.domain;

import java.util.Random;

public class RandomDamageGenerator implements NumberGenerator {
    private static final int MIN_DAMAGE_RANGE = 1;
    private static final int MAX_DAMAGE_DAMAGE = 20;

    @Override
    public int generate() {
        return new Random().nextInt(MAX_DAMAGE_DAMAGE) + MIN_DAMAGE_RANGE;
    }
}
