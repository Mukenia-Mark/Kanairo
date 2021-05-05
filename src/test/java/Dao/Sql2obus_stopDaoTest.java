package Dao;

import models.bus_stop;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class Sql2obus_stopDaoTest {
  
  private static Sql2obus_stopDao bus_stopDao;
  private static Connection conn;
  
  @BeforeClass
  public static void setUp() throws Exception {
    String connectionString = "jdbc:postgresql://localhost:5432/bus_stop_test";
    Sql2o sql2o = new Sql2o(connectionString, "", "");
    bus_stopDao = new Sql2obus_stopDao(sql2o);
    conn = sql2o.open();
  }
  
  @After
  public void tearDown() throws Exception {
    System.out.println("clearing database");
    bus_stopDao.clearAllLocations();
  }
  
  @AfterClass
  public static void shutDown() throws Exception{
    conn.close();
    System.out.println("connection closed");
  }
  
  @Test
  public void existingBusStopsCanBeFoundByLocation() throws Exception {
    bus_stop busStop = setupNewBus_Stop();
    bus_stopDao.add(busStop);
    bus_stop foundbus_stop = bus_stopDao.findByLocation(busStop.getLocation());
    assertEquals(busStop, foundbus_stop);
  }
  
  @Test
  public void addedBusStopsAreReturnedFromGetAll() throws Exception {
    bus_stop busStop = setupNewBus_Stop();
    bus_stopDao.add(busStop);
    assertEquals(1, bus_stopDao.getAll().size());
  }
  
  @Test
  public void noBusStopsReturnsEmptyList() throws Exception {
    assertEquals(0, bus_stopDao.getAll().size());
  }
  
  @Test
  public void updateChangesBusStopContent() throws Exception {
    String sacco = "Embasava";
    String location = "Kiambu";
    int cost = 70;
    bus_stop busStop = new bus_stop (sacco, location, cost);
    bus_stopDao.add(busStop);
    bus_stopDao.update(busStop.getLocation(),"Runda",70);
    bus_stop updatedbus_stop = bus_stopDao.findByLocation(busStop.getLocation());
    assertNotEquals(sacco, updatedbus_stop.getBus_sacco_name());
  }
  
  @Test
  public void deleteByLocationDeletesCorrectCategory() throws Exception {
    bus_stop busStop = setupNewBus_Stop();
    bus_stopDao.add(busStop);
    bus_stopDao.deleteByLocation(busStop.getLocation());
    assertEquals(0, bus_stopDao.getAll().size());
  }
  
  @Test
  public void clearAllClearsAllLocations() throws Exception {
    bus_stop busStop = setupNewBus_Stop();
    bus_stop otherbus_stop = new bus_stop("Embasava", "Kiambu",70);
    bus_stopDao.add(busStop);
    bus_stopDao.add(otherbus_stop);
    int daoSize = bus_stopDao.getAll().size();
    bus_stopDao.clearAllLocations();
    assertTrue(daoSize > 0 && daoSize > bus_stopDao.getAll().size());
  }
  
  
  public bus_stop setupNewBus_Stop(){
    return new bus_stop("Embasava","Kaimbu",70);
  }
}