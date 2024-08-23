package models;

import entities.League;
import entities.Match;
import entities.Team;

import java.time.LocalDate;
import java.util.Optional;

public class MatchModel {
	private DatabaseModel databaseModel;
	private Optional<Team> homeTeam;
	private Optional<Team> awayTeam;
	private Integer homeTeamScore;
	private Integer awayTeamScore;
	private String winner;
	private LocalDate matchDate;
	private Optional<League> league;
	//TODO:Fixture buraya eklenecek!
//	Map<Integer,Scores>
	
	public MatchModel(DatabaseModel databaseModel, Match match) {
		playMatch(match);
		this.databaseModel = databaseModel;
		this.league = databaseModel.leagueDB.findByID(match.getLeagueID());
		this.homeTeam = databaseModel.teamDB.findByID(match.getHomeTeamID());
		this.awayTeam = databaseModel.teamDB.findByID(match.getAwayTeamID());
		this.homeTeamScore = match.getHomeTeamScore();
		this.awayTeamScore = match.getAwayTeamScore();
		this.homeTeamScore = 0;
		this.awayTeamScore = 0;
		this.winner = (homeTeamScore > awayTeamScore) ?
				homeTeam.map(Team::getTeamName).orElse("Unknown") :
				awayTeam.map(Team::getTeamName).orElse("Unknown");
		this.matchDate = match.getMatchDate();
		this.league = databaseModel.leagueDB.findByID(match.getLeagueID());
	}
	
	public void displayMatchInfo() {
		System.out.println("Home Team           : " + homeTeam.get().getTeamName());
		System.out.println("Away Team           : " + awayTeam.get().getTeamName());
		System.out.println("Home Team Score     : " + this.homeTeamScore);
		System.out.println("Away Team Score     : " + this.awayTeamScore);
		System.out.println("Result              : " + this.winner);
		System.out.println("Match Date          : " + this.matchDate);
		System.out.println("--------------------------------------------------");
	}
	
	public Match playMatch(Match match) {
		match.setHomeTeamScore(match.getHomeTeamScore() + 2);
		match.setAwayTeamScore(match.getAwayTeamScore() + 1);
		return match;
	}
}