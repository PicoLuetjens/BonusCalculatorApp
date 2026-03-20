package de.szut;

public class TeamLeaderBonusDecorator extends BonusDecorator {
    private final double teamLeaderBonus = 200;
    private final boolean isTeamLeader;

    public TeamLeaderBonusDecorator(Bonus bonus, boolean isTeamLeader) {
        super(bonus);
        this.isTeamLeader = isTeamLeader;
    }

    @Override
    public double calculateBonus() {
        double currentBonus = super.calculateBonus();

        return isTeamLeader ? currentBonus + teamLeaderBonus : currentBonus;
    }

}
