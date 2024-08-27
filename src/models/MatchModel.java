package models;

import entities.League;
import entities.Match;
import entities.Stadium;
import entities.Team;
import utility.FileIOReader;
import utility.FileIOWriter;

import java.time.LocalDate;
import java.util.*;

public class MatchModel {

    private int id;
    private DatabaseModel databaseModel;
    private League league;
    private String homeTeamName;
    private String awayTeamName;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private Stadium stadium;
    private LocalDate matchDate;


    public MatchModel(DatabaseModel databaseModel, Match match) {
        this.databaseModel = databaseModel;
        this.league = databaseModel.leagueDB.findByID(match.getLeagueID()).get();
        this.homeTeamName = databaseModel.teamDB.findByID(match.getHomeTeamId()).get().getTeamName();
        this.awayTeamName = databaseModel.teamDB.findByID(match.getAwayTeamId()).get().getTeamName();
        this.stadium = databaseModel.stadiumDB.findByID(match.getHomeTeamId()).orElse(null);
        this.matchDate = match.getMatchDate();
        this.homeTeamScore=match.getHomeTeamScore();
        this.awayTeamScore = match.getAwayTeamScore();

    }


    public void displayMatchInfo() {
        System.out.println("Stadium             : " + (stadium!=null ? stadium.getName() : "N/A"));
        System.out.println("Home Team           : " + homeTeamName);
        System.out.println("Away Team           : " + awayTeamName);
        System.out.println("Home Team Score     : " + homeTeamScore);
        System.out.println("Away Team Score     : " + awayTeamScore);
        System.out.println("Match Date          : " + matchDate);
        System.out.println("--------------------------------------------------");
    }









}
