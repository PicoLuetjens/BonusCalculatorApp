package de.szut;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BonusServiceTest {

    private final BonusService bonusService = new BonusService();

    @Test
    void shouldReturnAppliedBonus() {
        assertThat(bonusService.applyBonus(3)).isEqualTo(1);
    }
}