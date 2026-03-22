package de.szut;

import de.szut.exception.BonusCalculationException;

public class BonusCalculator {

    private final BonusService bonusService = new BonusService();

    public double calculateBonus(Employee employee) {

        if(employee == null) {
            throw new BonusCalculationException("given employee cannot be null");
        }

        Bonus bonus = new BaseBonus(1000);

        bonus = new CompanyServiceBonusDecorator(bonus, employee.companyService());
        bonus = new ProjectCompletionBonusDecorator(bonus, employee.completedProjects());
        bonus = new TeamLeaderBonusDecorator(bonus, employee.teamLeader());
        bonus = new LowAbsenceBonusDecorator(bonus, employee.absentDays());
        bonus = new HighAbsencePenaltyDecorator(bonus, employee.absentDays());
        bonus = new PerformanceBonusDecorator(bonus, employee.performancePoints());

        double result = bonus.calculateBonus();

        return bonusService.applyBonus(result);
    }
}
