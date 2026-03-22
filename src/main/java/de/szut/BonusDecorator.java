package de.szut;

import de.szut.exception.BonusCalculationException;

public abstract class BonusDecorator implements Bonus {

    protected Bonus bonus;

    protected BonusDecorator(Bonus bonus) {
        if(bonus == null) {
            throw new BonusCalculationException("given bonus cannot be null");
        }
        this.bonus = bonus;
    }

    public double calculateBonus() {
        return bonus.calculateBonus();
    }

}
