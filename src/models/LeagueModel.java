package models;

import entities.League;
import entities.Match;
import utility.enums.EDivision;
import utility.enums.ERegion;

import java.time.LocalDate;
import java.util.*;

public class LeagueModel {
	private DatabaseModel databaseModel;
	private String leagueName;
	private List<Integer> teamIDList;
	private ERegion region;
	private EDivision division;
	private String season;
	private LocalDate BEGINNING_SEASON_DATE;
	private Map<Integer, List<Match>> fixture;
	
	public LeagueModel(DatabaseModel databaseModel, League league) {
		this.databaseModel = databaseModel;
		this.leagueName = league.getLeagueName();
		this.teamIDList = league.getTeamIDList();
		this.region = league.getRegion();
		this.division = league.getDivision();
		this.season = league.getSeason();
		this.BEGINNING_SEASON_DATE = league.getBeginningOfSeasonDate();
		this.fixture = generateMatchesAndFixture();
	}
	
	public void displayLeagueInfo() {
		System.out.println("--------------------------------------------------");
		System.out.println("League Information:");
		System.out.println("--------------------------------------------------");
		System.out.println("League Name           : " + leagueName);
		System.out.println("League Region         : " + region);
		System.out.println("League Division       : " + division);
		System.out.println("League Season         : " + season);
		System.out.println("--------------------------------------------------");
		System.out.println("Season Start:         :" + BEGINNING_SEASON_DATE);
		System.out.println("Fixture List          :");
		System.out.println("--------------------------------------------------");
		
		if (fixture != null && !fixture.isEmpty()) {
			fixture.forEach((key, matches) -> matches.forEach(match -> new MatchModel(databaseModel, match).displayMatchInfo()));
		}
		else {
			System.out.println("No fixture found for this league.");
		}
		System.out.println("==================================================");
	}
	
	private Map<Integer, List<Match>> generateMatchesAndFixture() {
		int teamNums = teamIDList.size();
		int matchesPerWeek = teamNums / 2;
		
		List<Integer[]> fixtureListWithID = generateFixtureList();
		List<Match> matches = setIDToMatches(fixtureListWithID);//Mac nesnesi yarattigimiz yer.
		
		
		Map<Integer, List<Match>> fixtureMap = createFixtureMap(matches, matchesPerWeek);
		
		Map<Integer, List<Match>> updatedFixtureMap = initializeDateToMatches(fixtureMap);

//        fixtureMap.forEach((k,v)->{
//            System.out.println(k+".Hafta");
//            for(Match match : v){
//                System.out.println(match);
//            }
//        });
		return updatedFixtureMap;
	}
	
	private Map<Integer, List<Match>> createFixtureMap(List<Match> matches, int matchesPerWeek) {
		Map<Integer, List<Match>> weeklyFixture = new HashMap<>();
		
		int counter = 0;
		for (int i = 1; i <= (matches.size() / matchesPerWeek); i++) {
			weeklyFixture.put(i, new ArrayList<>());
			for (int j = 0; j < matchesPerWeek; j++) {
				weeklyFixture.get(i).add(matches.get(counter++));
			}
		}
		
		Map<Integer, List<Match>> temp = new HashMap<>();
		weeklyFixture.forEach(temp::put);
		for (int i = 1; i <= weeklyFixture.size() / 2; i++) {
			if (i % 2 == 0) {
				weeklyFixture.put(i, temp.get(i + 19));
				weeklyFixture.put(i + 19, temp.get(i));
			}
		}
		return weeklyFixture;
	}
	
	
	private Map<Integer, List<Match>> initializeDateToMatches(Map<Integer, List<Match>> weeklyFixture) {
		
		LocalDate matchDate = BEGINNING_SEASON_DATE;
		List<Match> matches = new ArrayList<>();
		Integer teamIDListSize = teamIDList.size();
		weeklyFixture.forEach((k, v) -> {
			matches.addAll(v);
		});
		int totalWeek = (teamIDListSize - 1) * 2;
		int matchesPerWeek = teamIDListSize / 2;
		int matchIndex = 0;
		
		for (int i = 0; i < totalWeek; i++) {
			for (int j = 0; j < matchesPerWeek; j++) {
				switch (j) {
					case 0, 1:
						matches.get(matchIndex++).setMatchDate(matchDate);
						break;
					case 2, 3, 4:
						matches.get(matchIndex++).setMatchDate(matchDate.plusDays(1));
						break;
					case 5, 6, 7:
						matches.get(matchIndex++).setMatchDate(matchDate.plusDays(2));
						break;
					case 8, 9:
						matches.get(matchIndex++).setMatchDate(matchDate.plusDays(3));
						break;
				}
			}
			matchDate = matchDate.plusDays(7);
		}
		return weeklyFixture;
	}
	
	
	private List<Integer[]> generateFixtureList() {
		List<Integer> indexList = new ArrayList<>();
		int teamCount = teamIDList.size();
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
		
		for (int i = 0; i < totalWeekNumber * (teamCount / 2); i++) {
			Integer[] temp = fixture.get(i);
			Integer[] yeni = new Integer[2];
			yeni[0] = temp[1];
			yeni[1] = temp[0];
			fixture.add(yeni);
		}
		
		return fixture;
	}
	
	
	private List<Match> setIDToMatches(List<Integer[]> fixtureList) {
		
		List<Match> matchesList = new ArrayList<>();
		
		for (Integer[] matches : fixtureList) {
			Match match = new Match(this.databaseModel.matchDB);
			match.setLeagueID(teamIDList.get(matches[0]));
			match.setLeagueID(teamIDList.get(matches[1]));
			matchesList.add(match);
		}
		
		
		return matchesList;
	}
	
	
}