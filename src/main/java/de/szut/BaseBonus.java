package de.szut;

public class BaseBonus implements Bonus {

    private final double base;

    public BaseBonus(double base) {
        this.base = base;
    }

    @Override
    public double calculateBonus(){
        return base;
    }
}
