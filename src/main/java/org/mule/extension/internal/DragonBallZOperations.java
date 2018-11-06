package org.mule.extension.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.extension.api.Zwarrior;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;


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
    public Zwarrior crearZwarrior(@Content Zwarrior warrior, @Connection DragonBallZConnection connection) {

        for (int i = 0; i < connection.getLista().size(); i++) {
            if (connection.getLista().get(i).getNombre() == warrior.getNombre())
                return null;
        }
        Zwarrior z = new Zwarrior();
        z.setNombre(warrior.getNombre());
        z.setId(connection.getLista().size()+1);
        connection.getLista().add(z);
        return warrior;
    }



    @MediaType(value = ANY, strict = false)
    public void modifyWarrior(int id, String nvoNombre, @Connection DragonBallZConnection connection){
        for(int i = 0; i < connection.getLista().size(); i++){
            if(connection.getLista().get(i).getId() == id)
                connection.getLista().get(i).setNombre(nvoNombre);
        }
    }

    @MediaType(value = ANY, strict = false)
    public String listZwarrior(@Connection DragonBallZConnection connection) {
        String warriors = "";
        for (int i = 0; i < connection.getLista().size(); i++) {
            warriors += connection.getLista().get(i).getNombre() + ", ";
        }
        return "Los Warriors son: " + warriors.substring(0,warriors.length()-2);
    }

    @MediaType(value = ANY, strict = false)
    public void deleteWarrior(int id, @Connection DragonBallZConnection connection){
        for (int i = 0; i < connection.getLista().size(); i++) {
            if (connection.getLista().get(i).getId() == id){
                connection.getLista().remove(connection.getLista().get(i));
            }
        }
    }


    @MediaType(value = ANY, strict = false)
    public String getZwarrior(String nombre, @Connection DragonBallZConnection connection) {

        for (int i = 0; i < connection.getLista().size(); i++) {
            if (connection.getLista().get(i).getNombre() == nombre)
                return "Se encontro a " + nombre + " con id: " + connection.getLista().get(i).getId();
        }
        return "No se ha encontrado el warrior " + nombre;
    }

    @MediaType(value = ANY, strict = false)
    public Zwarrior getObjectwarrior(int id, @Connection DragonBallZConnection connection){

        for (int i = 0; i < connection.getLista().size(); i++) {
            if (connection.getLista().get(i).getId() == id)
                return connection.getLista().get(i);
        }
        return null;
    }
    /**
     * Private Methods are not exposed as operations
     */
    private String buildHelloMessage(String person) {
        return "Hello " + person + "!!!";
    }
}
