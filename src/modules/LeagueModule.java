package modules;

import databases.LeagueDB;
import databases.MatchDB;
import entities.League;
import entities.Match;
import models.DatabaseModel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class LeagueModule {
	private static Scanner sc = new Scanner(System.in);
	private static DatabaseModel databaseModel;
	
	//TODO: Tarih isBefore ise maç yaptıracağın bir metod yaz.
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
				//TODO: Eğer fixture yoksa fixture yok desin.
				//TODO: Eğer fixture varsa onu listelesin
				break;
			}
			case 2:{ //List All Leagues
				//TODO:League Module içersine yönlendir.
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