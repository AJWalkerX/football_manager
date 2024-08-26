package utility;

import databases.*;
import models.DatabaseModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileIOWriter {
	//Kendi dosya konumunu kopyala!!!!
	
	private static final File DIRECTORY = new File("C:\\Users\\AJWal\\OneDrive\\Masaüstü\\Desktop\\BilgeAdam\\WorkFlows\\projects\\futbol_manager\\file_io");
	public static void writePlayerToBin(PlayerDB playerDB){
		File outputFile = new File(DIRECTORY, "playerDB.bin");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile)))  {
			oos.writeObject(playerDB.findAll());
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void writeTeamToBin(TeamDB teamDB){
		File outputFile = new File(DIRECTORY, "teamDB.bin");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(teamDB.findAll());
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void writeLeagueToBin(LeagueDB leagueDB){
		File outputFile = new File(DIRECTORY, "leagueDB.bin");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(leagueDB.findAll());
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void writeManagerToBin(ManagerDB managerDB){
		File outputFile = new File(DIRECTORY, "managerDB.bin");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(managerDB.findAll());
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void writeMatchToBin(MatchDB matchDB){
		File outputFile = new File(DIRECTORY, "matchDB.bin");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(matchDB.findAll());
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static void writeStadiumToBin(StadiumDB stadiumDB){
		File outputFile = new File(DIRECTORY, "stadiumDB.bin");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(stadiumDB.findAll());
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static void writeStatsToBin(StatsDB statsDB){
		File outputFile = new File(DIRECTORY, "statsDB.bin");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(statsDB.findAll());
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void saveAllEntities(DatabaseModel databaseModel) {
		writePlayerToBin(databaseModel.playerDB);
		writeLeagueToBin(databaseModel.leagueDB);
		writeTeamToBin(databaseModel.teamDB);
		writeManagerToBin(databaseModel.managerDB);
		writeMatchToBin(databaseModel.matchDB);
		writeStadiumToBin(databaseModel.stadiumDB);
		writeStatsToBin(databaseModel.statsDB);
	}
}