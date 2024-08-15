package entities;

import databases.LeagueDB;
import utility.EDivision;
import utility.ERegion;
import utility.FileIOWriter;

import java.util.ArrayList;
import java.util.List;

public class League extends BaseEntity{
	private String leagueName;
	private List<Integer> teamIDList;
	private ERegion region;
	private EDivision division;
	private String season;
	
	public League(LeagueDB leagueDB) {
		super.id = leagueDB.findAll().size()+1;
		teamIDList = new ArrayList<>();
		leagueDB.save(this);
		FileIOWriter.writeLeagueToBin(leagueDB);
	}
	
	public League(LeagueDB leagueDB,String leagueName, ERegion region, EDivision division, String season) {
		super.id = leagueDB.findAll().size()+1;
		this.leagueName = leagueName;
		teamIDList = new ArrayList<>();
		this.region = region;
		this.division = division;
		this.season = season;
		leagueDB.save(this);
		FileIOWriter.writeLeagueToBin(leagueDB);
	}
	
	public ERegion getRegion() {
		return region;
	}
	
	public void setRegion(ERegion region) {
		this.region = region;
	}
	
	public EDivision getDivision() {
		return division;
	}
	
	public void setDivision(EDivision division) {
		this.division = division;
	}
	
	public String getSeason() {
		return season;
	}
	
	public void setSeason(String season) {
		this.season = season;
	}
	
	public List<Integer> getTeamIDList() {
		return teamIDList;
	}
	
	public void setTeamIDList(List<Integer> teamIDList) {
		this.teamIDList = teamIDList;
	}
	
	public List<Integer> getTeamList() {
		return teamIDList;
	}
	
	public String getLeagueName() {
		return leagueName;
	}
	
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	
	
	@Override
	public String toString() {
		return "League{" + "id=" + getId() +
				", leagueName='" + getLeagueName() + '\'' +
				", teamIDList=" + teamIDList +
				", region=" + getRegion() +
				", division=" + getDivision() +
				", season='" + getSeason() + '\'' + '}';
	}
}