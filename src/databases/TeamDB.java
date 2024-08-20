package databases;

import entities.Manager;
import entities.Team;
import utility.DatabaseManager;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

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
		playerDB.findAll().stream().filter(
				player->player.getTeamID() != null && player.getTeamID().equals(teamId)).forEach(System.out::println);
	}
	
	public List<Team> findTeamByName(TeamDB teamDB,String teamName) {
		List<Team> teamList = teamDB.findAll().stream()
		                            .filter(t -> t.getTeamName().toLowerCase().contains(teamName.toLowerCase()))
		                            .toList();
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
	public Optional<Team> getTeamByTeamID(TeamDB teamDB,int teamID) {
		return teamDB.veriListesi.stream().filter(team -> team.getId() == teamID).findFirst();
	}
	
	public void getRivalTeamSquad(Manager manager, int teamId, PlayerDB playerDB){
		Optional<Team> teamOpt = veriListesi.stream()
		                                    .filter(team -> !team.getId().equals(manager.getTeamID()))
		                                    .filter(team -> team.getId().equals(teamId)).findAny();
		if(teamOpt.isPresent()){
			Team team = teamOpt.get();
			System.out.println("-------- " +team.getTeamName().toUpperCase()+" --------");
			playerDB.findAll().stream().filter(player->player.getTeamID()!=null && player.getTeamID()==(teamId))
			        .map(player -> "id="+player.getId()+"  name='"+player.getName()+"'\t\tage="+player.getAge())
			        .forEach(System.out::println);
			return;
		}
		System.out.println("You either trying to get your own team squad or the team with that id does not exist.");
	}
	
	public List<Team> getRivalTeams(Manager manager){
		List<Team> rivalTeams = veriListesi.stream().filter(team->!team.getId().equals(manager.getTeamID()))
		                                   .toList();
		System.out.println("----- RIVAL TEAMS -----");
		rivalTeams.stream().map(team->team.getId()+"\t"+team.getTeamName()).forEach(System.out::println);
		return rivalTeams;
	}
}