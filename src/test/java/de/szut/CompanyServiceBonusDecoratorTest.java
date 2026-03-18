package de.szut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompanyServiceBonusDecoratorTest {

    @ParameterizedTest
    @MethodSource("bonusProvider")
    @DisplayName("Correct bonus calculation from base bonus")
    void shouldReturnCorrectlyCalculatedBonusFromGivenBaseBonus(int baseBonus, int years, int expectedBonus) {
        Bonus bonus = new BaseBonus(baseBonus);

        bonus = new CompanyServiceBonusDecorator(bonus, years);

        double result = bonus.calculateBonus();

        assertEquals(expectedBonus, result, "unexpected result");

    }

    private static Stream<Arguments> bonusProvider() {
        return Stream.of(
            Arguments.of(1000, 10, 1200),
            Arguments.of(1000, 5, 1100),
            Arguments.of(1000, 2, 1000),
            Arguments.of(1000, 15, 1300),
            Arguments.of(1000, 20, 1400)
        );

    }
}