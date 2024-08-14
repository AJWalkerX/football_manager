import databases.LeagueDB;
import databases.PlayerDB;
import databases.TeamDB;
import entities.League;
import modules.ManagerModule;
import modules.TeamModule;
import utility.DataGenerator;

public class Main {
	private static PlayerDB playerDB = new PlayerDB();
	private static TeamDB teamDB = new TeamDB();
	private static LeagueDB leagueDB = new LeagueDB();
	public static void main(String[] args) {
		DataGenerator.generateRandomPlayers(playerDB);
		DataGenerator.generateTeamsAndLeagues(teamDB, leagueDB);
		startApplication();
	}
	
	private static void startApplication() {
		int opt = 0;
		do {
			opt = TeamModule.teamModule(teamDB, playerDB);
		}while (opt != 0);
	}
}