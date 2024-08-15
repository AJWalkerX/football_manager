import databases.*;
import entities.Team;
import modules.TeamModule;
import utility.DataGenerator;
import utility.FileIOReader;

public class Main {
	private  static ManagerDB managerDB = new ManagerDB();
	private static PlayerDB playerDB = new PlayerDB();
	private static TeamDB teamDB = new TeamDB();
	private static LeagueDB leagueDB = new LeagueDB();
	public static void main(String[] args) {
//		DataGenerator.generateRandomPlayers(playerDB);
//		DataGenerator.generateNationalLeagueTeams(teamDB, leagueDB);
//		DataGenerator.generateManagers(managerDB);
		
		FileIOReader.readAllEntities(playerDB,teamDB,leagueDB,managerDB);
		startApplication();
	}
	
	private static void startApplication() {
		int opt = 0;
		do {
			opt = TeamModule.teamModule(teamDB, playerDB);
		}while (opt != 0);
	}
}