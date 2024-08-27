package databases;

import entities.League;
import utility.DatabaseManager;

import java.util.List;
import java.util.Optional;

public class LeagueDB extends DatabaseManager<League> {

    private static LeagueDB instance;
    private LeagueDB(){

    }
    public static LeagueDB getInstance(){
        if(instance==null){
            instance=new LeagueDB();
        }
        return instance;
    }


    public List<League> getLeagues() {
        return findAll();
    }


}
