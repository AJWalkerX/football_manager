package entities;

import databases.ManagerDB;
import models.DatabaseModel;
import utility.FileIOWriter;

public class Manager extends Person{

    private String username;
    private String password;
    private Integer experience; //between 1-10
    private Integer teamId;


    public Manager(DatabaseModel databaseModel){
        super.id = databaseModel.managerDB.findAll().size()+1;
        databaseModel.managerDB.save(this);
        FileIOWriter.writeManagerToBin(databaseModel);
    }
//ManagerDB managerDB, String name, String age,String username,String password, Integer teamID, Integer experience
    public Manager(DatabaseModel databaseModel, String name, String age,String username,String password, Integer teamId, Integer experience) {
        super.id= databaseModel.managerDB.findAll().size()+1;
        super.name=name;
        super.age=age;
        this.username=username;
        this.password=password;
        this.teamId=teamId;
        this.experience=experience;
        databaseModel.managerDB.save(this);
        FileIOWriter.writeManagerToBin(databaseModel);

    }

    {
        this.teamId = -1;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }



    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }


    @Override
    public String toString() {
        return "Manager{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age='" + getAge() + '\'' +
                ", experience=" + getExperience() +
                ", teamId=" + getTeamId() +
                '}';
    }
}
