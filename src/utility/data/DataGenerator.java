package utility.data;

import databases.*;
import entities.*;
import utility.enums.EDivision;
import utility.enums.EPosition;
import utility.enums.ERegion;

import java.time.LocalDate;
import java.util.*;

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
		for (int i = 0; i < 19; i++) {
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
				player.setSkillLevel(random.nextInt(25, 101));
				player.setAge(String.valueOf(random.nextInt(17, 37)));
				player.setTeamID(teamId);
				
			}
			teamId++;
		}
	}
	
	public static void generateTeams(TeamDB teamDB, LeagueDB leagueDB) {
		
		Team team1 = new Team(teamDB,"Fenerbahce",252_400_000L);
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
		Team team19 = new Team(teamDB, "Sipay Bodrum FK", 20_710_000L);
		Team team20 = new Team(teamDB, "BAY", 0L);
	}
	
	public static League generateLeagues(LeagueDB leagueDB) {
		ArrayList<Integer> trSuperLeagueArrayList =
				new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
		
		League turkishSuperLeague =
				new League(leagueDB, "Turkish Super League", ERegion.TURKIYE, EDivision.SUPER_LIG_TR,
				           "2024-2025", trSuperLeagueArrayList, LocalDate.parse("2024-08-06"));
		return turkishSuperLeague;
	}
	
	public static void generateManagers(ManagerDB managerDB){
		final String password = "123456";
		Manager manager1 = new Manager(managerDB,"Jose Mourinho","61","josemourinho",password,1,10);
		Manager manager2 = new Manager(managerDB,"Okan Buruk","50","okanburuk",password,2,3);
		Manager manager3 = new Manager(managerDB,"Giovanni Van Brockhorst","49","giovanni",password,3,8);
		Manager manager4 = new Manager(managerDB,"Abdullah Avci","61","abdullahavci",password,4,4);
		Manager manager5 = new Manager(managerDB,"Ertugrul Saglam","54","ertugrulsaglam",password,5,7);
		Manager manager6 = new Manager(managerDB,"Ilhan Palut","47","ilhanpalut",password,6,7);
		Manager manager7 = new Manager(managerDB,"Thoman Reis","46","thomanreis",password,7,7);
		Manager manager8 = new Manager(managerDB,"Alex De Souza","46","alexdesouza",password,8,8);
		Manager manager9 = new Manager(managerDB,"Stanimir Stoilov","57","stanimirstoilov",password,9,6);
		Manager manager10 = new Manager(managerDB,"Michael Valkanis","49","michaelvalkanis",password,10,6);
		Manager manager11 = new Manager(managerDB,"Fatih Tekke","46","fatihtekke",password,11,7);
		Manager manager12 = new Manager(managerDB,"Bulent Uygun","53","bulentuygun",password,12,8);
		Manager manager13 = new Manager(managerDB,"Sami Ugurlu","47","samiugurlu",password,13,6);
		Manager manager14 = new Manager(managerDB,"Aleksandar Stanojevic","50","aleksandr",password,14,6);
		Manager manager15 = new Manager(managerDB,"Selcuk Inan","39","selcukinan",password,15,3);
		Manager manager16 = new Manager(managerDB,"Ozhan Pulat","39","ozhanpulat",password,16,5);
		Manager manager17 = new Manager(managerDB,"Pablo Batalla","40","pablobatalla",password,17,7);
		Manager manager18 = new Manager(managerDB,"Tuncay Sanli","42","tuncaysanli",password,18,6);
		Manager manager19 = new Manager(managerDB, "Fikret Öztürk", "40", "fiko", password, 19, 4);
	}
}