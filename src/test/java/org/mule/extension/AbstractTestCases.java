package org.mule.extension;

import org.mule.extension.api.Zwarrior;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;

import java.util.List;

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
        Zwarrior zwarriorP = ((Zwarrior) flowRunner("crearZwarriorFlow")
                .withPayload(zwarrior).run()
                .getMessage()
                .getPayload()
                .getValue());
        return zwarriorP;
    }

    protected Zwarrior executeGet() throws Exception {

        executeCreate(generateZWarrior("vegeta", 100));
        executeCreate(generateZWarrior("goku", 200));
        Zwarrior zwarriorP = ((Zwarrior) flowRunner("getObjectwarriorFlow").run()
                .getMessage()
                .getPayload()
                .getValue());

        return zwarriorP;
    }

    protected  List<Zwarrior> executeGetList() throws  Exception{
        List<Zwarrior> list = ((List<Zwarrior>) flowRunner("getObjectwarriorFlow").run()
                .getMessage()
                .getPayload()
                .getValue());
        return list;
    }
}
