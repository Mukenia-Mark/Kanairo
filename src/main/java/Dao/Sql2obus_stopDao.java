package Dao;

import models.bus_stop;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2obus_stopDao implements bus_stopDao{
  
  private final Sql2o sql2o;
  
  public Sql2obus_stopDao(Sql2o sql2o){
    this.sql2o = sql2o;
  }
  
  @Override public List<bus_stop> getAll() {
    try (Connection con = sql2o.open()) {
      return con.createQuery("SELECT * FROM stops")
        .executeAndFetch(bus_stop.class);
    }
  }
    
      @Override public void add(bus_stop busStop) {
    String sql = "INSERT INTO stops (location) VALUES (:location)";
    try(Connection con = sql2o.open()){
      String location = (String) con.createQuery(sql, true)
        .bind(busStop)
        .executeUpdate()
        .getKey();
      busStop.setLocation(location);
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }
  
  @Override public bus_stop findByLocation(String location) {
    try(Connection con = sql2o.open()){
      return con.createQuery("SELECT * FROM stops WHERE location = :location")
        .addParameter("location", location)
        .executeAndFetchFirst(bus_stop.class);
    }
  }
  
  @Override public void update(String bus_sacco_name, String location, int price) {
    String sql = "UPDATE categories SET bus_sacco_name = :bus_sacco_name WHERE location=:location";
    try(Connection con = sql2o.open()){
      con.createQuery(sql)
        .addParameter("bus_sacco_name", bus_sacco_name)
        .addParameter("location", location)
        .executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }
  
  @Override public void deleteByLocation(String location) {
    String sql = "DELETE from stops WHERE location=:location";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql)
        .addParameter("location", location)
        .executeUpdate();
    } catch (Sql2oException ex){
      System.out.println(ex);
    }
  }
  
  @Override public void clearAllLocations() {
    String sql = "DELETE from stops";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql)
        .executeUpdate();
    } catch (Sql2oException ex){
      System.out.println(ex);
    }
  }
  
  @Override
  public List<bus_stop> getAllBus_Stops(String location) {
    try(Connection con = sql2o.open()){
      return con.createQuery("SELECT * FROM stops WHERE location = :location")
        .addParameter("location", location)
        .executeAndFetch(bus_stop.class);
    }
  }
}
