package entities;

import databases.MatchDB;
import models.DatabaseModel;
import utility.FileIOWriter;

import java.time.LocalDate;

public class Match extends BaseEntity{

    static Integer matchIdCounter = 0;
    private Integer homeTeamId;
    private Integer awayTeamId;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private LocalDate matchDate;
    private Integer leagueID;



    private boolean isPlayed; // mac oynandi mi ? yeni eklendi.

    public Match(DatabaseModel databaseModel) {
        super.id=databaseModel.matchDB.findAll().size()+1;
        this.leagueID=1; //todo: geçici çözüm
        databaseModel.matchDB.save(this);
        FileIOWriter.writeMatchToBin(databaseModel);
        isPlayed=false;

    }

    public Match(DatabaseModel databaseModel,Integer homeTeamId, Integer awayTeamId, Integer homeTeamScore, Integer awayTeamScore, Integer leagueID) {
        super.id=databaseModel.matchDB.findAll().size()+1;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.leagueID = leagueID;
    }

    public boolean isPlayed() {
        return isPlayed;
    }

    public void setPlayed(boolean played) {
        isPlayed = played;
    }



    public static Integer getMatchIdCounter() {
        return matchIdCounter;
    }

    public static void setMatchIdCounter(Integer matchIdCounter) {
        Match.matchIdCounter = matchIdCounter;
    }

    public Integer getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(Integer leagueID) {
        this.leagueID = leagueID;
    }


    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public Integer getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Integer homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public Integer getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(Integer awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }


    @Override
    public String toString() {
        return "Match{" +
                "id=" + getId() +
                ", homeTeamId=" + getHomeTeamId() +
                ", awayTeamId=" + getAwayTeamId() +
                ", matchDate=" + getMatchDate() +
                '}';
    }
}
