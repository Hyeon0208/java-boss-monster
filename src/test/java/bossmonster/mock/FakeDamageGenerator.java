package bossmonster.mock;

import bossmonster.domain.NumberGenerator;

public class FakeDamageGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return 10;
    }
}
