package de.szut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CompanyServiceBonusDecoratorTest {

    @ParameterizedTest
    @MethodSource("bonusProvider")
    @DisplayName("Correct bonus calculation for given years")
    void shouldReturnCorrectlyCalculatedBonusForGivenYears(double baseBonus, int years, double expectedBonus) {
        Bonus bonus = new BaseBonus(baseBonus);

        bonus = new CompanyServiceBonusDecorator(bonus, years);

        double result = bonus.calculateBonus();

        assertThat(result).withFailMessage("unexpected result").isEqualTo(expectedBonus);
    }

    private static Stream<Arguments> bonusProvider() {
        return Stream.of(
            Arguments.of(1000d, 10, 1200d),
            Arguments.of(1000d, 5, 1100d),
            Arguments.of(1000d, 2, 1000d),
            Arguments.of(1000d, 15, 1300d),
            Arguments.of(1000d, 20, 1400d)
        );
    }
}