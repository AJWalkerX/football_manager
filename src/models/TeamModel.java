package models;

import entities.Player;
import entities.Team;

import java.util.List;

public class TeamModel {
	private int id;
	private DatabaseModel databaseModel;
	private String teamName;
	private Long budget;
	private List<Player> playerList;
	private Integer teamPower;
	
	public TeamModel(DatabaseModel databaseModel, Team team) {
		this.databaseModel = databaseModel;
		this.id = team.getId();
		this.teamName = team.getTeamName();
		this.budget = team.getBudget();
		this.playerList = databaseModel.playerDB.findAll().stream()
		                                        .filter(player -> player.getTeamID() != null && player.getTeamID()
		                                                                                              .equals(id))
		                                        .toList();
		this.teamPower = generateTeamPower(team);
	}
	
	public void displayClubInfo() {
		System.out.println("--------------------------------------------------");
		System.out.println("Club Information:");
		System.out.println("--------------------------------------------------");
		System.out.println("Club ID      : " + id);
		System.out.println("Club Name    : " + teamName);
		System.out.println("Budget       : " + budget);
		System.out.println("Team Power   : " + teamPower);
		System.out.println("--------------------------------------------------");
		System.out.println("Player List:");
		System.out.println("--------------------------------------------------");
		
		if (playerList != null && !playerList.isEmpty()) {
			playerList.forEach(player -> new PlayerModel(databaseModel,player).displayPlayerInfo());
		} else {
			System.out.println("No players found for this club.");
		}
		System.out.println("==================================================");
	}
	
	public Integer generateTeamPower(Team team) {
		team.setTeamPower((int) Math.round(playerList.stream().mapToInt(Player::getSkillLevel).average().orElse(0.0)));
		databaseModel.teamDB.update(team);
		return team.getTeamPower();
	}
}