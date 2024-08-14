package databases;

import entities.Team;
import utility.DatabaseManager;

import java.util.Optional;

public class TeamDB extends DatabaseManager<Team> {
	public void getTeamSquad(PlayerDB playerDB,int teamId){
		Team team;
		Optional<Team> teamOpt = findByID(teamId);
		if(!teamOpt.isEmpty()){
			team = teamOpt.get();
		}
		else{
			System.out.println("No team found by that ID");
			return;
		}
		System.out.println("-------------------- "+team.getTeamName().toUpperCase()+" SQUAD --------------------");
		playerDB.findAll().stream().filter(player->player.getTeamID().equals(teamId)).forEach(System.out::println);
	}
}