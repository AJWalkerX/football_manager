package entities;

import databases.LeagueDB;

import java.util.ArrayList;
import java.util.List;

public class League extends BaseEntity{
	static  int leagueIDCounter = 0;
	private String leagueName;
	private List<Team> teamList;
	
	public League(LeagueDB leagueDB) {
		super.id = ++leagueIDCounter;
		teamList = new ArrayList<>();
		leagueDB.save(this);
	}
	public League(LeagueDB leagueDB, String leagueName) {
		super.id = ++leagueIDCounter;
		teamList = new ArrayList<>();
		this.leagueName = leagueName;
		leagueDB.save(this);
	}
	
	public List<Team> getTeamList() {
		return teamList;
	}
	
	public String getLeagueName() {
		return leagueName;
	}
	
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	
	
	@Override
	public String toString() {
		return "League{" + "id=" + getId() + ", leagueName='" + getLeagueName() + '\'' + ", teamList=" + getTeamList() + '}';
	}
}