package entities;

import java.util.List;

public class Team extends BaseEntity{
	static  int idCounter = 0;
	
	private String teamName;
	private Manager manager;
	private Double budget; //takımın elindeki para
	private Integer leagueID;
	
	public Team() {
		super.id = ++idCounter;
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
	
	public Double getBudget() {
		return budget;
	}
	
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	
	
	@Override
	public String toString() {
		return "Team{" + "id=" + getId() + ", teamName='" + getTeamName() + '\'' + ", leagueID=" + getLeagueID() + ", manager=" + getManager() + ", budget=" + getBudget() + '}';
	}
}