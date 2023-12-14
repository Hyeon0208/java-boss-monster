package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bossmonster.constant.GameValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {
    Player player;

    @BeforeEach
    void init() {
        player = Player.of("hyeon", new int[]{100, 100});
    }

    @DisplayName("물리 공격은 10의 데미지를 준다.")
    @Test
    void physicalAttack() {
        AttackInfo physicalAttack = AttackInfo.from(GameValue.PHYSICAL_ATTACK);

        int damage = player.attack(physicalAttack);

        assertThat(damage).isEqualTo(GameValue.PHYSICAL_DAMAGE);
    }

    @DisplayName("마법 공격은 20의 데미지를 준다.")
    @Test
    void magicAttack() {
        AttackInfo magicAttack = AttackInfo.from(GameValue.MAGIC_ATTACK);

        int damage = player.attack(magicAttack);

        assertThat(damage).isEqualTo(GameValue.MAGIC_DAMAGE);
    }

    @DisplayName("물리 공격은 10의 mp를 회복한다.")
    @Test
    void physicalAttackMpConsumption() {
        AttackInfo magicAttack = AttackInfo.from(GameValue.MAGIC_ATTACK);
        player.attack(magicAttack);

        AttackInfo physicalAttack = AttackInfo.from(GameValue.PHYSICAL_ATTACK);
        player.attack(physicalAttack);

        int mp = player.getMp();

        assertThat(mp).isEqualTo(80);
    }

    @DisplayName("마법 공격은 20의 mp를 소모한다.")
    @Test
    void magicAttackMpConsumption() {
        AttackInfo magicAttack = AttackInfo.from(GameValue.MAGIC_ATTACK);

        player.attack(magicAttack);
        int mp = player.getMp();

        assertThat(mp).isEqualTo(70);
    }

    @DisplayName("50의 데미지를 받으면 남은 hp는 50이 된다.")
    @Test
    void reduceHpBy() {
        player.reduceHpBy(50);

        int hp = player.getHp();

        assertThat(hp).isEqualTo(50);
    }

    @DisplayName("hp가 0이되면 true를 반환한다.")
    @ParameterizedTest
    @CsvSource({"90, false", "100, true"})
    void die(int damage, boolean expected) {
        player.reduceHpBy(damage);

        boolean die = player.die();

        assertThat(die).isEqualTo(expected);
    }
}