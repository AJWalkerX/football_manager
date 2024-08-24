package modules;

import models.DatabaseModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatchModule {
	private static Scanner sc = new Scanner(System.in);
	private static DatabaseModel databaseModel;
	
	public static int matchModule(DatabaseModel dbModel) {
		databaseModel = dbModel;
		int opt = 0;
		opt = matchModuleMenuOptions(matchModuleMenu());
		return opt;
	}
	
	public static int matchModuleMenu() {
		while (true) {
			System.out.println("### Match Module MENU ###");
			System.out.println("1- Show Played Matches");
			System.out.println("0- Return Main Menu...");
			System.out.print("selection: ");
			int opt;
			try {
				opt = sc.nextInt();
				return opt;
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter a numaric value!");
			}
			finally {
				sc.nextLine();
			}
		}
		
	}
	
	public static int matchModuleMenuOptions(int opt) {
		switch (opt) {
			case 1: { //Show Played Matches
				matchModuleMenuOptions(matchModuleMenu());
				break;
			}
			
			case 0: {
				System.out.println("Returning to Main menu...");
				return opt;
			}
			default:
				System.out.println("Please enter a valid value!");
		}
		return opt;
	}
}