package databases;

import entities.Manager;
import utility.database_foundation.DatabaseManager;

import java.util.Optional;

public class ManagerDB extends DatabaseManager<Manager> {
	public Optional<Manager> findByUsernameAndPassword(String username, String password) {
		return veriListesi.stream().filter(user-> user.getUsername().equals(username)
				&& user.getPassword().equals(password)).findFirst();
	}
}