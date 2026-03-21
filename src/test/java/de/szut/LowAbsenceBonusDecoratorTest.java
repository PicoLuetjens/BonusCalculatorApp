package de.szut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LowAbsenceBonusDecoratorTest {

    @ParameterizedTest
    @MethodSource("bonusProvider")
    @DisplayName("Correct bonus calculation for low absence")
    void shouldReturnCorrectlyCalculatedBonusForLowAbsence(double baseBonus, int absentDays, double expectedBonus) {
        Bonus bonus = new BaseBonus(baseBonus);

        bonus = new LowAbsenceBonusDecorator(bonus, absentDays);

        double result = bonus.calculateBonus();

        assertThat(result).withFailMessage("unexpected result").isEqualTo(expectedBonus);
    }

    public static Stream<Arguments> bonusProvider() {
        return Stream.of(
                Arguments.of(1000d, 1, 1600d),
                Arguments.of(1000d, 4, 1600d),
                Arguments.of(1000d, 7, 1300d),
                Arguments.of(1000d, 15, 1300d),
                Arguments.of(1000d, 20, 1000d)
        );
    }
}