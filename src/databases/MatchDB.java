package databases;

import entities.Match;
import utility.database_foundation.DatabaseManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class MatchDB extends DatabaseManager<Match> {
	public static List<Match> readAll(File inputFileMatch) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFileMatch))) {
			return (List<Match>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}