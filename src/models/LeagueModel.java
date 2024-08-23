package models;

import databases.MatchDB;
import entities.League;
import entities.Match;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class LeagueModel {
	Map<Integer, List<MatchModel>> fixture;
	public static void main(String[] args) {
		List<Integer[]> fixtureList = generateFixtureList(20);
		fixtureList.forEach(s-> System.out.println(Arrays.toString(s)));
		System.out.println(fixtureList.size());

	}
	
	private static List<Integer[]> generateFixtureList(int teamCount) {
//    List<Integer> teams = new ArrayList<>();
//    for (int i = 0; i < teamCount; i++) {
//        teams.add(i);
//    }
//
//    List<Integer[]> fixtures = new ArrayList<>();
//    for (int i = 0; i < teamCount - 1; i++) {
//        for (int j = 0; j < teamCount / 2; j++) {
//            int homeTeam = teams.get(j);
//            int awayTeam = teams.get(teamCount - 1 - j);
//            fixtures.add(new Integer[]{homeTeam, awayTeam});
//        }
//        // Rotate the teams
//        teams.add(0, teams.remove(teamCount - 1));
//    }
//
//    // Add the second half of the fixtures
//    for (int i = 0; i < teamCount - 1; i++) {
//        for (int j = 0; j < teamCount / 2; j++) {
//            int homeTeam = teams.get(j);
//            int awayTeam = teams.get(teamCount - 1 - j);
//            fixtures.add(new Integer[]{awayTeam, homeTeam});
//        }
//        // Rotate the teams
//        teams.add(0, teams.remove(teamCount - 1));
//    }
		List<Integer> indexList = new ArrayList<>();
		for (int i = 0; i< teamCount; i++){
			indexList.add(i);
		}
		Collections.shuffle(indexList);
		int totalWeekNumber = indexList.size()-1;
		List<Integer[]> fixture = new ArrayList<>();
		
		for(int i =0;i<totalWeekNumber;i++){
			List<Integer> remainingTeams = new ArrayList<>(indexList);
			for(int j=0;j<indexList.size()/2;j++){
				Integer homeTeamId= remainingTeams.remove(0);
				Integer awayTeamId= remainingTeams.remove(new Random().nextInt(remainingTeams.size()));
				fixture.add(new Integer[] {homeTeamId,awayTeamId});
			}
		}
		
		for(int i =0;i<totalWeekNumber*(teamCount/2);i++){
			Integer[] temp = fixture.get(i);
			Integer[] yeni = new Integer[2];
			yeni[0] =temp[1];
			yeni[1] =temp[0];
			fixture.add(yeni);
		}
		
		Map<Integer, List<Integer[]>> map = new HashMap<>();
		int sayac = 0;
		for (int i = 0; i < (teamCount - 1) * 2; i++) {
			
			map.put(i + 1, new ArrayList<>());
			for (int j = 0; j < (teamCount / 2); j++) {
				map.get(i + 1).add(fixture.get(sayac));
				sayac++;
			}
		}
		for (int i = 1; i <= (teamCount - 1); i++) {
			if (i % 2 == 0) {
				Map<Integer, List<Integer[]>> temp = new HashMap<>();
				temp.put(i, map.get(i));
				map.put(i, map.get(i + (teamCount - 1)));
				map.put(i + (teamCount - 1), temp.get(i));
			}
			
		}
		fixture.clear();
		
		for (Map.Entry<Integer, List<Integer[]>> entry : map.entrySet()) {
			fixture.addAll(entry.getValue());
		}
		return fixture;
}
	
	public static void initilzeLocalDate(League league) {
		List<Match> matches = generateMatchList(league);
		System.out.println("Total matches: " + matches.size());
		LocalDate beginningOfSeasonDate = league.getBeginningOfSeasonDate();
		int totalMatch = matches.size();
		LocalDate matchDay = beginningOfSeasonDate;
		int countMatches = 0;
		DayOfWeek dayOfWeek;
		
		while (countMatches < totalMatch) {
			dayOfWeek = matchDay.getDayOfWeek();
			switch (dayOfWeek.toString().toLowerCase()) {
				case "friday", "monday": {
					for (int i = 0; i < 2 && countMatches < totalMatch; i++) {
						matches.get(countMatches++).setMatchDate(matchDay);
					}
					matchDay = matchDay.plusDays(1);
					break;
				}
				case "saturday", "sunday": {
					for (int i = 0; i < 3 && countMatches < totalMatch; i++) {
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
	
	private static List<Match> generateMatchList(League league) {
		List<Integer[]> fixtureList = generateFixtureList(league.getTeamIDList().size());
		List<Integer> teamIDlist = league.getTeamIDList();
		List<Match> matcheList = new ArrayList<>();
		
		for (Integer[] matches : fixtureList) {
			Match match = new Match(new MatchDB());
			match.setHomeTeamID(teamIDlist.get(matches[0]));
			match.setAwayTeamID(teamIDlist.get(matches[1]));
			matcheList.add(match);
		}
		matcheList.forEach(System.out::println);
		return matcheList;
	}
}