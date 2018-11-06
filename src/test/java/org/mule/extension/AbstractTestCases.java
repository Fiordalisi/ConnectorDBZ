package org.mule.extension;

import org.mule.extension.api.Zwarrior;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mule.extension.TestDataBuilder.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mule.extension.TestDataBuilder.generateZWarrior;

public abstract class AbstractTestCases extends MuleArtifactFunctionalTestCase {
    private static final String FLOW_CONFIG_LOCATION = "src/test/resources/automation-test-flows.xml";

    @Override
    public int getTestTimeoutSecs() {
        return 999999;
    }

    @Override
    protected String[] getConfigFiles() {
        return new String[]{
                FLOW_CONFIG_LOCATION
        };
    }


    protected Zwarrior executeCreate(Zwarrior zwarrior) throws Exception {
        return  ((Zwarrior) flowRunner("crearZwarriorFlow")
                .withPayload(zwarrior).run()
                .getMessage()
                .getPayload()
                .getValue());
    }

    protected Zwarrior executeGet(int id) throws Exception {

        return ((Zwarrior) flowRunner("getObjectwarriorFlow")
                .withPayload(id).run()
                .getMessage()
                .getPayload()
                .getValue());
    }

    protected void executeDelete(int id) throws Exception {

        flowRunner("deleteWarriorFlow")
                .withPayload(id).run()
                .getMessage()
                .getPayload()
                .getValue();

    }

    protected HashMap<Integer,Zwarrior> executeGetMapWarriors() throws  Exception{
        return  ((HashMap<Integer, Zwarrior>) flowRunner("getMapWarrirosFlow").run()
                .getMessage()
                .getPayload()
                .getValue());
    }

    protected  void executeModify(int id, Zwarrior warrior) throws Exception{

        flowRunner("modifyWarriorFlow")
                .withPayload(warrior)
                .withVariable("id", id)
                .run()
                .getMessage()
                .getPayload()
                .getValue();

    }


}
