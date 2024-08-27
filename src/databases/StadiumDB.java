package databases;

import entities.Stadium;
import utility.DatabaseManager;

public class StadiumDB extends DatabaseManager<Stadium> {

    private static StadiumDB instance;

    private StadiumDB(){

    }

    public static StadiumDB getInstance(){
        if(instance==null){
            instance=new StadiumDB();
        }
        return instance;
    }
}
