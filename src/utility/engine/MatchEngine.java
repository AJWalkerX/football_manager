package utility.engine;

import entities.Match;
import entities.MatchStats;
import entities.Team;

public class MatchEngine {
	private final TeamStatsCalculator teamStatsCalculator;
	private final EventSimulator eventSimulator;
	private static final double EVENT_POSSIBILITY = 0.03;
	
	public MatchEngine(TeamStatsCalculator teamStatsCalculator, EventSimulator eventSimulator) {
		this.teamStatsCalculator = teamStatsCalculator;
		this.eventSimulator = eventSimulator;
	}
	
	public void simulateMatch(Match match) {
		MatchStats matchStats = teamStatsCalculator.calculateTeamPassDistribution(match);
		Team homeTeam = teamStatsCalculator.getTeamById(match.getHomeTeamId());
		Team awayTeam = teamStatsCalculator.getTeamById(match.getAwayTeamId());
		
		int totalPass = matchStats.getAwayTeam_Passes() + matchStats.getHomeTeam_Passes();
		int homeTeamBallPercantage = matchStats.getHomeTeamBallPercantage();
		
		for (int i = 0; i < totalPass; i++) {
			if (Math.random() <= EVENT_POSSIBILITY) {
				Team attackingTeam = teamStatsCalculator.decideAttackingTeam(homeTeam, awayTeam, homeTeamBallPercantage);
				Team defenceTeam = attackingTeam == homeTeam ? awayTeam : homeTeam;
				
				if (eventSimulator.makeFinalPass(attackingTeam, matchStats) &&
						eventSimulator.takeShot(attackingTeam, matchStats)) {
					if (!eventSimulator.makeSave(defenceTeam, matchStats)) {
						updateScore(match, attackingTeam, homeTeam);
					}
				}
			}
		}
	}
	
	private void updateScore(Match match, Team attackingTeam, Team homeTeam) {
		System.out.println("GOOOOOOOLLLL " + attackingTeam.getTeamName() + " scores amazing goal!!!");
		if (attackingTeam == homeTeam) {
			match.setHomeTeamScore(match.getHomeTeamScore() + 1);
		} else {
			match.setAwayTeamScore(match.getAwayTeamScore() + 1);
		}
		System.out.println("Score = " + match.getHomeTeamScore() + " - " + match.getAwayTeamScore());
	}
}