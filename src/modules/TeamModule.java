package modules;

import databases.TeamDB;
import entities.Team;
import models.DatabaseModel;
import models.TeamModel;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TeamModule {
	private static Scanner sc = new Scanner(System.in);
	private static DatabaseModel databaseModel;
	
	public static int teamModule(DatabaseModel dbModel) {
		databaseModel = dbModel;
		int opt = 0;
		opt = teamModuleMenuOptions(teamModuleMenu());
		return opt;
	}

	public static int teamModuleMenu(){
		while (true){
			System.out.println("### TEAM CLUB MENU ###");
			System.out.println("1- Search Team By Name");
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
				Optional<Team> teamOptional = searchByTeamName();
				if (teamOptional.isPresent()){
					Team team = teamOptional.get();
					String teamName = team.getTeamName();
					teamDetailMenuOptions(teamDetailMenu(teamName), team);
				}
				break;
			}
			case 2:{ //List All Teams
				TeamDB teamDB = databaseModel.teamDB;
				System.out.println("--- Lists of All Teams ---");
				if (!teamDB.findAll().isEmpty()){
					teamDB.findAll().stream().map(team -> team.getId() + "- " + team.getTeamName())
					            .forEach(System.out::println);
				}
				else {
					System.out.println("List is empty!");
					System.out.println("-------------------------------");
					break;
				}
				System.out.println("-------------------------------");
				int userSelection = askUserToContinue();
				if (userSelection == 1){
					Optional<Team> teamOptional = searchByTeamID();
					if (teamOptional.isPresent()){
						Team team = teamOptional.get();
						TeamModel teamModel = new TeamModel(databaseModel, team);
						teamModel.displayClubInfo();
					}
					else{
						System.out.println("No such team found by this ID!");
					}
				}
				else{
					System.out.println("Returning to main menu...");
				}
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
	
	private static Optional<Team> searchByTeamID() {
		TeamDB teamDB = databaseModel.teamDB;
		int teamID = askUserTeamID();
		Optional<Team>teamOptional = teamDB.getTeamByTeamID(teamDB, teamID);
		return teamOptional;
	}
	
	private static Optional<Team> searchByTeamName() {
		TeamDB teamDB = databaseModel.teamDB;
		System.out.print("Enter a team name: ");
		String teamName = sc.nextLine();
		Optional<Team> teamOptional = Optional.empty();
		List<Team> teamList = teamDB.findTeamByName(teamDB, teamName);
		if (!teamList.isEmpty()) {
			int userSelection = askUserToContinue();
			if (userSelection == 1) {
				int teamID = askUserTeamID();
				teamOptional = teamDB.getTeamByTeamID(teamList, teamID);
			}
			else {
				System.out.println("Returning to main menu...");
			}
		}
		return teamOptional;
	}
	
	private static int askUserTeamID() {
		System.out.print("Enter ID: ");
		int teamID = sc.nextInt();
		sc.nextLine();
		return teamID;
	}
	
	
	private static int askUserToContinue() {
		while (true) {
			System.out.println("1- Select Team By ID");
			System.out.println("0- Return to main menu");
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
	
	
	// Team Detail Menu
	public static int teamDetailMenu(String teamName) {
		while (true){
			System.out.println("### " + teamName + " ###");
			System.out.println("1- Show Team Details");
			System.out.println("2- Show Team Players");
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
	
	public static int teamDetailMenuOptions(int opt, Team team) {
		switch (opt){
			case 1:{ //Show team Details
				System.out.println(team);
				System.out.println("----------------------------------");
				teamDetailMenuOptions(teamDetailMenu(team.getTeamName()), team);
				break;
			}
			case 2: { //Show Team Players
				databaseModel.teamDB.getTeamSquad(databaseModel.playerDB, team.getId());
				teamDetailMenuOptions(teamDetailMenu(team.getTeamName()), team);
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