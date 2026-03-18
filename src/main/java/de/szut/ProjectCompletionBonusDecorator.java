package de.szut;

public class ProjectCompletionBonusDecorator extends BonusDecorator {

    private final double bonusPerProject = 500;
    private final int projects;

    public ProjectCompletionBonusDecorator(Bonus bonus, int projects) {
        super(bonus);
        this.projects = projects;
    }

    @Override
    public double calculateBonus() {
        double currentBonus = super.calculateBonus();
        double extra = projects * bonusPerProject;
        return currentBonus + extra;
    }
}
