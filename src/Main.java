import databases.LeagueDB;
import databases.PlayerDB;
import databases.TeamDB;
import entities.League;
import utility.DataGenerator;

public class Main {
	private static PlayerDB playerDB = new PlayerDB();
	private static TeamDB teamDB = new TeamDB();
	private static LeagueDB leagueDB = new LeagueDB();
	public static void main(String[] args) {
		
		DataGenerator.generateRandomPlayers(playerDB);
		DataGenerator.generateTeamsAndLeagues(teamDB, leagueDB);
		teamDB.findAll().forEach(System.out::println);
		
		teamDB.getTeamSquad(playerDB, 3);
		leagueDB.getLeagueTeams(1);
	}
}