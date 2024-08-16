import databases.*;
import entities.Team;
import modules.ManagerModule;
import modules.TeamModule;
import utility.DataGenerator;
import utility.FileIOReader;

public class Main {
	private  static ManagerDB managerDB = new ManagerDB();
	private static PlayerDB playerDB = new PlayerDB();
	private static TeamDB teamDB = new TeamDB();
	private static LeagueDB leagueDB = new LeagueDB();
	public static void main(String[] args) {
		FileIOReader.readAllEntities(playerDB,teamDB,leagueDB,managerDB);
		startApplication();
	}
	
	private static void startApplication() {
		int opt = 0;
		do {
			opt = ManagerModule.managerModule(playerDB,teamDB,managerDB);
//			opt = TeamModule.teamModule(teamDB, playerDB);
		}while (opt != 0);
	}
}