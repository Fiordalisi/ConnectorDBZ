package org.mule.extension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mule.extension.TestDataBuilder.*;

import org.junit.Test;


public class DBZCreateWarriorTestsCases extends AbstractTestCases {


    protected static final String FLOW_CONFIG_LOCATION = "automation-test-flows.xml";

    /**
     * Specifies the mule config xml with the flows that are going to be executed in the tests, this file lives in the test resources.
     */
    @Override
    protected String getConfigFile() {
        return "automation-test-flows.xml";
    }




    @Test
    public void executeCreateZwarriorOperation() throws Exception {

        assertThat(executeCreate(generateZWarrior("vegeta", 100)).getNombre(),
                is(generateZWarrior("vegeta", 100).getNombre()));
    }


    @Test
    public void createSameWarriors() throws Exception {
        executeCreate(generateZWarrior("vegeta", 100));
        assertThat(executeCreate(generateZWarrior("vegeta", 100)).getNombre(),is(VEGETA.getNombre()));
    }

    @Test
    public void createTwoWarriors() throws Exception{


        assertThat(executeCreate(generateZWarrior("vegeta", 100)).getNombre(),
                is(VEGETA.getNombre()));
        assertThat(executeCreate(generateZWarrior("goku", 200)).getNombre(),
                is(GOKU.getNombre()));
    }





}
