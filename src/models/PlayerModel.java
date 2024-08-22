package models;

import entities.Player;
import entities.Team;
import utility.enums.EPosition;

import java.util.Optional;

public class PlayerModel {
	private String name;
	protected String age;
	private EPosition position;
	private Integer skillLevel;
	private Long value;
	private Optional<Team> team;
	
	public PlayerModel(DatabaseModel databaseModel, Player player) {
		this.name = player.getName();
		this.age = player.getAge();
		this.team = databaseModel.teamDB.findByID(player.getTeamID());
		this.skillLevel = player.getSkillLevel();
		this.value = player.getValue();
		this.position = player.getPosition();
	}
	
	public void displayPlayerInfo() {
		System.out.println("Player Name    : " + this.name);
		System.out.println("Position       : " + this.position);
		System.out.println("Age            : " + this.age);
		System.out.println("Market Value   : " + this.value);
		System.out.println("Overall Rating : " + this.skillLevel);
		if (this.team.isPresent()) {
			System.out.println("Club           : " + this.team.get().getTeamName());
		} else {
			System.out.println("Club           : Free Agent");
		}
		System.out.println("--------------------------------------------------");
	}
}