package models;

import databases.LeagueDB;
import databases.MatchDB;
import entities.League;
import entities.Match;
import utility.enums.EDivision;
import utility.enums.ERegion;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class LeagueModel {
	Map<Integer, List<MatchModel>> fixture;
	public static void main(String[] args) {
		List<Integer[]> fixtureList = generateFixtureList(6);
		fixtureList.forEach(s-> System.out.println(Arrays.toString(s)));
	}
	
	
	
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
		// 2.Yarı
		List<Integer[]> secondHalf = new ArrayList<>();
		for (Integer[] match : fixture) {
			secondHalf.add(new Integer[]{match[1], match[0]});
		}
		fixture.addAll(secondHalf);
		secondHalf.clear();
		
		secondHalf = new ArrayList<>();
		for (Integer[] match : fixture) {
			secondHalf.add(new Integer[]{match[1], match[0]});
		}
		fixture.addAll(secondHalf);
		
		return fixture;
	}
	
	public static void initilzeLocalDate(League league) {
		List<Match> matches = initilizeMatchIDs(league);
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
	
	private static List<Match> initilizeMatchIDs(League league) {
		List<Integer[]> fixtureList = generateFixtureList(league.getTeamIDList().size());
		List<Integer> teamIDlist = league.getTeamIDList();
		List<Match> matcheList = new ArrayList<>();
		
		for (Integer[] matches : fixtureList) {
			Match match = new Match(new MatchDB());
			match.setHomeTeamID(teamIDlist.get(matches[0]));
			match.setAwayTeamID(teamIDlist.get(matches[1]));
			matcheList.add(match);
		}
		return matcheList;
	}
}