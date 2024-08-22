package models;

import databases.*;

public class DatabaseModel {
	public final ManagerDB managerDB = new ManagerDB();
	public final PlayerDB playerDB = new PlayerDB();
	public final TeamDB teamDB = new TeamDB();
	public final LeagueDB leagueDB = new LeagueDB();
	public final MatchDB matchDB = new MatchDB();
}