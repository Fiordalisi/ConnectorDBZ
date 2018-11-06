package org.mule.extension;

import org.mule.extension.api.Zwarrior;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;

import static org.mule.extension.TestDataBuilder.generateZWarrior;

public abstract class AbstractTestCases extends MuleArtifactFunctionalTestCase {
    private static final String FLOW_CONFIG_LOCATION = "src/test/resources/automation-test-flows.xml";

    @Override
    public int getTestTimeoutSecs() {
        return 999999;
    }

    @Override
    protected String[] getConfigFiles() {
        return new String[] {
                FLOW_CONFIG_LOCATION
        };
    }


   protected Zwarrior executeCreate(Zwarrior zwarrior) throws Exception{
       Zwarrior zwarriorP = ((Zwarrior) flowRunner("crearZwarriorFlow")
               .withPayload(zwarrior).run()
               .getMessage()
               .getPayload()
               .getValue());
       return zwarriorP;
   }
}
