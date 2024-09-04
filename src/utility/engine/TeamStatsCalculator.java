package utility.engine;

import entities.Match;
import entities.MatchStats;
import entities.Player;
import entities.Team;
import models.DatabaseModel;

import java.util.Random;

public class TeamStatsCalculator {
	private static final Random random = new Random();
	private final DatabaseModel databaseModel;
	
	public TeamStatsCalculator(DatabaseModel databaseModel) {
		this.databaseModel = databaseModel;
	}
	
	public MatchStats calculateTeamPassDistribution(Match match) {
		MatchStats matchStats = new MatchStats(databaseModel, match.getId());
		int totalPass = random.nextInt(700, 1000);
		int standardDeviation = calculateStandardDeviation(totalPass);
		
		Team homeTeam = getTeamById(match.getHomeTeamId());
		Team awayTeam = getTeamById(match.getAwayTeamId());
		
		int homeTeamPower = calculateTeamPower(homeTeam);
		int awayTeamPower = calculateTeamPower(awayTeam);
		
		int homeTeamPassPercentage = calculatePassPercentage(homeTeamPower, awayTeamPower);
		int awayTeamPassPercentage = 100 - homeTeamPassPercentage;
		
		int homeTeamPasses = (int) Math.round((homeTeamPassPercentage / 100.0) * (totalPass + standardDeviation));
		int awayTeamPasses = (int) Math.round((awayTeamPassPercentage / 100.0) * (totalPass + standardDeviation));
		
		matchStats.setHomeTeam_Passes(homeTeamPasses);
		matchStats.setAwayTeam_Passes(awayTeamPasses);
		matchStats.setHomeTeamBallPercantage(homeTeamPassPercentage);
		matchStats.setAwayTeamBallPercantage(awayTeamPassPercentage);
		
		return matchStats;
	}
	
	
	public Team decideAttackingTeam(Team homeTeam, Team awayTeam, int homeTeamBallPercentage) {
		int randomValue = random.nextInt(101);
		return randomValue < homeTeamBallPercentage ? homeTeam : awayTeam;
	}
	private int calculateStandardDeviation(int value) {
		// Simplified standard deviation calculation for demo purposes
		return (int) (Math.sqrt(value) * 0.1);
	}
	
	private int calculateTeamPower(Team team) {
		return databaseModel.playerDB.findAll().stream()
		                             .filter(p -> p.getTeamId() == team.getId())
		                             .map(Player::getSkillLevel)
		                             .reduce(0, Integer::sum) / 11;
	}
	
	private int calculatePassPercentage(int homeTeamPower, int awayTeamPower) {
		int basePercentage = (int) (50 + (homeTeamPower - awayTeamPower) * 0.5);
		return Math.max(30, Math.min(70, basePercentage));
	}
	
	public Team getTeamById(int teamId) {
		return databaseModel.teamDB.findByID(teamId)
		                           .orElseThrow(() -> new IllegalArgumentException("Team not found with ID: " + teamId));
	}
}