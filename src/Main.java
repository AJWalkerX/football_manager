import databases.*;
import entities.Team;
import modules.ManagerModule;
import modules.TeamModule;
import utility.DataGenerator;
import utility.FileIOReader;
/*
ManagerModule yazalım. Menajer id şifre ile giriş yapsın, kulüp görüntülemesi yaparken kendi kulübünü detaylı görüntülesin,
diğer kulüpleri özet bilgiyle görüntüleyebilsin. Ayrıca başka kulüp futbolcularını özet bilgileriyle görüntüleyebilirken,
kendi kulübünün futbolcularını detaylı görüntüleyebilsin.
* */
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