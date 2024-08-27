package entities;

import models.DatabaseModel;
import utility.FileIOWriter;

public class Stadium extends BaseEntity{

    private String name;
    private String location;
    private Integer capacity;

    public Stadium(DatabaseModel databaseModel,String name, String location, Integer capacity) {
        super.id=  databaseModel.stadiumDB.findAll().size()+1;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        databaseModel.stadiumDB.save(this);
        FileIOWriter.writeStadiumToBin(databaseModel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Stadium{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", capacity=" + getCapacity() +
                '}';
    }
}
