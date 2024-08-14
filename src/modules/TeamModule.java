package modules;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TeamModule {
	static Scanner sc = new Scanner(System.in);
	public  static int teamModule(){
		int opt = 0;
		opt = teamModuleMenuOptions(teamModuleMenu());
		return opt;
	}
	public static int teamModuleMenu(){
		while (true){
			System.out.println("### TEAM CLUB MENU ###");
			System.out.println("1-Search Team By Name");
			System.out.println("2- List All Teams");
			System.out.println("0- Return to main menu");
			System.out.print("selection: ");
			int opt ;
			try {
				opt = sc.nextInt();
				return opt;
			}catch (InputMismatchException e){
				System.out.println("Please enter a numaric value!");
			}
			finally {
				sc.nextLine();
			}
		}
		
	}
	public static int teamModuleMenuOptions(int opt){
		switch (opt){
			case 1:{ //Search Team By Name
				System.out.println("Search teams...");
				break;
			}
			case 2:{ //List All Teams
				System.out.println("Listing all teams... ");
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
	
}