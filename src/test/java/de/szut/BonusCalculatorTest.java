package de.szut;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusCalculatorTest {

    private final BonusCalculator bonusCalculator = new BonusCalculator();

    @ParameterizedTest
    @MethodSource("employeeProvider")
    void shouldReturnCalculatedBonusForGivenEmployee(Employee employee, double expectedBonus) {

        double result = bonusCalculator.calculateBonus(employee);

        assertEquals(expectedBonus, result, "unexpected result");
    }

    private static Stream<Arguments> employeeProvider() {
        return Stream.of(
                Arguments.of(new Employee("Max Mustermann",
                        5,
                        30,
                        2,
                        10,
                        true),
                        2900d
                ),
                Arguments.of(new Employee("John Doe",
                        10,
                        80,
                        7,
                        15,
                        true),
                        5000d
                ),
                Arguments.of(new Employee("Marcel Davis",
                        3,
                        40,
                        1,
                        20,
                        false),
                        1600d
                ),
                Arguments.of(new Employee("Erika Mustermann",
                        10,
                        90,
                        4,
                        5,
                        true),
                        4900d
                )
        );
    }
}