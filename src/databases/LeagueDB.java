package databases;

import entities.League;
import entities.Team;
import utility.DatabaseManager;

import java.util.Optional;

public class LeagueDB extends DatabaseManager<League> {
	public void getLeagueTeams(int leagueID){
		League league;
		Optional<League> teamOpt = findByID(leagueID);
		if(!teamOpt.isEmpty()){
			league = teamOpt.get();
			System.out.println("-------------------- "+league.getLeagueName().toUpperCase()+" --------------------");
			league.getTeamList().forEach(System.out::println);
		}
		else{
			System.out.println("No such League has been found");
		}
		
	}
}