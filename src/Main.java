import databases.*;
import entities.League;
import models.DatabaseModel;
import modules.ManagerModule;
import modules.MatchModule;
import modules.TeamModule;
import utility.data.DataGenerator;
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
	static DatabaseModel databaseModel = new DatabaseModel();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		FileIOReader.readAllEntities(databaseModel);
		startApplication();
	}
	
	public static void startApplication() {
		int opt;
		do {
			opt = mainMenu();
			switch (opt) {
				case 1:
					opt = ManagerModule.managerModule(databaseModel);
					break;
				case 2:
					opt = TeamModule.teamModule(databaseModel);
					break;
				case 0:
					System.out.println("Exiting application...");
					FileIOWriter.saveAllEntities(databaseModel);
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