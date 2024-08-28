package databases;

import entities.MatchStats;
import models.DatabaseModel;
import utility.DatabaseManager;

import java.util.Optional;

public class MatchStatsDB extends DatabaseManager<MatchStats> {

    private static MatchStatsDB instance;
    public static MatchStatsDB getInstance() {
        if(instance==null){
            instance=new MatchStatsDB();
            return instance;
        }
        return instance;
    }
    
    public Optional<MatchStats> findByMatchID(int matchId) {
	    return veriListesi.stream().filter(matchStats -> matchStats.getMatchId() == matchId).findFirst();
    }
}