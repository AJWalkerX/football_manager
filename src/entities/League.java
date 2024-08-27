package entities;

import databases.LeagueDB;
import models.DatabaseModel;
import utility.EDivision;
import utility.ERegion;
import utility.FileIOWriter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class League extends BaseEntity {

    private String leaugeName;
    private List<Integer> teamIdList;
    private ERegion region;
    private EDivision division;
    private String season;
    private final LocalDate BEGINNING_OF_SEASON;
    private LocalDate currentDate;


    public League(DatabaseModel databaseModel, LocalDate beginningOfSeason){
        super.id = databaseModel.leagueDB.findAll().size()+1;
        teamIdList = new ArrayList<>();
        BEGINNING_OF_SEASON = beginningOfSeason;
        currentDate = LocalDate.now(); //Todo test aşamsında.
        databaseModel.leagueDB.save(this);
        FileIOWriter.writeLeagueToBin(databaseModel);
    }
    public League(DatabaseModel databaseModel,String leaugeName,ERegion region,EDivision division,String season,ArrayList<Integer> teamIdList,LocalDate beginningOfSeasonDate ){
        super.id = databaseModel.leagueDB.findAll().size()+1;
        currentDate = LocalDate.now();//Todo test aşamsında.
        this.teamIdList = teamIdList;
        this.leaugeName=leaugeName;
        this.region=region;
        this.division=division;
        this.season = season;
        this.BEGINNING_OF_SEASON=beginningOfSeasonDate;


        databaseModel.leagueDB.save(this);
        FileIOWriter.writeLeagueToBin(databaseModel);
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public ERegion getRegion() {
        return region;
    }

    public void setRegion(ERegion region) {
        this.region = region;
    }

    public EDivision getDivision() {
        return division;
    }

    public void setDivision(EDivision division) {
        this.division = division;
    }

    public List<Integer> getTeamIdList() {
        return teamIdList;
    }


    public String getLeaugeName() {
        return leaugeName;
    }

    public void setLeaugeName(String leaugeName) {
        this.leaugeName = leaugeName;
    }

    public LocalDate getBEGINNING_OF_SEASON() {
        return BEGINNING_OF_SEASON;
    }


    @Override
    public String toString() {
        return "League{" +
                "id=" + getId() +
                ", leaugeName='" + getLeaugeName() + '\'' +
                ", region=" + getRegion() +
                ", division=" + getDivision() +
                ", season='" + getSeason() + '\'' +
                ", StartDate=" + getBEGINNING_OF_SEASON().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +
                '}';
    }
}
