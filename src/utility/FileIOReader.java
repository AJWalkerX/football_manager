package utility;


import entities.*;
import models.DatabaseModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class FileIOReader {

    private static final File
            DIRECTORY = new File("C:\\Users\\AJWal\\OneDrive\\Masaüstü\\Desktop\\BilgeAdam\\WorkFlows\\projects" +
                                         "\\futbol_manager\\file_io");



    public static void readPlayerFromBin(DatabaseModel databaseModel) {
        File inputFile = new File(DIRECTORY, "playerDB.bin");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            databaseModel.playerDB.saveAll((List<Player>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readLeagueFromBin(DatabaseModel databaseModel) {
        File inputFile = new File(DIRECTORY, "leagueDB.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            databaseModel.leagueDB.saveAll((List<League>) ois.readObject());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readTeamFromBin(DatabaseModel databaseModel) {
        File inputFile = new File(DIRECTORY, "teamDB.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            databaseModel.teamDB.saveAll((List<Team>) ois.readObject());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readStadiumFromBin(DatabaseModel databaseModel) {
        File inputFile = new File(DIRECTORY, "stadiumDB.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            databaseModel.stadiumDB.saveAll((List<Stadium>) ois.readObject());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readManagerFromBin(DatabaseModel databaseModel) {
        File inputFile = new File(DIRECTORY, "managerDB.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            databaseModel.managerDB.saveAll((List<Manager>) ois.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void readMatchFromBin(DatabaseModel databaseModel) {
        File inputFile = new File(DIRECTORY, "matchDB.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            databaseModel.matchDB.saveAll((List<Match>) ois.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readStatsFromBin(DatabaseModel databaseModel) {
        File inputFile = new File(DIRECTORY, "statsDB.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            databaseModel.statsDB.saveAll((List<Stats>) ois.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void readMatchStatsFromBin(DatabaseModel databaseModel) {
        File inputFile = new File(DIRECTORY, "matchStatsDB.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            databaseModel.matchStatsDB.saveAll((List<MatchStats>) ois.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }







        public static void readAllEntities(DatabaseModel databaseModel){
            //oyuncular icin
            File inputFilePlayer = new File(DIRECTORY, "playerDB.bin");
            if(inputFilePlayer.exists()){
                readPlayerFromBin(databaseModel);
            }else{
                DataGenerator.generateRandomPlayers(databaseModel);
//                readPlayerFromBin(playerDB);
            }
            //ligler icin
            File inputFileLeague = new File(DIRECTORY, "leagueDB.bin");
            if(inputFileLeague.exists()){
                readLeagueFromBin(databaseModel);
            }else{
                DataGenerator.generateLeagues(databaseModel);
//                readLeagueFromBin(leagueDB);
            }


            //takimlar icin
            File inputFileTeam = new File(DIRECTORY, "teamDB.bin");
            if(inputFileTeam.exists()){
                readTeamFromBin(databaseModel);
            }else{
                DataGenerator.generateTeams(databaseModel);
//                readTeamFromBin(teamDB);
            }

            //menajerler icin
            File inputFileManager = new File(DIRECTORY, "managerDB.bin");
            if(inputFileManager.exists()){
                readManagerFromBin(databaseModel);
            }else{
                DataGenerator.generateManagers(databaseModel);

            }

            //stadyumlar icin
            File inputFileStadium = new File(DIRECTORY, "stadiumDB.bin");
            if(inputFileStadium.exists()){
                readStadiumFromBin(databaseModel);
            }else{
                DataGenerator.generateStadiums(databaseModel);

            }

            //maçlar için

            File inputFileMatch = new File(DIRECTORY, "matchDB.bin");
            if(inputFileMatch.exists()){
                readMatchFromBin(databaseModel);
            }else{
                DataGenerator.generateMatchesAndFixture(databaseModel, databaseModel.leagueDB.findAll().get(0));

            }

            //istatistikler için

            File inputFileStat = new File(DIRECTORY, "statsDB.bin");
            if(inputFileStat.exists()){
                readStatsFromBin(databaseModel);
            }else{
                DataGenerator.generateStats(databaseModel);

            }

            File inputFileMatchStats = new File(DIRECTORY, "matchStatsDB.bin");
            if(inputFileMatchStats.exists()){
                readMatchStatsFromBin(databaseModel);
            }else{


            }






        }




}