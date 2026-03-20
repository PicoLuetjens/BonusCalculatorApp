package de.szut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseBonusTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 140, 1350, 1250, 60, 4350, 3450, 160, 340, 123, 104, 1})
    @DisplayName("Correct bonus calculation for given bonus")
    void shouldReturnCorrectAmountForGivenBonus(double bonus) {
        BaseBonus baseBonus = new BaseBonus(bonus);

        assertEquals(baseBonus.calculateBonus(), bonus, "unexpected result");
    }
}