package utility;

import databases.*;

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
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
			oos.writeObject(matchDB.findAll());
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void saveAllEntities(PlayerDB playerDB, TeamDB teamDB,
	                                   LeagueDB leagueDB,ManagerDB managerDB, MatchDB matchDB) {
		writePlayerToBin(playerDB);
		writeLeagueToBin(leagueDB);
		writeTeamToBin(teamDB);
		writeManagerToBin(managerDB);
		writeMatchToBin(matchDB);
	}
}