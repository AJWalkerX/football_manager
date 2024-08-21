package entities;

import databases.MatchDB;

public class Match extends BaseEntity {
	
	//TODO: MatchTarihi, leagueID fieldlarını ekle!
	private Integer homeTeamID;
	private Integer awayTeamID;
	private Integer homeTeamScore;
	private Integer awayTeamScore;
	private String winner;
	
	public Match(MatchDB matchDB) {
		super.id = matchDB.findAll().size()+1;
		matchDB.save(this);
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
	
	
	@Override
	public String toString() {
		return "Match{" + "id=" + getId() +
				", homeTeamID=" + getHomeTeamID() +
				", homeTeamScore=" + getHomeTeamScore() +
				", awayTeamID=" + getAwayTeamID() +
				", awayTeamScore=" + getAwayTeamScore() +
				", winner='" + getWinner() + '\'' + '}';
	}
}