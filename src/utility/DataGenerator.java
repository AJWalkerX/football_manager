package utility;

import databases.PlayerDB;
import databases.TeamDB;
import entities.Player;
import entities.Team;

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
		
		public static void generateTeams(TeamDB teamDB) {
			
			Team team1 = new Team(teamDB,"Fenerbahce",null,252_400_000L,1 );
			Team team2 = new Team(teamDB,"Galatasaray",null,210_500_000L,1 );
			Team team3 = new Team(teamDB,"Besiktas",null,142_530_000L,1 );
			Team team4 = new Team(teamDB,"Trabzonspor",null,98_630_000L,1 );
			Team team5 = new Team(teamDB, "Kocaelispor", null, 45_000_000L, 1 );
			Team team6 = new Team(teamDB,"Caykur Rizespor",null,32_750_000L,1 );
			Team team7 = new Team(teamDB,"Samsunspor",null,31_700_000L,1 );
			Team team8 = new Team(teamDB,"Antalyaspor",null,23_680_000L,1 );
			Team team9 = new Team(teamDB,"Goztepe",null,15_330_000L,1 );
			Team team10 = new Team(teamDB,"Adana Demirspor",null,23_400_000L,1 );
		}
	}