import databases.*;
import entities.Team;
import modules.ManagerModule;
import modules.TeamModule;
import utility.DataGenerator;
import utility.FileIOReader;
import utility.FileIOWriter;

import java.util.InputMismatchException;
import java.util.Scanner;

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
	private static MatchDB matchDB = new MatchDB();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		FileIOReader.readAllEntities(playerDB,teamDB,leagueDB,managerDB,matchDB);
		startApplication();
	}
	
	public static void startApplication() {
		int opt;
		do {
			opt = mainMenu();
			switch (opt) {
				case 1:
					opt = ManagerModule.managerModule(playerDB, teamDB, managerDB);
					break;
				case 2:
					opt = TeamModule.teamModule(teamDB, playerDB);
					break;
				case 0:
					System.out.println("Exiting application...");
					FileIOWriter.saveAllEntities(playerDB,teamDB,leagueDB,managerDB,matchDB);
					break;
				default:
					System.out.println("Invalid option. Please try again.");
					break;
			}
		} while (opt != 0);
	}
	
	private static int mainMenu() {
		while (true) {
			System.out.println("### MAIN MENU ###");
			System.out.println("1- Manager Module");
			System.out.println("2- Team Module ");
			System.out.println("0- Exit");
			System.out.print("Selection: ");
			int opt;
			try {
				opt = sc.nextInt();
				return opt;
			} catch (InputMismatchException e) {
				System.out.println("Please enter a numeric value!");
			} finally {
				sc.nextLine();
			}
		}
	}
}