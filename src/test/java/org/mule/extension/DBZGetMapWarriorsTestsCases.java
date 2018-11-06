package org.mule.extension;


import org.junit.Before;
import org.junit.Test;

import static org.mule.extension.TestDataBuilder.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DBZGetMapWarriorsTestsCases extends AbstractTestCases {

    @Before
    public void setUp() throws Exception {

        executeCreate(GOKU);
        executeCreate(GOHAN);
        executeCreate(MAJIN_BOO);
    }

    @Test
    public void getMapWarriors() throws Exception {
        assertThat(executeGetMapWarriors().size(), is(3));
    }

    @Test
    public void createSameWarriors() throws Exception {
        executeCreate(GOKU);
        assertThat(executeGetMapWarriors().size(), is(3));
    }
}
