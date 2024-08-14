import databases.PlayerDB;
import databases.TeamDB;
import utility.DataGenerator;

public class Main {
	private static PlayerDB playerDB = new PlayerDB();
	private static TeamDB teamDB = new TeamDB();
	
	public static void main(String[] args) {
		
		DataGenerator.generateRandomPlayers(playerDB);
		DataGenerator.generateTeams(teamDB);
		teamDB.findAll().forEach(System.out::println);
		
		teamDB.getTeamSquad(playerDB, 3);
	}
}