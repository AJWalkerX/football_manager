package models;

import entities.League;
import entities.Match;
import entities.Stadium;
import entities.Team;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

public class MatchModel {
	private DatabaseModel databaseModel;
	private Optional<Team> homeTeam;
	private Optional<Team> awayTeam;
	private Integer homeTeamScore;
	private Integer awayTeamScore;
	private String winner;
	private LocalDate matchDate;
	private Optional<Stadium> stadium;
	private Optional<League> league;
//	TODO:Score muhabeti gelecek
	
	public MatchModel(DatabaseModel databaseModel, Match match) {
		this.databaseModel = databaseModel;
		this.league = databaseModel.leagueDB.findByID(match.getLeagueID());
		this.homeTeam = databaseModel.teamDB.findByID(match.getHomeTeamID());
		this.awayTeam = databaseModel.teamDB.findByID(match.getAwayTeamID());
		this.stadium = databaseModel.stadiumDB.findByID(match.getHomeTeamID());
		this.matchDate = match.getMatchDate();
		this.homeTeamScore=match.getHomeTeamScore();
		this.awayTeamScore = match.getAwayTeamScore();
		
	}
	
	
	public void displayMatchInfo() {
		System.out.println("Stadium             : " + (stadium.isPresent() ? stadium.get().getName() : "N/A"));
		System.out.println("Home Team           : " + (homeTeam.isPresent()? homeTeam.get().getTeamName() : "N/A"));
		System.out.println("Away Team           : " + (awayTeam.isPresent()? awayTeam.get().getTeamName() : "N/A"));
		System.out.println("Home Team Score     : " + homeTeamScore);
		System.out.println("Away Team Score     : " + awayTeamScore);
		System.out.println("Match Date          : " + matchDate);
		System.out.println("--------------------------------------------------");
	}
	
}