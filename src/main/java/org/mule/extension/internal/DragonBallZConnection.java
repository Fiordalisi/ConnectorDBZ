package org.mule.extension.internal;


import org.mule.extension.api.Zwarrior;


import java.util.HashMap;

import java.util.Map;

/**
 * This class represents an extension connection just as example (there is no real connection with anything here c:).
 */
public final class DragonBallZConnection {

  private final String id;

  private Map<Integer, Zwarrior> map = new HashMap<>();

  public DragonBallZConnection(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public Map<Integer, Zwarrior> getMap() {
    return map;
  }

  public void invalidate() {
    // do something to invalidate this connection!
  }
}
