package entities;

import databases.TeamDB;

import java.util.List;

public class Team extends BaseEntity{
	static  int idCounter = 0;
	
	private String teamName;
	private Manager manager;
	private Long budget; //takımın elindeki para
	private Integer leagueID;
	
	public Team(TeamDB teamDB) {
		super.id = ++idCounter;
		teamDB.save(this);
	}
	public Team(TeamDB teamDB,String teamName, Manager manager, Long budget, Integer leagueId) {
		id = ++idCounter;
		this.teamName = teamName;
		this.manager = manager;
		this.budget = budget;
		this.leagueID = leagueId;
		teamDB.save(this);
		
	}
	
	public Integer getLeagueID() {
		return leagueID;
	}
	
	public void setLeagueID(Integer leagueID) {
		this.leagueID = leagueID;
	}
	
	public static int getIdCounter() {
		return idCounter;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public Manager getManager() {
		return manager;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public Long getBudget() {
		return budget;
	}
	
	public void setBudget(Long budget) {
		this.budget = budget;
	}
	
	
	@Override
	public String toString() {
		return "Team{" + "id=" + getId() + ", teamName='" + getTeamName() + '\'' + ", leagueID=" + getLeagueID() + ", manager=" + getManager() + ", budget=" + getBudget() + '}';
	}
}