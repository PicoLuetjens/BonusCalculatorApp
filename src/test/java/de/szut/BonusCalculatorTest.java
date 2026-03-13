package de.szut;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BonusCalculatorTest {

    private final Employee employee = new Employee(
            "Max Mustermann",
            5,
            30,
            2,
            10,
            true
    );
    private final BonusCalculator bonusCalculator = new BonusCalculator();

    @Test
    void shouldReturnCalculatedBonus() {
        assertThat(bonusCalculator.calculateBonus(employee)).isEqualTo(1);
    }
}