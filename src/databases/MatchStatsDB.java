package databases;

import entities.MatchStats;
import utility.DatabaseManager;

public class MatchStatsDB extends DatabaseManager<MatchStats> {

    private static MatchStatsDB instance;

    private MatchStatsDB(){

    }

    public static MatchStatsDB getInstance(){
        if(instance==null){
            instance=new MatchStatsDB();
        }
        return instance;
    }
}
