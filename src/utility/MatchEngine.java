package utility;

import entities.*;
import models.DatabaseModel;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MatchEngine {
    static DatabaseModel databaseModel = DatabaseModel.getInstance();
    static Random random = new Random();
    static final double EVENT_POSSIBILITY = 0.03; // Moved magic number to a constant

    public static void simulateMatch(Match match) {
        MatchStats matchStats = calculateTeamPassDistribution(match);

        Team homeTeam = getTeamById(match.getHomeTeamId());
        Team awayTeam = getTeamById(match.getAwayTeamId());

        int totalPass = matchStats.getAwayTeam_Passes() + matchStats.getHomeTeam_Passes();
        int homeTeamBallPercantage = matchStats.getHomeTeamBallPercantage();

        for (int i = 0; i < totalPass; i++) {
            double chance = Math.random();
            if (chance <= EVENT_POSSIBILITY) {
                Team attackingTeam = decideAttackingTeam(homeTeam, awayTeam, homeTeamBallPercantage);
                Team defenceTeam = attackingTeam == homeTeam ? awayTeam : homeTeam;

                if (makeFinalPass(attackingTeam, matchStats) && takeShot(attackingTeam, matchStats)) {
                    if (!makeSave(defenceTeam, matchStats)) {
                        updateScore(match, attackingTeam, homeTeam);
                    }
                }
            }
        }
    }

    private static Team decideAttackingTeam(Team homeTeam, Team awayTeam, int homeTeamBallPercantage) {
        int randomValue = random.nextInt(101);
        return randomValue < homeTeamBallPercantage ? homeTeam : awayTeam;
    }

    private static void updateScore(Match match, Team attackingTeam, Team homeTeam) {
        System.out.println("GOOOOOOOLLLL " + attackingTeam.getTeamName() + " scores amazing goal!!!");
        if (attackingTeam == homeTeam) {
            match.setHomeTeamScore(match.getHomeTeamScore() + 1);
        } else {
            match.setAwayTeamScore(match.getAwayTeamScore() + 1);
        }
        System.out.println("Score = " + match.getHomeTeamScore() + " - " + match.getAwayTeamScore());
    }

    private static Team getTeamById(int teamId) {
        Optional<Team> team = databaseModel.teamDB.findByID(teamId);
        return team.orElseThrow(() -> new IllegalArgumentException("Team not found with ID: " + teamId));
    }

    private static int calculateTeamPower(Team team) {
        return databaseModel.playerDB.findAll().stream()
                                     .filter(p -> p.getTeamId() == team.getId())
                                     .map(Player::getSkillLevel)
                                     .reduce(0, Integer::sum) / 11;
    }

    private static MatchStats calculateTeamPassDistribution(Match match) {
        MatchStats matchStats = new MatchStats(databaseModel, match.getId());
        int totalPass = random.nextInt(700, 1000);

        Team homeTeam = getTeamById(match.getHomeTeamId());
        Team awayTeam = getTeamById(match.getAwayTeamId());

        int homeTeamPower = calculateTeamPower(homeTeam);
        int awayTeamPower = calculateTeamPower(awayTeam);

        int homeTeamPassPercentage = calculatePassPercentage(homeTeamPower, awayTeamPower);
        int awayTeamPassPercentage = 100 - homeTeamPassPercentage;

        int homeTeamPasses = (int) Math.round((homeTeamPassPercentage / 100.0) * totalPass);
        int awayTeamPasses = (int) Math.round((awayTeamPassPercentage / 100.0) * totalPass);

        matchStats.setHomeTeam_Passes(homeTeamPasses);
        matchStats.setAwayTeam_Passes(awayTeamPasses);
        matchStats.setHomeTeamBallPercantage(homeTeamPassPercentage);
        matchStats.setAwayTeamBallPercantage(awayTeamPassPercentage);

        return matchStats;
    }

    private static int calculatePassPercentage(int homeTeamPower, int awayTeamPower) {
        int basePercentage = (int) (50 + (homeTeamPower - awayTeamPower) * 0.5);
        return Math.max(30, Math.min(70, basePercentage));
    }

    private static boolean makeFinalPass(Team team, MatchStats matchStats) {
        Player player = selectRandomPlayer(team, EPosition.MIDFIELDER, EPosition.FORWARD);
        boolean success = random.nextInt(90) < player.getSkillLevel();

        if (success) {
            System.out.println(player.getName() + " makes a successful pass.");
        } else {
            System.out.println(player.getName() + " loses the ball.");
        }
        return success;
    }

    private static boolean takeShot(Team team, MatchStats matchStats) {
        Player player = selectRandomPlayer(team, EPosition.MIDFIELDER, EPosition.FORWARD);
        boolean success = random.nextInt(100) < player.getSkillLevel();

        if (success) {
            System.out.println(player.getName() + " takes a shot on target!");
        } else {
            System.out.println(player.getName() + " misses the shot.");
        }
        return success;
    }

    private static boolean makeSave(Team team, MatchStats matchStats) {
        Player goalKeeper = selectRandomPlayer(team, EPosition.GOALKEEPER);
        boolean success = random.nextInt(100) < goalKeeper.getSkillLevel();

        if (success) {
            System.out.println("Great save by " + team.getTeamName() + "'s goalkeeper!");
        }

        return success;
    }

    private static Player selectRandomPlayer(Team team, EPosition... positions) {
        List<Player> players = databaseModel.playerDB.findAll().stream()
                                                     .filter(p -> p.getTeamId().equals(team.getId()))
                                                     .filter(p -> List.of(positions).contains(p.getPosition()))
                                                     .toList();
        return players.get(random.nextInt(players.size()));
    }
}