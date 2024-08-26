
import models.DatabaseModel;
import models.LeagueModel;
import modules.LeagueModule;
import modules.ManagerModule;

import modules.MatchModule;
import modules.TeamModule;
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
	static DatabaseModel databaseModel = DatabaseModel.getInstance();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		FileIOReader.readAllEntities(databaseModel);
		MatchModule.playMatchesBeforeDate(databaseModel);
		int opt = 0;
		do {
			opt = startApplication(mainMenu());
		}while (opt != 0);
	
	}
	
	public static int startApplication(int opt) {
		switch (opt) {
				case 1:
					ManagerModule.managerModule(databaseModel);
					break;
				case 2:
					TeamModule.teamModule(databaseModel);
					break;
				case 3:
					LeagueModule.leagueModule(databaseModel);
					break;
				case 4:
					MatchModule.matchModule(databaseModel);
					break;
				case 0:
					System.out.println("Exiting application...");
					FileIOWriter.saveAllEntities(databaseModel);
					return opt;
				default:
					System.out.println("Invalid option. Please try again.");
					break;
			}
		return opt;
	}
	
	private static int mainMenu() {
		int opt;
		while (true) {
			System.out.println("### MAIN MENU ###");
			System.out.println("1- Manager Module");
			System.out.println("2- Team Module ");
			System.out.println("3- League Module ");
			System.out.println("4- Match Module ");
			System.out.println("0- Exit");
			System.out.print("Selection: ");
			
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