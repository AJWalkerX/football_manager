package utility;

import databases.*;

import java.io.*;

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
	
	
	
	
//	public static void nesneleriDisariYazdir(PlayerDB playerDB, TeamDB teamDB, LeagueDB leagueDB,ManagerDB managerDB) {
//		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ogrenciler.bin"))) {
//			oos.writeObject(playerDB.findAll());
//
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//		//Takimlar icin
//		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("takimlar.bin"))) {
//			oos.writeObject(teamDB.findAll());
//
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//		//Ligler icin
//		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ligler.bin"))) {
//			oos.writeObject(leagueDB.findAll());
//
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//		//Menajerler icin
//		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("managers.bin"))) {
//			oos.writeObject(managerDB.findAll());
//
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
}