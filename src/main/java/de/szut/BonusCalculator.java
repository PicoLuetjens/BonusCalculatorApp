package de.szut;

public class BonusCalculator {

    private final BonusService bonusService = new BonusService();

    public double calculateBonus(Employee employee) {
        return bonusService.applyBonus(1);
    }
}
