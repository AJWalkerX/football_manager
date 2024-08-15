package entities;

import databases.TeamDB;
import utility.FileIOReader;
import utility.FileIOWriter;


public class Team extends BaseEntity{
	static  int idCounter = 0;
	
	private String teamName;
	private Long budget; //takımın elindeki para
	
	public Team(TeamDB teamDB) {
		super.id = ++idCounter;
		teamDB.save(this);
	}
	public Team(TeamDB teamDB,String teamName, Long budget) {
		id = ++idCounter;
		this.teamName = teamName;
		this.budget = budget;
		teamDB.save(this);
		FileIOWriter.writeTeamToBin(teamDB);
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
	
	
	
	public Long getBudget() {
		return budget;
	}
	
	public void setBudget(Long budget) {
		this.budget = budget;
	}
	
	
	@Override
	public String toString() {
		return "Team{" + "id=" + getId() + ", teamName='" + getTeamName() + '\'' +
				", budget=" + getBudget() + '}';
	}
}