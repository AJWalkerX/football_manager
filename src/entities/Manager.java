package entities;

import databases.ManagerDB;
import utility.FileIOWriter;

public class Manager extends Person{
	private String username;
	private String password;
	private Integer teamID;
	private Integer experience;
	
	{
		this.teamID = -1;
	}
	
	public Manager(ManagerDB managerDB) {
		super.id = managerDB.findAll().size()+1;
		managerDB.save(this);
		FileIOWriter.writeManagerToBin(managerDB);
	}
	
	public Manager(ManagerDB managerDB, String name, String age,String username,String password, Integer teamID, Integer experience) {
		super.id = managerDB.findAll().size()+1;
		super.name = name;
		super.age = age;
		this.username = username;
		this.password = password;
		this.teamID = teamID;
		this.experience = experience;
		managerDB.save(this);
		FileIOWriter.writeManagerToBin(managerDB);
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
		return "Manager{" +
				"id=" + getId() +
				", name='" + getName() + '\'' +
				", age='" + getAge() + '\'' +
				", username='" + getUsername() + '\'' +
				", password='" + getPassword() + '\'' +
				", teamID=" + getTeamID() +
				", experience=" + getExperience() +
				'}';
	}
	
}