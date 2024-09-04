package utility.engine;

import entities.Player;
import entities.Team;
import models.DatabaseModel;
import utility.EPosition;

import java.util.List;
import java.util.Random;


public class PlayerSelector {
	private final DatabaseModel databaseModel;
	private static final Random random = new Random();
	
	public PlayerSelector(DatabaseModel databaseModel) {
		this.databaseModel = databaseModel;
	}
	
	public Player selectRandomPlayer(Team team, EPosition... positions) {
		List<Player> players =
				databaseModel.playerDB.findAll().stream().filter(p -> p.getTeamId().equals(team.getId()))
		                                             .filter(p -> List.of(positions).contains(p.getPosition()))
		                                             .toList();
		return players.get(random.nextInt(players.size()));
	}
}