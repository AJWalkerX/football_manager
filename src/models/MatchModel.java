package models;

import entities.League;
import entities.Match;
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
	private Optional<League> league;
//	TODO:Score muhabeti gelecek
	
	public MatchModel(DatabaseModel databaseModel, Match match) {
		this.databaseModel = databaseModel;
		this.league = databaseModel.leagueDB.findByID(match.getLeagueID());
		this.homeTeam = databaseModel.teamDB.findByID(match.getHomeTeamID());
		this.awayTeam = databaseModel.teamDB.findByID(match.getAwayTeamID());
		this.matchDate = match.getMatchDate();
		this.playMatch(match);
		this.homeTeamScore = match.getHomeTeamScore();
		this.awayTeamScore = match.getAwayTeamScore();
		if (homeTeamScore != null || awayTeamScore != null) {
			if (homeTeamScore == awayTeamScore) {
				this.winner = "Draw";
			}else{
				this.winner = (homeTeamScore > awayTeamScore) ?
						homeTeam.map(Team::getTeamName).orElse("Unknown") :
						awayTeam.map(Team::getTeamName).orElse("Unknown");
			}
		}
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
	
	public void playMatch(Match match) {
		if (match.getMatchDate().isBefore(LocalDate.now()) || match.getMatchDate().isEqual(LocalDate.now())) {
			Team homeTeam = this.homeTeam.get();
			Team awayTeam = this.awayTeam.get();
			TeamModel homeTeamModel = new TeamModel(databaseModel, homeTeam);
			TeamModel awayTeamModel = new TeamModel(databaseModel, awayTeam);
			homeTeamScore = (new Random().nextInt(4)* homeTeam.getTeamPower());
			awayTeamScore =(new Random().nextInt(4)* homeTeam.getTeamPower());
			match.setWinner(winner);
//			databaseModel.matchDB.update(match);
			
		}
	}
	
}