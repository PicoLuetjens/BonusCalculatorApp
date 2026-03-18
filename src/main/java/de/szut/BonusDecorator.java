package de.szut;

public abstract class BonusDecorator implements Bonus {

    protected Bonus bonus;

    public BonusDecorator(Bonus bonus) {
        this.bonus = bonus;
    }

    public double calculateBonus() {
        return bonus.calculateBonus();
    }

}
