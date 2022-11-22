package repository;

import model.Atm;

import java.util.ArrayList;
import java.util.List;

public class AtmRepository {
    List<Atm> atmList = new ArrayList<>();

    public AtmRepository(){
        atmList.add(new Atm("Центральный"));
        atmList.add(new Atm("Южный"));
        atmList.add(new Atm("Пролетарский"));
        atmList.add(new Atm("Московский"));
        atmList.add(new Atm("Заволжский"));
    }

    public Atm getAtmById(int id){
        return atmList.get(id);
    }
}
