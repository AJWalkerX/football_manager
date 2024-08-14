package databases;

import entities.Team;
import utility.DatabaseManager;

import java.util.List;
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
	
	public List<Team> findTeamByName(TeamDB teamDB,String teamName) {
		List<Team> teamList = teamDB.findAll().stream().filter(t -> t.getTeamName().contains(teamName)).toList();
		System.out.println("------- Search of "+ teamName + " -------");
		if (teamList.isEmpty()){
			System.out.println("There are no team");
		}
		else {
			teamList.stream().map(team -> team.getId() + "- " + team.getTeamName()).forEach(System.out::println);
		}
		System.out.println("-----------------------------------");
		return teamList;
	}
	public Optional<Team> getTeamByTeamID(List<Team> teamList, int teamID) {
		return teamList.stream().filter(team -> team.getId() == teamID).findFirst();
	}
}