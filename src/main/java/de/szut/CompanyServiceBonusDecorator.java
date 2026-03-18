package de.szut;

public class CompanyServiceBonusDecorator extends BonusDecorator {

    private final int yearInterval = 5;
    private final double bonusPerInterval = 100;
    private final int years;

    public CompanyServiceBonusDecorator(Bonus bonus, int years) {
        super(bonus);
        this.years = years;
    }

    @Override
    public double calculateBonus() {
        double currentBonus = super.calculateBonus();
        int intervals = years / yearInterval;
        double extra = intervals * bonusPerInterval;
        return currentBonus + extra;
    }
}
