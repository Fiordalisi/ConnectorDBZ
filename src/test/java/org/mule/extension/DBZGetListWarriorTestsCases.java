package org.mule.extension;

import org.junit.Test;
import org.mule.extension.api.Zwarrior;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mule.extension.TestDataBuilder.*;

public class DBZGetListWarriorTestsCases extends  AbstractTestCases{

    @Test
    public void getList() throws Exception{
        ArrayList<Zwarrior> warList = new ArrayList<Zwarrior>();
        warList.add(generateZWarrior("vegeta", 100));
        executeCreate(generateZWarrior("vegeta", 100));
      /*  assertThat(addWarriorInList(executeGetList(),generateZWarrior("vegeta", 100)).size(),is(warList.size()));*/
        assertThat(executeGetList().size(),is(warList.size()));
    }
}
