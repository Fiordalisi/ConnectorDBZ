package org.mule.extension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mule.extension.TestDataBuilder.*;

import org.junit.Assert;
import org.mule.extension.api.Zwarrior;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.junit.Test;


public class DragonBallZOperationsTestCase extends MuleArtifactFunctionalTestCase {

  /**
   * Specifies the mule config xml with the flows that are going to be executed in the tests, this file lives in the test resources.
   */
  @Override
  protected String getConfigFile() {
    return "test-mule-config.xml";
  }

  @Test
  public void executeSayHiOperation() throws Exception {
    String payloadValue = ((String) flowRunner("sayHiFlow").run()
                                      .getMessage()
                                      .getPayload()
                                      .getValue());
    assertThat(payloadValue, is("Hello Mariano Gonzalez!!!"));
  }


  @Test
  public void executeNoGetZwarriorOperation() throws Exception {

    String payloadValue = ((String) flowRunner("getZwarriorFlow").run()
            .getMessage()
            .getPayload()
            .getValue());
    assertThat(payloadValue, is("No se ha encontrado el warrior Goku"));
  }


  @Test
  public void executeCrearZwarriorOperation() throws Exception {

    Zwarrior zwarrior = ((Zwarrior) flowRunner("crearZwarriorFlow")
            .withPayload(generateZWarrior("vegeta", 100)).run()
            .getMessage()
            .getPayload()
            .getValue());
    assertThat(zwarrior.getNombre(), is(generateZWarrior("vegeta", 100).getNombre()));
  }

  @Test
  public void executeCrearMismoZwarriorOperation() throws Exception {

    flowRunner("crearZwarriorFlow").run();
    String payloadValue = ((String) flowRunner("crearZwarriorFlow").run()
            .getMessage()
            .getPayload()
            .getValue());
    assertThat(payloadValue, is("Ya existe el warrior (?"));
  }

  @Test
  public void executeGetZwarriorOperation() throws Exception {

    flowRunner("crearZwarriorFlow").run();
    String payloadValue = ((String) flowRunner("getZwarriorFlow").run()
            .getMessage()
            .getPayload()
            .getValue());
    assertThat(payloadValue, is("Se encontro a Goku con id: 1"));
  }

 /* @Test
  public void executeGetObjectZwarriorOperation() throws Exception {

        flowRunner("crearZwarriorFlow").run();
    Zwarrior payloadValue = ( (Zwarrior) flowRunner("getObjectwarriorFlow").run().getMessage().getPayload());
    Assert.assertEquals("Goku", payloadValue.getNombre());
    Assert.assertEquals(1, payloadValue.getId());
  }
*/

  @Test
  public void executeListZwarrior() throws Exception{
    flowRunner("crearZwarriorFlow").run();
    flowRunner("crearZwarriorFlow2").run();
    String payloadValue = ((String) flowRunner("listZwarriorFlow")
            .run()
            .getMessage()
            .getPayload()
            .getValue());
    assertThat(payloadValue, is("Los Warriors son: Goku, Gohan"));
  }

  @Test
  public void executeModifyWArriorOperation() throws Exception{
    flowRunner("crearZwarriorFlow").run();
    flowRunner("crearZwarriorFlow2").run();
    flowRunner("crearVegeta").run();
    flowRunner("modifyWarrior").run();
    String payloadValue =  ((String) flowRunner("getGohan").run()
    .getMessage()
    .getPayload()
    .getValue());

    assertThat(payloadValue, is("No se ha encontrado el warrior Gohan"));
  }

  @Test
  public void executeDeleteWarriorOperation() throws  Exception{
    flowRunner("crearZwarriorFlow").run();
    flowRunner("crearZwarriorFlow2").run();
    flowRunner("crearVegeta").run();
    flowRunner("deleteWarriorFlow").run();
    String payloadValue =  ((String) flowRunner("getGohan").run()
            .getMessage()
            .getPayload()
            .getValue());

    assertThat(payloadValue, is("No se ha encontrado el warrior Gohan"));
  }

  @Test
  public void executeRetrieveInfoOperation() throws Exception {
    String payloadValue = ((String) flowRunner("retrieveInfoFlow")
                                      .run()
                                      .getMessage()
                                      .getPayload()
                                      .getValue());
    assertThat(payloadValue, is("Using Configuration [configId] with Connection id [aValue:100]"));
  }


}
