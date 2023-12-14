package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bossmonster.mock.FakeDamageGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BossMonsterTest {
    BossMonster bossMonster;

    @BeforeEach
    void init() {
        bossMonster = BossMonster.from(100);
    }

    @Test
    void attack() {
        int attack = bossMonster.attack(new FakeDamageGenerator());

        assertThat(attack).isEqualTo(10);
    }

    @Test
    void reduceHpBy() {
        bossMonster.reduceHpBy(50);

        int hp = bossMonster.getHp();

        assertThat(hp).isEqualTo(50);
    }

    @Test
    void die() {
        bossMonster.reduceHpBy(100);

        boolean die = bossMonster.die();

        assertThat(die).isTrue();
    }
}