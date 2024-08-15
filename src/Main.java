import databases.*;
import modules.TeamModule;

public class Main {
	private  static ManagerDB managerDB = new ManagerDB();
	private static PlayerDB playerDB = new PlayerDB();
	private static TeamDB teamDB = new TeamDB();
	private static LeagueDB leagueDB = new LeagueDB();
	public static void main(String[] args) {
//		DataGenerator.generateRandomPlayers(playerDB);
//		DataGenerator.generateTeamsAndLeagues(teamDB, leagueDB);
//		DataGenerator.generateManagers(managerDB);
		startApplication();
	
	}
	
	private static void startApplication() {
		int opt = 0;
		do {
			opt = TeamModule.teamModule(teamDB, playerDB);
		}while (opt != 0);
	}
}