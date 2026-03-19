package de.szut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HighAbsencePenaltyDecoratorTest {

    @ParameterizedTest
    @MethodSource("bonusProvider")
    @DisplayName("Correct bonus calculation for high absence")
    void shouldReturnCorrectlyCalculatedBonusForHighAbsence(double baseBonus, int absentDays, double expectedBonus) {
        Bonus bonus = new BaseBonus(baseBonus);

        bonus = new HighAbsencePenaltyDecorator(bonus, absentDays);

        double result = bonus.calculateBonus();

        assertEquals(expectedBonus, result, "unexpected result");
    }

    public static Stream<Arguments> bonusProvider() {
        return Stream.of(
                Arguments.of(1200d, 1, 1200d),
                Arguments.of(1500d, 4, 1500d),
                Arguments.of(1000d, 19, 1000d),
                Arguments.of(1900d, 20, 1700d),
                Arguments.of(1700d, 30, 1400d)
        );
    }
}