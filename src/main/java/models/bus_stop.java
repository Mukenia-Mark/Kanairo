package models;

import java.util.ArrayList;
import java.util.Objects;

public class bus_stop {
  private String bus_sacco_name;
  private String location;
  private int cost;
  
  public bus_stop(String bus_sacco_name, String location, int cost) {
    this.bus_sacco_name = bus_sacco_name;
    this.location = location;
    this.cost = cost;
  }
  
  public String getBus_sacco_name() {
    return bus_sacco_name;
  }
  
  public void setBus_sacco_name(String bus_sacco_name) {
    this.bus_sacco_name = bus_sacco_name;
  }
  
  public String getLocation() {
    return location;
  }
  
  public void setLocation(String location) {
    this.location = location;
  }
  
  public int getCost() {
    return cost;
  }
  
  public void setCost(int cost) {
    this.cost = cost;
  }
  
  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    bus_stop bus_stop = (bus_stop) o;
    return cost == bus_stop.cost && Objects.equals(bus_sacco_name, bus_stop.bus_sacco_name) &&
      Objects.equals(location, bus_stop.location);
  }
  
  @Override public int hashCode() {
    return Objects.hash(bus_sacco_name, location, cost);
  }
}
