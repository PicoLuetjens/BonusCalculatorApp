package de.szut;

import de.szut.exception.BonusCalculationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BonusCalculatorTest {

    private final BonusCalculator bonusCalculator = new BonusCalculator();

    @ParameterizedTest
    @MethodSource("employeeProvider")
    @DisplayName("Correct bonus calculation for given employee")
    void shouldReturnCalculatedBonusForGivenEmployee(Employee employee, double expectedBonus) {

        double result = bonusCalculator.calculateBonus(employee);

        assertThat(result).withFailMessage("unexpected result").isEqualTo(expectedBonus);
    }

    @Test
    @DisplayName("Correct handling for null source employee")
    void shouldThrowExceptionWhenGivenEmployeeIsNull() {
        Employee employee = null;

        assertThatThrownBy(() -> bonusCalculator.calculateBonus(employee)).isInstanceOf(BonusCalculationException.class);
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