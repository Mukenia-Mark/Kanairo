package Dao;

import models.bus_stop;
import java.util.List;

public interface bus_stopDao {
  //List
  List<bus_stop> getAll();
  
  //Create
  void add (bus_stop busStop);
  
  //Read
  bus_stop findByLocation(String location);
  
  //Update
  void update(String bus_sacco_name, String location, int price);
  
  //Delete
  void deleteByLocation(String location);
  void clearAllLocations();
  
}
