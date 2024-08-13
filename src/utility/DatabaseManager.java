package utility;

import entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DatabaseManager<T extends BaseEntity> implements ICRUD<T> {

    protected ArrayList<T> veriListesi = new ArrayList<>();

    @Override
    public Optional<T> save(T t) {
        if (veriListesi.add(t)) {
            return Optional.ofNullable(t);
        }
            return Optional.empty();
    }

    @Override
    public List<T> saveAll(List<T> t) {
        if (veriListesi.addAll(t)) {
            return t;
        } else {
            return null;
        }
    }

    @Override
    public Optional<T> update(T t) {
        int index = veriListesi.indexOf(t);
        return Optional.ofNullable(veriListesi.set(index, t));
    }

    @Override
    public List<T> findAll() {
        return veriListesi;
    }

    @Override
    public Optional<T> findByID(int id) {
        for (BaseEntity entity : veriListesi ){
            if(entity.getId() == id){
                return Optional.of((T) entity);
            }
        }
        return Optional.empty();
    }
}