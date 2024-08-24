package databases;

import entities.League;
import utility.database_foundation.DatabaseManager;

import java.util.List;

public class LeagueDB extends DatabaseManager<League> {
	
	public List<League> getLeagues() {
		return findAll();
	}
}