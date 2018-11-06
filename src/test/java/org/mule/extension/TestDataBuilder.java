package org.mule.extension;

import org.mule.extension.api.Zwarrior;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuilder {

    public static final Object NULL = null;

    public static final Zwarrior VEGETA = generateZWarrior("Vegeta", 100);
    public static final Zwarrior GOKU = generateZWarrior("Goku", 200);



    public static Zwarrior generateZWarrior(String name, int id){
        Zwarrior zWarrior = new Zwarrior();
        zWarrior.setId(id);
        zWarrior.setNombre(name);
        return zWarrior;
    }

    public static List<Zwarrior> addWarriorInList(List<Zwarrior> list, Zwarrior warrior){
        list = new ArrayList<Zwarrior>();
        list.add(warrior);
        return list;
    }





}
