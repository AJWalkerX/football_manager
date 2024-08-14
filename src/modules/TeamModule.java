package modules;

import databases.LeagueDB;
import databases.ManagerDB;
import databases.PlayerDB;
import databases.TeamDB;
import entities.Manager;
import entities.Team;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TeamModule {
	private static Scanner sc = new Scanner(System.in);
	private static TeamDB teamDataBase;
	public  static int teamModule(TeamDB teamDB){
		teamDataBase = teamDB;
		int opt = 0;
		opt = teamModuleMenuOptions(teamModuleMenu());
		return opt;
	}
	public static int teamModuleMenu(){
		while (true){
			System.out.println("### TEAM CLUB MENU ###");
			System.out.println("1-Search Team By Name");
			System.out.println("2- List All Teams");
			System.out.println("0- Close the application");
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
				List<Team> teamList = searchTeamByName();
				if (!teamList.isEmpty()){
					teamDetailMenuOptions(teamDetailMenu(), teamList);
				}
				break;
			}
			case 2:{ //List All Teams
				System.out.println("--- Lists of All Teams ---");
				teamDataBase.findAll().forEach(System.out::println);
				System.out.println("-------------------------------");
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
	
	private static List<Team> searchTeamByName() {
		System.out.print("Enter a team name: ");
		String teamName = sc.nextLine();
		List<Team> teamList = teamDataBase.findAll().stream().filter(t -> t.getTeamName().contains(teamName)).toList();
		System.out.println("------- Search of "+ teamName + " -------");
		if (teamList.isEmpty()){
			System.out.println("There are no team");
		}
		else {
			teamList.forEach(System.out::println);
		}
		System.out.println("-----------------------------------");
		return teamList;
	}
	
	public static int teamDetailMenu(){
		while (true){
			System.out.println("### Check Team Details ###");
			System.out.println("1-Show Team Details");
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
	public static int teamDetailMenuOptions(int opt, List<Team> teamList){
		switch (opt){
			case 1:{ //Show team Details
				System.out.println("Showing details");
				break;
			}
			case 0:{
				System.out.println("Returning to main menu...");
				return opt;
			}
			default:
				System.out.println("Please enter a valid value!");
		}
		return opt;
	}
	
}