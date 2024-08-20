package entities;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
    
    
    protected Integer id;
    public Integer getId() {
        return id;
    }
}