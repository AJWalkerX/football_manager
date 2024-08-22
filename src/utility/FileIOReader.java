package utility;

import databases.*;
import entities.*;
import models.DatabaseModel;
import utility.data.DataGenerator;

import java.io.*;
import java.util.List;

public class FileIOReader {
	private static final File
				DIRECTORY = new File("C:\\Users\\AJWal\\OneDrive\\Masaüstü\\Desktop\\BilgeAdam\\WorkFlows\\projects\\futbol_manager\\file_io");
	
	public static void readAllEntities(DatabaseModel databaseModel){
		//oyuncular icin
		File inputFilePlayer = new File(DIRECTORY, "playerDB.bin");
		if(inputFilePlayer.exists()){
			readPlayerFromBin(databaseModel.playerDB);
		}else{
			DataGenerator.generateRandomPlayers(databaseModel.playerDB);
		}
		//ligler icin
		File inputFileLeague = new File(DIRECTORY, "leagueDB.bin");
		if(inputFileLeague.exists()){
			readLeagueFromBin(databaseModel.leagueDB);
		}else{
			DataGenerator.generateLeagues(databaseModel.leagueDB);
		}
		//takimlar icin
		File inputFileTeam = new File(DIRECTORY, "teamDB.bin");
		if(inputFileTeam.exists()){
			readTeamFromBin(databaseModel.teamDB);
		}else{
			DataGenerator.generateTeams(databaseModel.teamDB, databaseModel.leagueDB);
		}
		//menajerler icin
		File inputFileManager = new File(DIRECTORY, "managerDB.bin");
		if(inputFileManager.exists()){
			readManagerFromBin(databaseModel.managerDB);
		}else{
			DataGenerator.generateManagers(databaseModel.managerDB);
		}
		//Match icin
		File inputFileMatch = new File(DIRECTORY, "matchDB.bin");
		if(inputFileMatch.exists()){
			readMatchFromBin(databaseModel.matchDB);
		}else{
			DataGenerator.generateManagers(databaseModel.managerDB);
		}
		
	}
	
	public static void readPlayerFromBin(PlayerDB playerDB) {
		File inputFile = new File(DIRECTORY, "playerDB.bin");
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
			playerDB.saveAll((List<Player>) ois.readObject());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void readLeagueFromBin(LeagueDB leagueDB) {
		File inputFile = new File(DIRECTORY, "leagueDB.bin");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
			leagueDB.saveAll((List<League>) ois.readObject());
			
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void readTeamFromBin(TeamDB teamDB) {
		File inputFile = new File(DIRECTORY, "teamDB.bin");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
			teamDB.saveAll((List<Team>) ois.readObject());
			
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void readManagerFromBin(ManagerDB managerDB) {
		File inputFile = new File(DIRECTORY, "managerDB.bin");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
			managerDB.saveAll((List<Manager>) ois.readObject());
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void readMatchFromBin(MatchDB matchDB) {
		File inputFile = new File(DIRECTORY, "matchDB.bin");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
			matchDB.saveAll((List<Match>) ois.readObject());
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
}