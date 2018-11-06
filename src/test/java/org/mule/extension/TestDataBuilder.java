package org.mule.extension;

import org.mule.extension.api.Zwarrior;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuilder {

    public static final Object NULL = null;

    public static final Zwarrior VEGETA = generateZWarrior("vegeta", 100);
    public static final Zwarrior GOKU = generateZWarrior("goku", 200);



    public static Zwarrior generateZWarrior(String name, int id){
        Zwarrior zWarrior = new Zwarrior();
        zWarrior.setId(id);
        zWarrior.setNombre(name);
        return zWarrior;
    }






}
