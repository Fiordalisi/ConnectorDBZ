package org.mule.extension;

import org.junit.Before;
import org.junit.Test;
import org.mule.extension.api.Zwarrior;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mule.extension.TestDataBuilder.*;


import static org.mule.extension.TestDataBuilder.generateZWarrior;

public class DBZGetWarriorTestsCases extends AbstractTestCases{

/*    @Before
    public void setUp() throws  Exception{
        executeCreate(generateZWarrior("vegeta", 100));
        executeCreate(generateZWarrior("Goku", 200));
    }*/

    @Test
    public void executeGetWarrior()throws  Exception{


        assertThat( executeGet().getNombre(), is(generateZWarrior("Goku", 200).getNombre()));

    }


}
