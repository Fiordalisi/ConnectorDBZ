package org.mule.extension;

import org.mule.extension.api.Zwarrior;

public class TestDataBuilder {

    public static Zwarrior generateZWarrior(String name, int id){
        Zwarrior zWarrior = new Zwarrior();
        zWarrior.setId(id);
        zWarrior.setNombre(name);
        return zWarrior;
    }

}
