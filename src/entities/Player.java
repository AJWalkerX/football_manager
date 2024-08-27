package entities;

import databases.PlayerDB;
import models.DatabaseModel;
import utility.EPosition;
import utility.FileIOWriter;


public class Player extends Person{

    static Integer playerIdCounter = 0;

    private EPosition position;
    private Integer skillLevel; //1-10 arasi olacak.
    private Long value; //degeri
    private Integer teamId;

    public Player(DatabaseModel databaseModel) {
        super.id =databaseModel.playerDB.findAll().size()+1;
        databaseModel.playerDB.save(this);
        FileIOWriter.writePlayerToBin(databaseModel);
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }



    public EPosition getPosition() {
        return position;
    }

    public void setPosition(EPosition position) {
        this.position = position;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age='" + getAge() + '\'' +
                ", teamId=" + getTeamId() +
                ", position=" + getPosition() +
                ", skillLevel=" + getSkillLevel() +
                ", value=" + getValue() +
                '}';
    }
}
