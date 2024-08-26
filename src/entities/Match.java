package entities;

import databases.MatchDB;
import utility.FileIOWriter;

import java.time.LocalDate;

public class Match extends BaseEntity {
	
	private Integer homeTeamID;
	private Integer awayTeamID;
	private Integer homeTeamScore;
	private Integer awayTeamScore;
	private String winner;
	private LocalDate MatchDate;
	private Integer leagueID;
	private boolean isPlayed;
	
	public Match(MatchDB matchDB) {
		super.id = matchDB.findAll().size()+1;
		isPlayed=false;
		matchDB.save(this);
		FileIOWriter.writeMatchToBin(matchDB);
	}
	
	public Match(MatchDB matchDB,Integer homeTeamID, Integer awayTeamID, Integer homeTeamScore, Integer awayTeamScore, String winner
			, LocalDate matchDate, Integer leagueID) {
		
		super.id = matchDB.findAll().size()+1;
		
		this.homeTeamID = homeTeamID;
		this.awayTeamID = awayTeamID;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.winner = winner;
		MatchDate = matchDate;
		this.leagueID = leagueID;
		isPlayed=false;
		matchDB.save(this);
		FileIOWriter.writeMatchToBin(matchDB);
	}
	public boolean isPlayed() {
		return isPlayed;
	}
	
	public void setPlayed(boolean played) {
		isPlayed = played;
	}
	public Integer getHomeTeamID() {
		return homeTeamID;
	}
	
	public void setHomeTeamID(Integer homeTeamID) {
		this.homeTeamID = homeTeamID;
	}
	
	public Integer getAwayTeamID() {
		return awayTeamID;
	}
	
	public void setAwayTeamID(Integer awayTeamID) {
		this.awayTeamID = awayTeamID;
	}
	
	public Integer getHomeTeamScore() {
		return homeTeamScore;
	}
	
	public void setHomeTeamScore(Integer homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	
	public Integer getAwayTeamScore() {
		return awayTeamScore;
	}
	
	public void setAwayTeamScore(Integer awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	
	public String getWinner() {
		return winner;
	}
	
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	public LocalDate getMatchDate() {
		return MatchDate;
	}
	
	public void setMatchDate(LocalDate matchDate) {
		MatchDate = matchDate;
	}
	
	public Integer getLeagueID() {
		return leagueID;
	}
	
	public void setLeagueID(Integer leagueID) {
		this.leagueID = leagueID;
	}
	
	
	
	@Override
	public String toString() {
		return "Match{" + "id=" + getId() +
				", homeTeamID=" + getHomeTeamID() +
				", homeTeamScore=" + getHomeTeamScore() +
				", awayTeamID=" + getAwayTeamID() +
				", awayTeamScore=" + getAwayTeamScore() +
				", winner='" + getWinner() + '\'' +
				", MatchDate=" + getMatchDate() +
				", leagueID=" + getLeagueID() + '}';
	}
}