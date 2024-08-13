package entities;

import utility.EPosition;

public class Player extends Person{
	static  int idCounter = 0;
	
	private int teamID;
	private EPosition position;
	private Integer skillLevel;
	private Double value; // piyasa değeri
	
//	{
//		this.teamID = -1;
//	}
	
	public Player() {
		super.id = ++idCounter;
	}
	
	
	public int getTeamID() {
		return teamID;
	}
	
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	
	public EPosition getPosition() {
		return position;
	}
	
	public void setPosition(EPosition position) {
		this.position = position;
	}
	
	public Integer getSkillLevel() {
		return skillLevel;
	}
	
	public void setSkillLevel(Integer skillLevel) {
		this.skillLevel = skillLevel;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	
	@Override
	public String toString() {
		return "Player{" + "id=" + getId() +
				", name='" + getName() + '\'' +
				", age='" + getAge() + '\'' +
				", teamID=" + getTeamID() +
				", position=" + getPosition() +
				", skillLevel=" + getSkillLevel() +
				", value=" + getValue() + '}';
	}
}