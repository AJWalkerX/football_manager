package entities;

import databases.PlayerDB;
import utility.enums.EPosition;
import utility.FileIOWriter;

public class Player extends Person{
	
	private Integer teamID;
	private EPosition position;
	private Integer skillLevel;
	private Long value; // piyasa değeri
	
	public Player(PlayerDB playerDB) {
		super.id = playerDB.findAll().size()+1;
		playerDB.save(this);
		FileIOWriter.writePlayerToBin(playerDB);
	}
	
	
	public Integer getTeamID() {
		return teamID;
	}
	
	public void setTeamID(Integer teamID) {
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
	
	public Long getValue() {
		return value;
	}
	
	public void setValue(Long value) {
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