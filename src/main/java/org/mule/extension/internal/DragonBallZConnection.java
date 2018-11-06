package org.mule.extension.internal;


import org.mule.extension.api.Zwarrior;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an extension connection just as example (there is no real connection with anything here c:).
 */
public final class DragonBallZConnection {

  private final String id;

  private List<Zwarrior> lista = new ArrayList<Zwarrior>();

  public DragonBallZConnection(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public List<Zwarrior> getLista(){
    return this.lista;
  }

  public void invalidate() {
    // do something to invalidate this connection!
  }
}
