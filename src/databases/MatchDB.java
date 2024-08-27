package databases;

import entities.Match;
import utility.DatabaseManager;

public class MatchDB extends DatabaseManager<Match> {
    private static MatchDB instance;

    private MatchDB(){

    }
    public static MatchDB getInstance(){
        if(instance==null){
            instance=new MatchDB();
        }
        return instance;
    }

}
