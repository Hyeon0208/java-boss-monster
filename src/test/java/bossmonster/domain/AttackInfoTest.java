package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AttackInfoTest {

    @DisplayName("물리 공격일 경우 true를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1, true", "2, false"})
    void isPhysicalAttack(String command, boolean expected) {
        AttackInfo attackInfo = AttackInfo.from(command);

        assertThat(attackInfo.isPhysicalAttack()).isEqualTo(expected);
    }

    @DisplayName("마법 공격일 경우 true를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1, false", "2, true"})
    void isMagicAttack(String command, boolean expected) {
        AttackInfo attackInfo = AttackInfo.from(command);

        assertThat(attackInfo.isMagicAttack()).isEqualTo(expected);
    }
}