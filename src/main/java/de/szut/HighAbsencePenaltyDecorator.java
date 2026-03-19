package de.szut;

public class HighAbsencePenaltyDecorator extends BonusDecorator {

    private final int penaltyLevel1 = 20;
    private final int penaltyLevel2 = 30;
    private final double penaltyLevel1Amount = 200;
    private final double penaltyLevel2Amount = 300;
    private final int absentDays;

    public HighAbsencePenaltyDecorator(Bonus bonus, int absentDays) {
        super(bonus);
        this.absentDays = absentDays;
    }

    @Override
    public double calculateBonus(){
        double currentBonus = super.calculateBonus();

        if (absentDays >= penaltyLevel2){
            currentBonus -= penaltyLevel2Amount;
        }
        else if (absentDays >= penaltyLevel1){
            currentBonus -= penaltyLevel1Amount;
        }
        return currentBonus;
    }
}
