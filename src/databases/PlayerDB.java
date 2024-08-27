package databases;

import entities.Manager;
import entities.Player;
import utility.DatabaseManager;

import java.util.Optional;

public class PlayerDB extends DatabaseManager<Player> {

    private static PlayerDB instance;

    private PlayerDB() {

    }

    public static PlayerDB getInstance(){
        if(instance==null){
            instance=new PlayerDB();
        }
        return instance;
    }
}
