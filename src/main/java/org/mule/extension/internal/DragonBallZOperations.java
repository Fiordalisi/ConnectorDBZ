package org.mule.extension.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.extension.api.Zwarrior;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;

import java.util.Map;


/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class DragonBallZOperations {


    /**
     * Example of an operation that uses the configuration and a connection instance to perform some action.
     */
    @MediaType(value = ANY, strict = false)
    public String retrieveInfo(@Config DragonBallZConfiguration configuration, @Connection DragonBallZConnection connection) {
        return "Using Configuration [" + configuration.getConfigId() + "] with Connection id [" + connection.getId() + "]";
    }

    /**
     * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
     */
    @MediaType(value = ANY, strict = false)
    public String sayHi(String person) {
        return buildHelloMessage(person);
    }





    @MediaType(value = ANY, strict = false)
    public Zwarrior createZwarrior(@Content Zwarrior warrior, @Connection DragonBallZConnection connection) {
        connection.getMap().put(warrior.getId(),warrior);
        return connection.getMap().get(warrior.getId());
    }



    @MediaType(value = ANY, strict = false)
    public void modifyWarrior(int id, @Content Zwarrior warrior, @Connection DragonBallZConnection connection){
        connection.getMap().get(id).setNombre(warrior.getNombre());
    }



    @MediaType(value = ANY, strict = false)
    public void deleteWarrior(@Content int id, @Connection DragonBallZConnection connection){
        connection.getMap().remove(id);
    }


    @MediaType(value = ANY, strict = false)
    public Map<Integer, Zwarrior> getMapWarriors(@Connection DragonBallZConnection connection){
        return connection.getMap();
    }


    @MediaType(value = ANY, strict = false)
    public Zwarrior getObjectwarrior(@Content int id, @Connection DragonBallZConnection connection){

        return connection.getMap().get(id);
    }
    /**
     * Private Methods are not exposed as operations
     */
    private String buildHelloMessage(String person) {
        return "Hello " + person + "!!!";
    }
}
