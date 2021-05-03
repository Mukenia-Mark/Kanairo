import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    private Locations newLocation() {
        return new Locations("KBS","KenCom",50);
    }

    @Test
    public void locations_canInstantiateCorrectly_boolean() {
        Locations locations = newLocation();
        assertTrue(locations instanceof Locations);
    }

    @Test
    public void locations_canGetBusNameCorrectly_KBS() {
        Locations locations = newLocation();
        assertEquals("KBS",locations.getBusName());
    }

    @Test
    public void locations_canGetBusStageCorrectly_KenCom() {
        Locations locations = newLocation();
        assertEquals("KenCom",locations.getBusStage());
    }

    @Test
    public void locations_canGetCostCorrectly_60() {
        Locations locations = newLocation();
        assertEquals(50,locations.getCost());
    }
}