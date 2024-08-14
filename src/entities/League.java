package entities;

import databases.LeagueDB;

import java.util.List;

public class League extends BaseEntity{
	private String leagueName;
	
	public League(LeagueDB leagueDB) {
		super.id = 0;
		leagueDB.save(this);
	}
	
	public String getLeagueName() {
		return leagueName;
	}
	
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	
	
	@Override
	public String toString() {
		return "League{" + "id=" + getId() + ", leagueName='" + getLeagueName() + '\'' + '}';
	}
}