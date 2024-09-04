package utility.engine;

import entities.MatchStats;
import entities.Player;
import entities.Team;
import utility.EPosition;
import utility.engine.PlayerSelector;

import java.util.Random;

public class EventSimulator {
	private final PlayerSelector playerSelector;
	private static final Random random = new Random();
	
	public EventSimulator(PlayerSelector playerSelector) {
		this.playerSelector = playerSelector;
	}
	
	public boolean makeFinalPass(Team team, MatchStats matchStats) {
		Player player = playerSelector.selectRandomPlayer(team, EPosition.MIDFIELDER, EPosition.FORWARD);
		boolean success = random.nextInt(90) < player.getSkillLevel();
		logEvent(success, player, "makes a successful pass.", "loses the ball.");
		return success;
	}
	
	public boolean takeShot(Team team, MatchStats matchStats) {
		Player player = playerSelector.selectRandomPlayer(team, EPosition.MIDFIELDER, EPosition.FORWARD);
		boolean success = random.nextInt(100) < player.getSkillLevel();
		logEvent(success, player, "takes a shot on target!", "misses the shot.");
		return success;
	}
	
	public boolean makeSave(Team team, MatchStats matchStats) {
		Player goalKeeper = playerSelector.selectRandomPlayer(team, EPosition.GOALKEEPER);
		boolean success = random.nextInt(100) < goalKeeper.getSkillLevel();
		if (success) {
			System.out.println("Great save by " + team.getTeamName() + "'s goalkeeper!");
		}
		return success;
	}
	
	private void logEvent(boolean success, Player player, String successMessage, String failureMessage) {
		if (success) {
			System.out.println(player.getName() + " " + successMessage);
		} else {
			System.out.println(player.getName() + " " + failureMessage);
		}
	}
}