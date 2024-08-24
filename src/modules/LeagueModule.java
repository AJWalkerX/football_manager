package modules;

import databases.LeagueDB;
import databases.MatchDB;
import entities.League;
import entities.Match;
import models.DatabaseModel;
import models.LeagueModel;
import models.TeamModel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class LeagueModule {
	private static Scanner sc = new Scanner(System.in);
	private static DatabaseModel databaseModel;
	
	public static int leagueModule(DatabaseModel dbModel) {
		databaseModel = dbModel;
		int opt = 0;
		opt = leagueModuleMenuOptions(leagueModuleMenu());
		return opt;
	}
	public static int leagueModuleMenu(){
		while (true){
			System.out.println("### League Module MENU ###");
			System.out.println("1- Look for Fixture");
			System.out.println("2- List All Leagues");
			System.out.println("3- Show Played Matches");
			System.out.println("4- Show Score Board(Will be implemented later)");
			System.out.println("0- Return Main Menu...");
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
	public static int leagueModuleMenuOptions(int opt){
		switch (opt){
			case 1:{ //Look for Fixture
				Optional<League> league = findLeague();
				if (league.isPresent()) {
					LeagueModel leagueModel = new LeagueModel(databaseModel, league.get());
					leagueModel.displayLeagueInfoAndFixture();
				}
				else {
					System.out.println("No League found!");
				}
				leagueModuleMenuOptions(leagueModuleMenu());
				break;
			}
			case 2:{ //List All Leagues
				listLeagues();
				leagueModuleMenuOptions(leagueModuleMenu());
				break;
			}
			case 3:{ //Show Played Matches,
				Optional<League> league = findLeague();
				if (league.isPresent()) {
					LeagueModel leagueModel = new LeagueModel(databaseModel, league.get());
					leagueModel.displayLeagueInfo();
					leagueModel.displayPlayedMatches();
				}
				else {
					System.out.println("No League found!");
				}
				
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
	
	private static Optional<League> findLeague() {
		listLeagues();
		System.out.println("--------------------------------------------------");
		System.out.print("Enter League ID: ");
		int leagueID = sc.nextInt();
		return databaseModel.leagueDB.findByID(leagueID);
	}
	
	private static void listLeagues() {
		LeagueModel leagueModel;
		List<League> leagues = databaseModel.leagueDB.getLeagues();
		System.out.println("List of Leagues: ");
		for (League league : databaseModel.leagueDB.getLeagues()) {
			leagueModel = new LeagueModel(databaseModel, league);
			leagueModel.displayLeagueInfo();
		}
	}
	
}