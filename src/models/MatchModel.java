package models;

import entities.League;
import entities.Match;
import entities.Team;

import java.time.LocalDate;
import java.util.Optional;

public class MatchModel {
	private Optional<Team> homeTeam;
	private Optional<Team> awayTeam;
	private Integer homeTeamScore;
	private Integer awayTeamScore;
	private String winner;
	private LocalDate matchDate;
	private Optional<League> league;
	//TODO:Fixture buraya eklenecek!
	
	public MatchModel(DatabaseModel databaseModel, Match hTeam, Match aTeam) {
		this.homeTeam = databaseModel.teamDB.findByID(hTeam.getHomeTeamID());
		this.awayTeam = databaseModel.teamDB.findByID(aTeam.getHomeTeamID());
		this.homeTeamScore = hTeam.getHomeTeamScore();
		this.awayTeamScore = aTeam.getAwayTeamScore();
		this.winner = (homeTeamScore > awayTeamScore) ?
				homeTeam.map(Team::getTeamName).orElse("Unknown") :
				awayTeam.map(Team::getTeamName).orElse("Unknown");
		this.matchDate = (hTeam.getMatchDate().equals(aTeam.getMatchDate()))?
				hTeam.getMatchDate(): LocalDate.of(0000, 00,00) ;
		this.league = databaseModel.leagueDB.findByID(hTeam.getLeagueID());
	}
	public void displayMatchInfo() {
		System.out.println("Home Team           : " + this.homeTeam);
		System.out.println("Away Team           : " + this.awayTeam);
		System.out.println("Home Team Score     : " + this.homeTeamScore);
		System.out.println("Away Team Score     : " + this.awayTeamScore);
		System.out.println("Result              : " + this.winner);
		System.out.println("Match Date   : " + this.matchDate);
		System.out.println("--------------------------------------------------");
	}
}