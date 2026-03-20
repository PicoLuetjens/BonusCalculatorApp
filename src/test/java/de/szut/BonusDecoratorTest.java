package de.szut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class BonusDecoratorTest {

    private final Bonus bonus = mock(Bonus.class);
    private final BonusDecorator bonusDecorator = new  BonusDecorator(bonus) {};

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 140, 1350, 1250, 60, 4350, 3450, 160, 340, 123, 104, 14})
    @DisplayName("Correct bonus calculation for given bonus")
    void shouldReturnCorrectAmountForGivenBonus(double bonusValue) {

        given(bonus.calculateBonus()).willReturn(bonusValue);

        assertEquals(bonusDecorator.calculateBonus(), bonusValue, "unexpected result");
    }
}