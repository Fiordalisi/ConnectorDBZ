package org.mule.extension;

import org.junit.Before;
import org.junit.Test;

import static org.mule.extension.TestDataBuilder.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DBZDeleteWarriorTestsCases extends AbstractTestCases{

    @Before
    public void setUp() throws Exception {

        executeCreate(GOKU);
        executeCreate(GOHAN);
        executeCreate(MAJIN_BOO);
    }

    @Test
    public void deleteWarriors() throws  Exception{
        executeDelete(90);
        assertThat(executeGetMapWarriors().size(),is(2));
    }
}
