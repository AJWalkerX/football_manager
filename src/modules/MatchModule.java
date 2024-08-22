package modules;

import databases.LeagueDB;
import databases.MatchDB;
import databases.PlayerDB;
import databases.TeamDB;
import entities.League;
import entities.Match;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class MatchModule {
	private static Scanner sc = new Scanner(System.in);
	private static LeagueDB leagueDB;
	private static MatchDB matchDB;
	
	
	public static int matchModule(MatchDB matchDatabase, LeagueDB leagueDatabase) {
		matchDB = matchDatabase;
		leagueDB = leagueDatabase;
		int opt = 0;
		opt = matchModuleMenuOptions(matchModuleMenu());
		return opt;
	}
	public static int matchModuleMenu(){
		while (true){
			System.out.println("### Match Module MENU ###");
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
	public static int matchModuleMenuOptions(int opt){
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
			case 3:{ //Generate Fixture
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
	
	
	//Fixture işlemleri
	
	private static List<Integer[]> generateFixtureList(int teamCount) {
		List<Integer> indexList = new ArrayList<>();
		for (int i = 0; i < teamCount; i++) {
			indexList.add(i);
		}
		Collections.shuffle(indexList);
		int totalWeekNumber = indexList.size() - 1;
		List<Integer[]> fixture = new ArrayList<>();
		
		for (int i = 0; i < totalWeekNumber; i++) {
			List<Integer> remainingTeams = new ArrayList<>(indexList);
			for (int j = 0; j < indexList.size() / 2; j++) {
				Integer homeTeamId = remainingTeams.remove(0);
				Integer awayTeamId = remainingTeams.remove(new Random().nextInt(remainingTeams.size()));
				fixture.add(new Integer[]{homeTeamId, awayTeamId});
			}
		}
		
		for (int i = 0; i < totalWeekNumber * 10; i++) {
			Integer[] temp = fixture.get(i);
			Integer[] yeni = new Integer[2];
			yeni[0] = temp[1];
			yeni[1] = temp[0];
			fixture.add(yeni);
		}
//		// TODO:her hafta aynı takım ev sahibi olmaması için oluşturulan kod
//		for(int i=1;i<=19;i++){
//			if(i%2==0){
//				Map<Integer,List<Integer[]>> temp = new HashMap<>();
//				temp.put(i, map.get(i));
//				map.put(i,map.get(i+19));
//				map.put(i+19,temp.get(i));
//			}
//
//		}
		return fixture;
		
	}
	
	public static void initilzeLocalDate(League league) {
		List<Match> matches = initilizeMatchIDs(league);
		System.out.println(matches.size());
		LocalDate beginningOfSeasonDate = league.getBeginningOfSeasonDate();
		int totalMatch = matches.size();
		LocalDate matchDay = beginningOfSeasonDate;
		int countMatches = 0;
		DayOfWeek dayOfWeek;
		while (countMatches < totalMatch) {
			dayOfWeek = matchDay.getDayOfWeek();
			switch (dayOfWeek.toString().toLowerCase()) {
				case "friday", "monday": {
					for (int i = 0; i< 2; i++){
						matches.get(countMatches++).setMatchDate(matchDay);
					}
					matchDay = matchDay.plusDays(1);
					break;
				}
				case "saturday", "sunday": {
					for (int i = 0; i< 3; i++){
						matches.get(countMatches++).setMatchDate(matchDay);
					}
					matchDay = matchDay.plusDays(1);
					break;
				}
				default:
					matchDay = matchDay.plusDays(3);
			}
		}
		matches.stream().sorted(Comparator.comparing(Match::getMatchDate)).forEach(System.out::println);
	}
	
	private static List<Match> initilizeMatchIDs(League league) {
		List<Integer[]> fixtureList = generateFixtureList(league.getTeamIDList().size());
		List<Integer> teamIDlist = league.getTeamList();
		List<Match> matcheList = new ArrayList<>();
		Collections.shuffle(teamIDlist);
		for (Integer[] matches : fixtureList) {
			Match match = new Match(new MatchDB());
			match.setHomeTeamID(teamIDlist.get(matches[0]));
			match.setAwayTeamID(teamIDlist.get(matches[1]));
			matcheList.add(match);
		}
		return matcheList;
		//TODO: tarihe göre sıralamak için başka bir yere al bunu!
//
	}
	//! aynı takım maci bir başka haftaya da gelebiliyor.
}