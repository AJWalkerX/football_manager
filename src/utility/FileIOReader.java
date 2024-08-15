package utility;

import databases.*;
import entities.League;
import entities.Manager;
import entities.Player;
import entities.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIOReader {
	private static final File
				DIRECTORY = new File("C:\\Users\\AJWal\\OneDrive\\Masaüstü\\Desktop\\BilgeAdam\\WorkFlows\\futbol_manager\\file_io");
	
	
		public static void readPlayerFromBin(PlayerDB playerDB){
			File inputFile = new File(DIRECTORY, "playerDB.bin");
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile)))  {
				playerDB.saveAll((List<Player>) ois.readObject());
				
			} catch (IOException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		
		public static void readTeamFromBin(TeamDB teamDB){
			File inputFile = new File(DIRECTORY, "teamDB.bin");
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile)))  {
				teamDB.saveAll((List<Team>) ois.readObject()) ;
				
			} catch (IOException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		
		public static void readLeagueFromBin(LeagueDB leagueDB){
			File inputFile = new File(DIRECTORY, "leagueDB.bin");
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile)))  {
				leagueDB.saveAll((List<League>) ois.readObject());
				
			} catch (IOException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		
		public static void readManagerFromBin(ManagerDB managerDB){
			File inputFile = new File(DIRECTORY, "managerDB.bin");
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile)))  {
				managerDB.saveAll((List<Manager>) ois.readObject()) ;
				
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	
		public static void readAllEntities(PlayerDB playerDB,TeamDB teamDB,LeagueDB leagueDB,ManagerDB managerDB){
		//oyuncular icin
		File inputFilePlayer = new File(DIRECTORY, "playerDB.bin");
		ArrayList<Player> o = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFilePlayer))){
			o = (ArrayList<Player>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		playerDB.findAll().addAll(o);
		
		//takimlar icin
		File inputFileTeam = new File(DIRECTORY, "teamDB.bin");
		ArrayList<Team> teams = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFileTeam))){
			teams = (ArrayList<Team>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		teamDB.findAll().addAll(teams);
		
		//menajerler icin
		File inputFileManager = new File(DIRECTORY, "managerDB.bin");
		ArrayList<Manager> managers = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFileManager))){
			managers = (ArrayList<Manager>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		managerDB.findAll().addAll(managers);
		
		
		//ligler icin
		File inputFileLeague = new File(DIRECTORY, "leagueDB.bin");
		ArrayList<League> leagues = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFileLeague))){
			leagues = (ArrayList<League>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		leagueDB.findAll().addAll(leagues);
		
	}
}