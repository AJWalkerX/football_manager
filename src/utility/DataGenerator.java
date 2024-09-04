package utility;

import entities.*;
import models.DatabaseModel;

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

    public static void generateRandomPlayers(DatabaseModel databaseModel) {
        Random random = new Random();
        int teamId = 1;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 11; j++) {
                Player player = new Player(databaseModel);
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
                player.setTeamId(teamId);

            }
            teamId++;
        }
    }

    public static void generateStats(DatabaseModel databaseModel){

        for(int i =1;i<=20;i++){
           new Stats(databaseModel,1,i);
        }
    }

    public static void generateTeams(DatabaseModel databaseModel) {

        Team team1 = new Team(databaseModel, "Fenerbahce", 252_400_000L);
        Team team2 = new Team(databaseModel, "Galatasaray", 210_500_000L);
        Team team3 = new Team(databaseModel, "Besiktas", 142_530_000L);
        Team team4 = new Team(databaseModel, "Trabzonspor", 98_630_000L);
        Team team5 = new Team(databaseModel, "Kocaelispor", 45_000_000L);
        Team team6 = new Team(databaseModel, "Caykur Rizespor", 32_750_000L);
        Team team7 = new Team(databaseModel, "Samsunspor", 31_700_000L);
        Team team8 = new Team(databaseModel, "Antalyaspor", 23_680_000L);
        Team team9 = new Team(databaseModel, "Goztepe", 15_330_000L);
        Team team10 = new Team(databaseModel, "Adana Demirspor", 23_400_000L);
        Team team11 = new Team(databaseModel, "Alanyaspor", 22_460_000L);
        Team team12 = new Team(databaseModel, "Sivasspor", 20_780_000L);
        Team team13 = new Team(databaseModel, "Kasimpasa", 20_450_000L);
        Team team14 = new Team(databaseModel, "Konyaspor", 20_360_000L);
        Team team15 = new Team(databaseModel, "Gaziantepspor", 18_180_000L);
        Team team16 = new Team(databaseModel, "Hatayspor", 17_980_000L);
        Team team17 = new Team(databaseModel, "Bursaspor", 15_300_000L);
        Team team18 = new Team(databaseModel, "Sakaryaspor", 12_750_000L);
        Team team19 = new Team(databaseModel, "Sipay Bodrum FK", 20_710_000L);
        Team team20 = new Team(databaseModel, "BAY", 0L);
    }

    public static void generateStadiums(DatabaseModel databaseModel) {
        new Stadium(databaseModel, "Ülker Stadyumu Fenerbahçe Şükrü Saracoğlu Spor Kompleksi", "İstanbul", 50609);
        new Stadium(databaseModel, "Toki Arena", "İstanbul", 52500);
        new Stadium(databaseModel, "Vodafone Park", "İstanbul", 41758);
        new Stadium(databaseModel, "Şenol Güneş Spor Kompleksi", "Trabzon", 40661);
        new Stadium(databaseModel, "Izmit IsmetPaşa Stadyumu", "Kocaeli", 34829);
        new Stadium(databaseModel, "Çaykur Didi Stadyumu", "Rize", 15300);
        new Stadium(databaseModel, "Samsun Stadyumu", "Samsun", 33000);
        new Stadium(databaseModel, "Antalya Stadyumu", "Antalya", 33000);
        new Stadium(databaseModel, "Göztepe Gürsel Aksel Stadyumu", "İzmir", 20500);
        new Stadium(databaseModel, "Adana Stadyumu", "Adana", 33000);
        new Stadium(databaseModel, "Bahçeşehir Okulları Stadyumu", "Antalya", 10500);
        new Stadium(databaseModel, "Sivas 4 Eylül Stadyumu", "Sivas", 27182);
        new Stadium(databaseModel, "Kasımpaşa Stadyumu", "İstanbul", 14000);
        new Stadium(databaseModel, "Konya Büyükşehir Stadyumu", "Konya", 42000);
        new Stadium(databaseModel, "Kalyon Stadyumu", "Gaziantep", 33500);
        new Stadium(databaseModel, "Hatay Stadyumu", "Hatay", 25000);
        new Stadium(databaseModel, "Timsah Arena", "Bursa", 32325);
        new Stadium(databaseModel, "Sakarya Atatürk Stadyumu", "Sakarya", 27569);
        new Stadium(databaseModel, "Bodrum Belediyesi Bodrumspor Stadyumu", "Muğla", 5000);


    }
    public static void generateLeagues(DatabaseModel databaseModel) {
        ArrayList<Integer> trSuperLeagueArrayList =
                new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

        League turkishSuperLeague =
                new League(databaseModel, "Turkish Super League", ERegion.TURKIYE, EDivision.SUPER_LIG_TR, "2024-2025", trSuperLeagueArrayList, LocalDate.parse("2024-08-09"));
    }

    public static void generateManagers(DatabaseModel databaseModel) {
        final String password = "123456";
        Manager manager1 = new Manager(databaseModel, "Jose Mourinho", "61", "josemourinho", password, 1, 10);
        Manager manager2 = new Manager(databaseModel, "Okan Buruk", "50", "okanburuk", password, 2, 3);
        Manager manager3 = new Manager(databaseModel, "Giovanni Van Brockhorst", "49", "giovanni", password, 3, 8);
        Manager manager4 = new Manager(databaseModel, "Abdullah Avci", "61", "abdullahavci", password, 4, 4);
        Manager manager5 = new Manager(databaseModel, "Ertugrul Saglam", "54", "ertugrulsaglam", password, 5, 7);
        Manager manager6 = new Manager(databaseModel, "Ilhan Palut", "47", "ilhanpalut", password, 6, 7);
        Manager manager7 = new Manager(databaseModel, "Thoman Reis", "46", "thomanreis", password, 7, 7);
        Manager manager8 = new Manager(databaseModel, "Alex De Souza", "46", "alexdesouza", password, 8, 8);
        Manager manager9 = new Manager(databaseModel, "Stanimir Stoilov", "57", "stanimirstoilov", password, 9, 6);
        Manager manager10 = new Manager(databaseModel, "Michael Valkanis", "49", "michaelvalkanis", password, 10, 6);
        Manager manager11 = new Manager(databaseModel, "Fatih Tekke", "46", "fatihtekke", password, 11, 7);
        Manager manager12 = new Manager(databaseModel, "Bulent Uygun", "53", "bulentuygun", password, 12, 8);
        Manager manager13 = new Manager(databaseModel, "Sami Ugurlu", "47", "samiugurlu", password, 13, 6);
        Manager manager14 = new Manager(databaseModel, "Aleksandar Stanojevic", "50", "aleksandr", password, 14, 6);
        Manager manager15 = new Manager(databaseModel, "Selcuk Inan", "39", "selcukinan", password, 15, 3);
        Manager manager16 = new Manager(databaseModel, "Ozhan Pulat", "39", "ozhanpulat", password, 16, 5);
        Manager manager17 = new Manager(databaseModel, "Pablo Batalla", "40", "pablobatalla", password, 17, 7);
        Manager manager18 = new Manager(databaseModel, "Tuncay Sanli", "42", "tuncaysanli", password, 18, 6);
        Manager manager19 = new Manager(databaseModel, "Fikret Öztürk", "40", "fiko", password, 19, 4);
    }




    public static Map<Integer, List<Match>> setDatestoMatches(League league, List<Match> matches) {


        LocalDate matchDate = league.getBEGINNING_OF_SEASON();

        int totalWeek = (league.getTeamIdList().size() - 1) * 2;
        int matchesPerWeek = league.getTeamIdList().size() / 2;
        int matchIndex = 0;

        for (int i = 0; i < totalWeek; i++) {
            for (int j = 0; j < matchesPerWeek; j++) {
                switch (j) {
                    case 0, 1:
                        matches.get(matchIndex++).setMatchDate(matchDate);
                        break;
                    case 2, 3, 4:
                        matches.get(matchIndex++).setMatchDate(matchDate.plusDays(1));
                        break;
                    case 5, 6, 7:
                        matches.get(matchIndex++).setMatchDate(matchDate.plusDays(2));
                        break;
                    case 8, 9:
                        matches.get(matchIndex++).setMatchDate(matchDate.plusDays(3));
                        break;
                }
            }
            matchDate = matchDate.plusDays(7);
        }
        return null;
    }

    public static List<Integer[]> generateFixtureList(int teamCount) {


        List<Integer[]> fixture = new ArrayList<>();

        // Her takımın birbirleriyle iki kez karşılaşacağı fikstürü oluşturuyoruz
        for (int i = 0; i < teamCount - 1; i++) {
            for (int j = 0; j < teamCount / 2; j++) {
                int home = (i + j) % (teamCount - 1);
                int away = (teamCount - 1 - j + i) % (teamCount - 1);
                if (j == 0) {
                    away = teamCount - 1;
                }
                fixture.add(new Integer[]{home, away});
            }
        }

        // İkinci yarı için ters maçları ekliyoruz
        List<Integer[]> reversedFixture = new ArrayList<>();
        for (Integer[] match : fixture) {
            reversedFixture.add(new Integer[]{match[1], match[0]});
        }
        fixture.addAll(reversedFixture);


        //Aynı takım üst üste sürekli ev sahibi olmasın diye
        List<Integer[]> temp = List.copyOf(fixture);

        for(int i =0;i<teamCount-1;i++){
            for(int j=0;j<teamCount/2;j++ ){
                if(i%2==0){
                    fixture.set(j+(i*10),temp.get(190+j+(i*10)));
                    fixture.set(190+j+(i*10), temp.get(j+(i*10)));
                }
            }
        }
        return fixture;
    }
    public static List<Match> setIDToMatches(DatabaseModel databaseModel, List<Integer[]> fixtureList,League league) {
        //maçlara id atar.
        List<Integer> teamIDlist = league.getTeamIdList();
        List<Match> matchesList = new ArrayList<>();

        for (Integer[] matches : fixtureList) {
            Match match = new Match(databaseModel);
            if (matches[0] < teamIDlist.size() && matches[1] < teamIDlist.size()) {
                match.setHomeTeamId(teamIDlist.get(matches[0]));
                match.setAwayTeamId(teamIDlist.get(matches[1]));
                matchesList.add(match);
            }
        }
        return matchesList;
    }
        //maçlar için 3 ayrı metod
    public static void generateMatchesAndFixture(DatabaseModel databaseModel,League league){
        int teamNums = league.getTeamIdList().size();
        int matchesPerWeek = teamNums/2;

        List<Integer[]> fixtureListWithID = generateFixtureList(teamNums);

        List<Match> matches = setIDToMatches(databaseModel, fixtureListWithID, league);//Mac nesnesi yarattigimiz yer.

        setDatestoMatches(league, matches);


    }




}