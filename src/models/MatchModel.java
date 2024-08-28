package models;

import entities.*;
import utility.FileIOReader;
import utility.FileIOWriter;

import java.time.LocalDate;
import java.util.*;

public class MatchModel {

    private int matchID;
    private DatabaseModel databaseModel;
    private League league;
    private String homeTeamName;
    private String awayTeamName;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private Stadium stadium;
    private LocalDate matchDate;
    private boolean isPlayed;


    public MatchModel(DatabaseModel databaseModel, Match match) {
        this.databaseModel = databaseModel;
        this.matchID = match.getId();
        this.isPlayed = match.isPlayed();
        this.league = databaseModel.leagueDB.findByID(match.getLeagueID()).get();
        this.homeTeamName = databaseModel.teamDB.findByID(match.getHomeTeamId()).get().getTeamName();
        this.awayTeamName = databaseModel.teamDB.findByID(match.getAwayTeamId()).get().getTeamName();
        this.stadium = databaseModel.stadiumDB.findByID(match.getHomeTeamId()).orElse(null);
        this.matchDate = match.getMatchDate();
        this.homeTeamScore=match.getHomeTeamScore();
        this.awayTeamScore = match.getAwayTeamScore();

    }


    public void displayMatchInfo() {
        System.out.println("ID                  : " + matchID);
        System.out.println("Stadium             : " + (stadium!=null ? stadium.getName() : "N/A"));
        System.out.println("Home Team           : " + homeTeamName);
        System.out.println("Away Team           : " + awayTeamName);
        System.out.println("Home Team Score     : " + ((isPlayed)? homeTeamScore: "N/A"));
        System.out.println("Away Team Score     : " + ((isPlayed)? awayTeamScore: "N/A"));
        System.out.println("Match Date          : " + matchDate);
        System.out.println("--------------------------------------------------");
    }
    
    public  void displayMatchStats(MatchStats matchStats){
        System.out.println("Match ID:           : " + matchID);
        System.out.println(homeTeamName + " " + homeTeamScore + "-" + awayTeamScore + " " + awayTeamName + " statistics");
        System.out.println("--------------------------------------------");
        System.out.printf("%-10s %-20s %-10s\n", "%" + matchStats.getHomeTeamBallPercantage(), "Ball Possession", "%" + matchStats.getAwayTeamBallPercantage());
        System.out.printf("%-10d %-20s %-10d\n", matchStats.getHomeTeam_Passes(), "Total Passes", matchStats.getAwayTeam_Passes());
        System.out.printf("%-10d %-20s %-10d\n", matchStats.getHomeTeam_Shots(), "Total Shots", matchStats.getAwayTeam_Shots());
        System.out.printf("%-10d %-20s %-10d\n", matchStats.getHomeTeam_fouls(), "Total Fouls", matchStats.getAwayTeam_fouls());
        System.out.printf("%-10d %-20s %-10d\n", matchStats.getHomeTeam_Saves(), "Total Saves", matchStats.getAwayTeam_Saves());
        
        
        
        
        
        
    }
    
}