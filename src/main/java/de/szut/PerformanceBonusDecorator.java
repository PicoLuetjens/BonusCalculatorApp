package de.szut;

public class PerformanceBonusDecorator extends BonusDecorator {
    private final int performanceBonusLevel1 = 30;
    private final int performanceBonusLevel2 = 60;
    private final int performanceBonusLevel3 = 90;
    private final double performanceBonusLevel1Amount = 300;
    private final double performanceBonusLevel2Amount = 600;
    private final double performanceBonusLevel3Amount = 900;
    private final int performancePoints;

    public PerformanceBonusDecorator(Bonus bonus, int performancePoints) {
        super(bonus);
        this.performancePoints = performancePoints;
    }

    @Override
    public double calculateBonus() {
        double currentBonus = super.calculateBonus();

        if(performancePoints >= performanceBonusLevel3) {
            currentBonus += performanceBonusLevel3Amount;
        }
        else if(performancePoints >= performanceBonusLevel2) {
            currentBonus += performanceBonusLevel2Amount;
        }
        else if(performancePoints >= performanceBonusLevel1) {
            currentBonus += performanceBonusLevel1Amount;
        }
        return currentBonus;
    }
}
