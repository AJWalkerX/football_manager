package entities;

import databases.ManagerDB;

public class Manager extends Person{
	static  int idCounter = 0;
	private Integer teamID;
	private Integer experience;
	
	{
		this.teamID = -1;
	}
	
	public Manager(ManagerDB managerDB) {
		super.id = ++idCounter;
		managerDB.save(this);
	}
	
	public Manager(ManagerDB managerDB,Integer teamID, String name, String age, Integer experience) {
		super.id = ++idCounter;
		this.teamID = teamID;
		super.name = name;
		super.age = age;
		this.experience = experience;
		managerDB.save(this);
	}
	
	public Integer getTeamID() {
		return teamID;
	}
	
	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}
	
	public Integer getExperience() {
		return experience;
		
	}
	
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	
	
	@Override
	public String toString() {
		return "Manager{" + "id=" + getId() +
				", name='" + getName() + '\'' +
				", age='" + getAge() + '\'' +
				", teamID=" + getTeamID() +
				", experience=" + getExperience() + '}';
	}
}