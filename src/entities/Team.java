package entities;



import databases.TeamDB;
import models.DatabaseModel;
import utility.FileIOWriter;

public class Team extends BaseEntity{
    private static Integer teamId = 0;
    private String teamName;
    private Long budget;

//    private int gamesPlayed; //Oynanan mac sayisi
//    private int totalWins;
//    private int totalDraw; //Toplam beraberlik
//    private int totalLose;
//    private int goalsFor; //Attığı gol
//    private int goalsAgainst; //Yediği gol
//    private int goalDifference; //Averaj
//    private int points; //puan



    public Team(DatabaseModel databaseModel, String teamName, Long budget) {
        id = databaseModel.teamDB.findAll().size()+1;
        this.teamName = teamName;
        this.budget = budget;
        databaseModel.teamDB.save(this);
        FileIOWriter.writeTeamToBin(databaseModel);

    }

    public Team(DatabaseModel databaseModel) {
        super.id = databaseModel.teamDB.findAll().size()+1;
        databaseModel.teamDB.save(this);
        FileIOWriter.writeTeamToBin(databaseModel);
    }

    public static Integer getTeamId() {
        return teamId;
    }

    public static void setTeamId(Integer teamId) {
        Team.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }


    @Override
    public String toString() {
        return "Team{" +
                "id=" + getId() +
                ", teamName='" + getTeamName() + '\'' +
                ", budget=" + getBudget() +
                '}';
    }
}
