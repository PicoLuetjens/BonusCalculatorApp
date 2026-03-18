package de.szut;

public class LowAbsenceBonusDecorator extends BonusDecorator {

    private final int  bonusLevel1 = 15;
    private final int bonusLevel2 = 5;
    private final double bonusLevel1Amount = 300;
    private final double bonusLevel2Amount = 600;
    private final int absentDays;

    public LowAbsenceBonusDecorator(Bonus bonus, int absentDays) {
        super(bonus);
        this.absentDays = absentDays;
    }

    @Override
    public double calculateBonus() {
        double currentBonus = super.calculateBonus();

        if (absentDays <= bonusLevel2) {
            currentBonus += bonusLevel2Amount;
        }
        else if (absentDays <= bonusLevel1) {
            currentBonus += bonusLevel1Amount;
        }
        return currentBonus;
    }

}
