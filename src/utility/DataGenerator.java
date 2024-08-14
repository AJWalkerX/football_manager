package utility;

import databases.LeagueDB;
import databases.ManagerDB;
import databases.PlayerDB;
import databases.TeamDB;
import entities.League;
import entities.Manager;
import entities.Player;
import entities.Team;

import java.util.List;
import java.util.Random;

public class DataGenerator {
		
		private static final String[] FIRST_NAMES = {
				"Ahmet", "Mehmet", "Ali", "Mustafa", "Hasan", "Hüseyin", "İbrahim",
				"Kemal", "Yasin", "Cem", "Murat", "Osman", "Ferhat", "Burak", "Emre",
				"Ömer", "Halil", "Serkan", "Tuncay", "Levent", "Ersin", "Onur", "Barış",
				"Volkan", "Kadir", "Erdem", "Furkan", "Can", "Uğur", "Salih", "Sinan",
				"Gökhan", "Hakan", "Yavuz", "Erhan", "Rıza", "Tayfun", "Metin", "Doğan",
				"Koray", "Yusuf", "Oğuz", "Tolga", "Alper", "Mevlüt", "Şahin", "Zafer"
		};
		
		private static final String[] LAST_NAMES = {
				"Yılmaz", "Kaya", "Demir", "Çelik", "Şahin", "Öztürk", "Aydın", "Kılıç",
				"Arslan", "Doğan", "Kara", "Koç", "Özdemir", "Bal", "Şimşek", "Ekinci",
				"Polat", "Çetin", "Keskin", "Yücel", "Avcı", "Kurt", "Ateş", "Bulut",
				"Güneş", "Bozkurt", "Ay", "Türkmen", "Çakır", "Karaca", "Koçak", "Erol",
				"Tan", "Deniz", "Gürbüz", "Soylu", "Ünal", "Elmas", "Güler", "Aksoy",
				"Tuna", "Yıldız", "Gül", "Aslan", "Şener", "Özkan", "Erdoğan", "Sezer"
		};
		
		public static void generateRandomPlayers(PlayerDB playerDB) {
			Random random = new Random();
			int teamId = 1;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 11; j++) {
					Player player = new Player(playerDB);
					switch (j) {
						case 0:
							player.setPosition(EPosition.GOALKEEPER);
							break;
						case 1, 2, 3, 4:
							player.setPosition(EPosition.DEFENCE);
							break;
						case 5, 6, 7, 8:
							player.setPosition(EPosition.MIDFIELDER);
							break;
						case 9, 10:
							player.setPosition(EPosition.FORWARD);
					}
					player.setName(FIRST_NAMES[random.nextInt(0, FIRST_NAMES.length)] + " " + LAST_NAMES[random.nextInt(0, LAST_NAMES.length)]);
					player.setValue(random.nextLong(500_000, 45_000_000));
					player.setSkillLevel(random.nextInt(3, 11));
					player.setAge(String.valueOf(random.nextInt(17, 37)));
					player.setTeamID(teamId);
					
				}
				teamId++;
			}
		}
	
	public static void generateTeamsAndLeagues(TeamDB teamDB, LeagueDB leagueDB) {
		
		Team team1 = new Team(teamDB,"Fenerbahce",252_400_000L );
		Team team2 = new Team(teamDB,"Galatasaray",210_500_000L );
		Team team3 = new Team(teamDB,"Besiktas",142_530_000L );
		Team team4 = new Team(teamDB,"Trabzonspor",98_630_000L );
		Team team5 = new Team(teamDB,"Kocaelispor",45_000_000L);
		Team team6 = new Team(teamDB,"Caykur Rizespor",32_750_000L );
		Team team7 = new Team(teamDB,"Samsunspor",31_700_000L);
		Team team8 = new Team(teamDB,"Antalyaspor",23_680_000L );
		Team team9 = new Team(teamDB,"Goztepe",15_330_000L);
		Team team10 = new Team(teamDB,"Adana Demirspor",23_400_000L );
		Team team11 = new Team(teamDB,"Alanyaspor",22_460_000L );
		Team team12 = new Team(teamDB,"Sivasspor",20_780_000L);
		Team team13 = new Team(teamDB,"Kasimpasa",20_450_000L );
		Team team14 = new Team(teamDB,"Konyaspor",20_360_000L );
		Team team15 = new Team(teamDB,"Gaziantepspor",18_180_000L);
		Team team16 = new Team(teamDB,"Hatayspor",17_980_000L);
		Team team17 = new Team(teamDB,"Bursaspor",15_300_000L);
		Team team18 = new Team(teamDB,"Sakaryaspor",12_750_000L );
		
		League league1 = new League(leagueDB, "Türkiye Super Lig");
		
		league1.getTeamList().addAll(List.of(team1, team2, team3, team4, team5, team6, team7, team8
				, team9, team10, team11, team12, team13, team14, team15, team16, team17, team18));
	}
	public static void generateManagers(ManagerDB managerDB){
		Manager manager1 = new Manager(managerDB,1,"Jose Mourinho","61",10);
		Manager manager2 = new Manager(managerDB,2,"Okan Buruk","50",3);
		Manager manager3 = new Manager(managerDB,3,"Giovanni Van Brockhorst","49",8);
		Manager manager4 = new Manager(managerDB,4,"Abdullah Avci","61",4);
		Manager manager5 = new Manager(managerDB,5,"Ertugrul Saglam","54",7);
		Manager manager6 = new Manager(managerDB,6,"Ilhan Palut","47",8);
		Manager manager7 = new Manager(managerDB,7,"Thoman Reis","50",6);
		Manager manager8 = new Manager(managerDB,8,"Alex De Souza","46",7);
		Manager manager9 = new Manager(managerDB,9,"Stanimir Stoilov","57",6);
		Manager manager10 = new Manager(managerDB,10,"Michael Valkanis","49",6);
		Manager manager11 = new Manager(managerDB,11,"Fatih Tekke","46",7);
		Manager manager12 = new Manager(managerDB,12,"Bulent Uygun","53",8);
		Manager manager13 = new Manager(managerDB,13,"Sami Ugurlu","47",6);
		Manager manager14 = new Manager(managerDB,14,"Aleksandar Stanojevic","50",6);
		Manager manager15 = new Manager(managerDB,15,"Selcuk Inan","39",3);
		Manager manager16 = new Manager(managerDB,16,"Ozhan Pulat","39",5);
		Manager manager17 = new Manager(managerDB,17,"Pablo Batalla","40",7);
		Manager manager18 = new Manager(managerDB, 18, "Tuncay Sanli", "42", 6);
	}
}