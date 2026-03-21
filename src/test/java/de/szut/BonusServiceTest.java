package de.szut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    private final BonusService bonusService = new BonusService();

    @ParameterizedTest
    @MethodSource("bonusProvider")
    @DisplayName("Corrected Bonus boundary for given bonus")
    void shouldReturnCorrectedBonusForGivenBonus(double bonus, double expectedBonus) {

        double result = bonusService.applyBonus(bonus);

        assertEquals(expectedBonus, result, "unexpected result");
    }

    private static Stream<Arguments> bonusProvider() {
        return Stream.of(
                Arguments.of(400d, 500d),
                Arguments.of(500d, 500d),
                Arguments.of(1200d, 1200d),
                Arguments.of(5000d, 5000d),
                Arguments.of(5200d, 5000d)
        );
    }
}