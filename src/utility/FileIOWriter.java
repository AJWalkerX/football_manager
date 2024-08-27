package utility;

import models.DatabaseModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileIOWriter {

    private static final File DIRECTORY = new File("D:\\Java15Full\\FootballManagerApp\\FileIO");

    public static void writePlayerToBin(DatabaseModel databaseModel) {
        File outputFile = new File(DIRECTORY, "playerDB.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(databaseModel.playerDB.findAll());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeTeamToBin(DatabaseModel databaseModel) {
        File outputFile = new File(DIRECTORY, "teamDB.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(databaseModel.teamDB.findAll());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeLeagueToBin(DatabaseModel databaseModel) {
        File outputFile = new File(DIRECTORY, "leagueDB.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(databaseModel.leagueDB.findAll());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeManagerToBin(DatabaseModel databaseModel) {
        File outputFile = new File(DIRECTORY, "managerDB.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(databaseModel.managerDB.findAll());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeStadiumToBin(DatabaseModel databaseModel) {
        File outputFile = new File(DIRECTORY, "stadiumDB.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(databaseModel.stadiumDB.findAll());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeMatchToBin(DatabaseModel databaseModel){
        File outputFile = new File(DIRECTORY, "matchDB.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(databaseModel.matchDB.findAll());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeStatsToBin(DatabaseModel databaseModel){
        File outputFile = new File(DIRECTORY, "statsDB.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(databaseModel.statsDB.findAll());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeMatchStatsToBin(DatabaseModel databaseModel){
        File outputFile = new File(DIRECTORY, "matchStatsDB.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(databaseModel.matchStatsDB.findAll());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void saveAllEntities(DatabaseModel databaseModel) {
        writePlayerToBin(databaseModel);
        writeTeamToBin(databaseModel);
        writeLeagueToBin(databaseModel);
        writeManagerToBin(databaseModel);
        writeStadiumToBin(databaseModel);
        writeMatchToBin(databaseModel);
        writeStatsToBin(databaseModel);
        writeMatchStatsToBin(databaseModel);
    }
}


