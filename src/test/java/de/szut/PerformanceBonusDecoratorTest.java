package de.szut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PerformanceBonusDecoratorTest {

    @ParameterizedTest
    @MethodSource("bonusProvider")
    @DisplayName("Correct bonus calculation for performance points")
    void shouldReturnCorrectlyCalculatedBonusForGivenPerformancePoints(double baseBonus, int performancePoints, double expectedBonus) {
        Bonus bonus = new BaseBonus(baseBonus);

        bonus = new PerformanceBonusDecorator(bonus, performancePoints);

        double result = bonus.calculateBonus();

        assertThat(result).withFailMessage("unexpected result").isEqualTo(expectedBonus);
    }

    private static Stream<Arguments> bonusProvider() {
        return Stream.of(
                Arguments.of(1000d, 20, 1000d),
                Arguments.of(1000d, 30, 1300d),
                Arguments.of(1000d, 45, 1300d),
                Arguments.of(1000d, 70, 1600d),
                Arguments.of(1000d, 100, 1900d)
        );
    }
}