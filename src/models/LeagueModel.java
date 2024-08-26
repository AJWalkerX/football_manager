package models;

import databases.LeagueDB;
import databases.MatchDB;
import entities.League;
import entities.Match;
import entities.Stats;
import utility.FileIOWriter;
import utility.enums.EDivision;
import utility.enums.ERegion;

import java.io.File;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LeagueModel {
	
	private String leaugeName;
	private DatabaseModel databaseModel;
	private List<Integer> teamIdList;
	private ERegion region;
	private EDivision division;
	private String season;
	private LocalDate BEGINNING_OF_SEASON;
	private LeagueDB leagueDB;
	private League league;
	private List<Match> fixture;
	
	public LeagueModel(DatabaseModel databaseModel, League league) {
		this.databaseModel = databaseModel;
		this.league = league;
		this.leaugeName = league.getLeagueName();
		this.fixture = databaseModel.matchDB.findAll().stream().sorted(Comparator.comparing(Match::getMatchDate)).toList();
		this.BEGINNING_OF_SEASON = league.getBeginningOfSeasonDate();
	}
	
	public void displayLeagueInfo() {
		System.out.println("--------------------------------------------------");
		System.out.println("League Information:");
		System.out.println("--------------------------------------------------");
		System.out.println("League Name           : " + leaugeName);
		System.out.println("League Region         : " + region);
		System.out.println("League Division       : " + division);
		System.out.println("League Season         : " + season);
		System.out.println("--------------------------------------------------");
		System.out.println("Season Start:         : " + BEGINNING_OF_SEASON);
		System.out.println("==================================================");
	}
	
	public void displayFixture() {
		AtomicInteger week = new AtomicInteger(1);
		AtomicInteger sayac = new AtomicInteger(0);
		System.out.println("########################################################################");
		fixture.stream()
		       .forEach(m -> {
			       if(sayac.get()%10==0){
				       System.out.println(week.getAndIncrement()+". Hafta Fikstürü");
			       }
			       new MatchModel(databaseModel, m).displayMatchInfo();
			       sayac.getAndIncrement();
		       });
		System.out.println("########################################################################");
	}
	
	
	//
	public void displayWeeklyFixture(long week) {
		System.out.println("Week " + week + " Fixture:");
		System.out.println("----------------------------------");
		fixture.stream()
		       .filter(m -> !m.getHomeTeamID().equals(20) && !m.getAwayTeamID().equals(20))
		       .skip((week - 1) * 9).limit((league.getTeamIDList().size() - 1) / 2)
		       .forEach(m -> new MatchModel(databaseModel, m).displayMatchInfo());
		System.out.println("----------------------------------");
		
	}
	
	public void displayStandings() {
		AtomicInteger rank = new AtomicInteger(1);

		System.out.printf("%-4s %-20s %3s %3s %3s %3s %3s %3s %4s %3s%n",
		                  "No", "Team Name", "GP", "W", "D", "L", "F", "A", "GD", "P");

		databaseModel.statsDB.findAll().stream()
		                    .filter(t -> !t.getId().equals(20))
		                    .sorted(Comparator.comparing(Stats::getPoints, Comparator.reverseOrder())
		                                      .thenComparing(Stats::getGoalsDifference,Comparator.reverseOrder())
		                                      .thenComparing(Stats::getGoalsFor,Comparator.reverseOrder()))
		                    .map(t -> String.format("%-4d %-20s %3d %3d %3d %3d %3d %3d %4d %3d",
		                                            rank.getAndIncrement(),
		                                            databaseModel.teamDB.findByID(t.getId()).get().getTeamName(),
		                                            t.getGamesPlayed(),
		                                            t.getTotalWins(),
		                                            t.getTotalDraws(),
		                                            t.getTotalLosses(),
		                                            t.getGoalsFor(),
		                                            t.getGoalsAgainst(),
		                                            t.getGoalsDifference(),
		                                            t.getPoints()))
		                    .forEach(System.out::println);
		System.out.println("----------------------------------------------");
	}

	public void displayPlayedMatches() {
		System.out.println("-------------------------");
		System.out.println(league.getLeagueName()+": PLAYED GAMES SO FAR...");
		System.out.println();

		databaseModel.matchDB.findAll().stream()
		                     .filter(Match::isPlayed)
		                     .forEach(m->new MatchModel(databaseModel, m).displayMatchInfo());
	}
}