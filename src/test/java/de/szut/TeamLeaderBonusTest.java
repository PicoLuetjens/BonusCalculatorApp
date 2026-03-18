package de.szut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamLeaderBonusTest {

    @ParameterizedTest
    @MethodSource("bonusProvider")
    @DisplayName("Correct bonus calculation for team leader")
    void shouldReturnCorrectlyCalculatedBonusForTeamLeader(double baseBonus, boolean isTeamLeder, double expectedBonus) {
        Bonus bonus = new BaseBonus(baseBonus);

        bonus = new TeamLeaderBonus(bonus, isTeamLeder);

        double result = bonus.calculateBonus();

        assertEquals(expectedBonus, result, "unexpected result");
    }

    public static Stream<Arguments> bonusProvider() {
        return Stream.of(
                Arguments.of(1000d, true, 1200d),
                Arguments.of(1300d, true, 1500d),
                Arguments.of(1400d, true, 1600d),
                Arguments.of(1600d, false, 1600d),
                Arguments.of(1900d, false, 1900d)
        );
    }
}