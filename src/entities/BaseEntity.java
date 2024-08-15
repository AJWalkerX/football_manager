package entities;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
    
    
    protected int id;
    public int getId() {
        return id;
    }
}