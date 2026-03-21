package de.szut;

public class BonusService {
    private final double minBonus = 500;
    private final double maxBonus = 5000;

    public double applyBonus(double bonus) {
        if(bonus > maxBonus) {
            return maxBonus;
        }
        return Math.max(bonus, minBonus);
    }
}
