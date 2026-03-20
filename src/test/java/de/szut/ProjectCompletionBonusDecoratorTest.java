package de.szut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectCompletionBonusDecoratorTest {

    @ParameterizedTest
    @MethodSource("bonusProvider")
    @DisplayName("Correct bonus calculation for completed projects")
    void shouldReturnCorrectlyCalculatedBonusForGivenProjectCompletions(double baseBonus, int completedProjects, double expectedBonus) {

        Bonus bonus = new BaseBonus(baseBonus);

        bonus = new ProjectCompletionBonusDecorator(bonus, completedProjects);

        double result = bonus.calculateBonus();

        assertEquals(expectedBonus, result, "unexpected result");
    }

    private static Stream<Arguments> bonusProvider() {
        return Stream.of(
                Arguments.of(1000d, 1, 1500d),
                Arguments.of(1000d, 3, 2500d),
                Arguments.of(1000d, 5, 3500d),
                Arguments.of(1000d, 7, 4500d),
                Arguments.of(1000d, 10, 6000d)
        );
    }
}