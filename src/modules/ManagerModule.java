package modules;

import databases.ManagerDB;
import databases.PlayerDB;
import databases.TeamDB;
import entities.Manager;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class ManagerModule {
	private static Scanner sc = new Scanner(System.in);
	private static TeamDB teamDataBase;
	private static PlayerDB playerDataBase;
	private static ManagerDB managerDataBase;
	private static Optional<Manager> managerOptional = Optional.empty();
	
	public static int managerModule(PlayerDB playerDB, TeamDB teamDB, ManagerDB managerDB){
		playerDataBase = playerDB;
		teamDataBase = teamDB;
		managerDataBase = managerDB;
		int opt = 0;
		opt = managerModuleMenuLoginOptions(managerModuleLoginMenu());
		return opt;
	}
	
	private static int managerModuleLoginMenu() {
		while (true) {
			System.out.println("### MANAGER LOGIN MENU ###");
			System.out.println("1- Login");
			System.out.println("0- Return");
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
	private static int managerModuleMenuLoginOptions(int opt){
			switch (opt){
				case 1:{ //Manager Login
					loginManager();
					break;
				}
				case 0:{
					System.out.println("gülü gülü...");
					return opt;
					
				}
				default:
					System.out.println("Please enter a valid value!");
			}
			return opt;
	}
	
	private static void loginManager() {
		int attemptCount = 0;
		while (attemptCount != 3){
			System.out.print("username: ");
			String username = sc.nextLine();
			System.out.print("password: ");
			String password = sc.nextLine();
			Optional<Manager> manager = managerDataBase.findByUsernameAndPassword(username,password);
			if (manager.isPresent()){
				System.out.println("\u001B[32mSuccessfully logged in!\u001B[0m");
				managerOptional = manager;
				managerModuleMenuOptions(managerModuMenu());
				return;
			}
			else{
				attemptCount++;
				System.out.println("\u001B[33m");
				System.out.println("Maximum 3 attempts available.");
				System.out.println("Wrong Username or Password. Attempt "+ attemptCount);
				if (attemptCount == 3){
					System.out.println("Wrong password attempt has been made 3 times! Try again Later.");
				}
				System.out.println("\u001B[0m");
			}
		}
	}
	
	private static int managerModuMenu(){
		while (true) {
			System.out.println("### MANAGER MENU ###");
			System.out.println("1- Login");
			System.out.println("0- Logout");
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
	private static int managerModuleMenuOptions(int opt){
		switch (opt){
			case 1:{
				break;
			}
			case 0:{
				System.out.println("Returning to cart curt");
				managerOptional = Optional.empty();
				return opt;
				
			}
			default:
				System.out.println("Please enter a valid value!");
		}
		return opt;
	}
}