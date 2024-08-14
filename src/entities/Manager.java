package entities;

import databases.ManagerDB;

public class Manager extends Person{
	static  int idCounter = 0;
	private Integer experience;
	
	public Manager(ManagerDB managerDB) {
		super.id = ++idCounter;
		managerDB.save(this);
	}
	
	public Integer getExperience() {
		return experience;
		
	}
	
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	
	@Override
	public String toString() {
		return "Manager{" + "id=" + getId() + ", name='" + getName() + '\'' + ", age='" + getAge() + '\'' + ", experience=" + getExperience() + '}';
	}
}