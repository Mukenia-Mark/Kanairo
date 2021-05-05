

import java.util.Objects;

public class Locations {
    private String location;
    private String busName;
    private String busStage;
    private int cost;


    //constructor
    public Locations(String location, String busStage, String busName, int cost){
        this.location = location;
        this.busName = busName;
        this.busStage = busStage;
        this.cost = cost;
    }

    //getter methods

    public String setLocation() {
        return location;
    }

    public String getLocation() {
        return location;
    }
    public String getBusName() {
        return busName;
    }

    public String getBusStage(){
        return busStage;
    }

    public int getCost() {
        return cost;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locations locations = (Locations) o;
        return cost == locations.cost && busName.equals(locations.busName) && busStage.equals(locations.busStage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(busName, busStage, cost);
    }

}
