package entities;

import databases.StatsDB;
import utility.FileIOWriter;

public class Stats extends BaseEntity {
	private Integer leagueID;
	private Integer teamID;
	private int gamesPlayed;
	private int totalWins;
	private int totalDraws;
	private int totalLosses;
	private int goalsFor;
	private int goalsAgainst;
	private int goalsDifference;
	private int points;
	
	public Stats(StatsDB statsDB, Integer leagueID, Integer teamID) {
		super.id = statsDB.findAll().size()+1;
		this.leagueID = leagueID;
		this.teamID = teamID;
		statsDB.save(this);
		FileIOWriter.writeStatsToBin(statsDB);
	}
	
	public Integer getLeagueID() {
		return leagueID;
	}
	
	public void setLeagueID(Integer leagueID) {
		this.leagueID = leagueID;
	}
	
	public Integer getTeamID() {
		return teamID;
	}
	
	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	
	public int getTotalWins() {
		return totalWins;
	}
	
	public void setTotalWins(int totalWins) {
		this.totalWins = totalWins;
	}
	
	public int getTotalDraws() {
		return totalDraws;
	}
	
	public void setTotalDraws(int totalDraws) {
		this.totalDraws = totalDraws;
	}
	
	public int getTotalLosses() {
		return totalLosses;
	}
	
	public void setTotalLosses(int totalLosses) {
		this.totalLosses = totalLosses;
	}
	
	public int getGoalsFor() {
		return goalsFor;
	}
	
	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}
	
	public int getGoalsAgainst() {
		return goalsAgainst;
	}
	
	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}
	
	public int getGoalsDifference() {
		return goalsDifference;
	}
	
	public void setGoalsDifference(int goalsDifference) {
		this.goalsDifference = goalsDifference;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "Stats{" + "id=" + getId() +
				", leagueID='" + getLeagueID() + '\'' +
				", teamID='" + getTeamID() + '\'' +
				", gamesPlayed=" + getGamesPlayed() +
				", totalWins=" + getTotalWins() +
				", totalDraws=" + getTotalDraws() +
				", totalLosses=" + getTotalLosses() +
				", goalsFor=" + getGoalsFor() +
				", goalAgainst=" + getGoalsAgainst() +
				", goalDifference=" + getGoalsDifference() +
				", points=" + getPoints() + '}';
	}
}