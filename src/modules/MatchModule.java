package modules;

import entities.Match;
import entities.Team;
import models.DatabaseModel;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Random;
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
			System.out.println("1- Play match");
			System.out.println("2- Play Matches Before Certain Date");
			System.out.println("3- Play all matches");
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
			case 1:
				playMatch();
				matchModuleMenuOptions(matchModuleMenu());
				break;
			case 2:
				playMatchesBeforeDate(1);
				matchModuleMenuOptions(matchModuleMenu());
				break;
			case 3:
				playAllMatches(1);
				matchModuleMenuOptions(matchModuleMenu());
				break;
			
			
			case 0: {
				System.out.println("Returning to Main menu...");
				return opt;
			}
			default:
				System.out.println("Please enter a valid value!");
		}
		return opt;
	}
	
	
	
	
	private static void playMatch(Match match) {
		
		Team homeTeam = databaseModel.teamDB.findByID(match.getHomeTeamID()).get();
		Team awayTeam = databaseModel.teamDB.findByID(match.getAwayTeamID()).get();
		if (match.isPlayed()) {
//			backTraceMatchResult(match, homeTeam, awayTeam);
		}
		if (match.getHomeTeamID() == 20 || match.getAwayTeamID() == 20) {
			return; //Bay geçen takım maç yapmasın diye.
		}
		
		match.setHomeTeamScore(new Random().nextInt(0, 4));
		match.setAwayTeamScore(new Random().nextInt(0, 4));
		
		if(homeTeam.getId()==5 || homeTeam.getId()==1){
			match.setHomeTeamScore(match.getHomeTeamScore()+2);
		}
		if(awayTeam.getId()==5 || awayTeam.getId()==1){
			match.setAwayTeamScore(match.getAwayTeamScore()+2);
		}
		
		
		
//		updatePoints(match, homeTeam, awayTeam);
		match.setPlayed(true);
	}
	
	
	private static void playMatch() {
		
		System.out.println("Enter match id: ");
		int matchId = sc.nextInt();
		Match match = databaseModel.matchDB.findByID(matchId).orElse(null);
		
		if(match!=null) {
			Team homeTeam = databaseModel.teamDB.findByID(match.getHomeTeamID()).get();
			Team awayTeam = databaseModel.teamDB.findByID(match.getAwayTeamID()).get();
			if (match.isPlayed()) {
//				backTraceMatchResult(match, homeTeam, awayTeam);
			}
			if (match.getHomeTeamID() == 20 || match.getAwayTeamID() == 20) {
				return; //Bay geçen takım maç yapmasın diye.
			}
			match.setHomeTeamScore(new Random().nextInt(0, 4));
			match.setAwayTeamScore(new Random().nextInt(0, 4));
			
			
//			updatePoints(match, homeTeam, awayTeam);
			match.setPlayed(true);
		}
		else{
			System.out.println("Match couldn't be found");
		}
		
	}
	
	//TODO: further properties will be added
	private static void simulateMatch(){
	
	}
	
	private static void playMatchesBeforeDate(int leagueId) {
		System.out.println("Enter a date as Local: ");
		String date = sc.nextLine();
		LocalDate localDate = LocalDate.parse(date);
		databaseModel.matchDB.findAll().stream()
		                     .filter(m -> m.getLeagueID().equals(leagueId))
		                     .filter(m->m.getHomeTeamID().equals(20) || m.getAwayTeamID().equals(20)) //Bay geçen takım maç yapmasın diye
		                     .filter(m -> m.getMatchDate().isBefore(localDate))
		                     .forEach(MatchModule::playMatch);
	}
	
	private static void playAllMatches(int leagueId) {
		databaseModel.matchDB.findAll().stream()
		                     .filter(m -> m.getLeagueID().equals(leagueId))
		                     .filter(m->m.getHomeTeamID()!=20 && m.getAwayTeamID()!=20)
		                     .forEach(MatchModule::playMatch);
	}
	
//	private static void updatePoints(Match match, Team homeTeam, Team awayTeam) {
//		homeTeam.setGamesPlayed(homeTeam.getGamesPlayed()+1);
//		awayTeam.setGamesPlayed(awayTeam.getGamesPlayed()+1);
//
//		homeTeam.setGoalsFor(homeTeam.getGoalsFor()+match.getHomeTeamScore());
//		awayTeam.setGoalsFor(awayTeam.getGoalsFor()+match.getAwayTeamScore());
//		homeTeam.setGoalsAgainst(homeTeam.getGoalsAgainst()+match.getAwayTeamScore());
//		awayTeam.setGoalsAgainst(awayTeam.getGoalsAgainst()+match.getHomeTeamScore());
//		homeTeam.setGoalDifference(homeTeam.getGoalsFor()-homeTeam.getGoalsAgainst());
//		awayTeam.setGoalDifference(awayTeam.getGoalsFor()-awayTeam.getGoalsAgainst());
//
//		if(match.getHomeTeamScore()>match.getAwayTeamScore()){
//			homeTeam.setTotalWins(homeTeam.getTotalWins()+1);
//			awayTeam.setTotalLose(awayTeam.getTotalLose()+1);
//		}
//		else if(match.getAwayTeamScore()>match.getHomeTeamScore()){
//			awayTeam.setTotalWins(awayTeam.getTotalWins()+1);
//			homeTeam.setTotalLose(homeTeam.getTotalLose()+1);
//		}
//		else{
//			homeTeam.setTotalDraw(homeTeam.getTotalDraw()+1);
//			awayTeam.setTotalDraw(awayTeam.getTotalDraw()+1);
//		}
//		homeTeam.setPoints((homeTeam.getTotalWins()*3)+(homeTeam.getTotalDraw()));
//		awayTeam.setPoints((awayTeam.getTotalWins()*3)+awayTeam.getTotalDraw());
//	}
	
	
//	//Oynanan maç tekrar oynamak istenirse, önceki maç sonucunun takım istatistikleri üzerindeki etkisi sıfırlanır.
//	private static void backTraceMatchResult(Match match, Team homeTeam, Team awayTeam){
//		homeTeam.setGamesPlayed(homeTeam.getGamesPlayed()-1);
//		awayTeam.setGamesPlayed(awayTeam.getGamesPlayed()-1);
//
//		homeTeam.setGoalsFor(homeTeam.getGoalsFor()-match.getHomeTeamScore());
//		awayTeam.setGoalsFor(awayTeam.getGoalsFor()-match.getAwayTeamScore());
//		homeTeam.setGoalsAgainst(homeTeam.getGoalsAgainst()-match.getAwayTeamScore());
//		awayTeam.setGoalsAgainst(awayTeam.getGoalsAgainst()-match.getHomeTeamScore());
//		homeTeam.setGoalDifference(homeTeam.getGoalsFor()-homeTeam.getGoalsAgainst());
//		awayTeam.setGoalDifference(awayTeam.getGoalsFor()-awayTeam.getGoalsAgainst());
//
//		if(match.getHomeTeamScore()>match.getAwayTeamScore()){
//			homeTeam.setTotalWins(homeTeam.getTotalWins()-1);
//			awayTeam.setTotalLose(awayTeam.getTotalLose()-1);
//		}
//		else if(match.getAwayTeamScore()>match.getHomeTeamScore()){
//			awayTeam.setTotalWins(awayTeam.getTotalWins()-1);
//			homeTeam.setTotalLose(homeTeam.getTotalLose()-1);
//		}
//		else{
//			homeTeam.setTotalDraw(homeTeam.getTotalDraw()-1);
//			awayTeam.setTotalDraw(awayTeam.getTotalDraw()-1);
//		}
//		homeTeam.setPoints((homeTeam.getTotalWins()*3)+(homeTeam.getTotalDraw()));
//		awayTeam.setPoints((awayTeam.getTotalWins()*3)+awayTeam.getTotalDraw());
//	}
}