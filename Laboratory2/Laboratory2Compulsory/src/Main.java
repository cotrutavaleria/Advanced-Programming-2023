/**
 * Cotruță Valeria, 2A1
 */

import Compulsory.Location;
import Compulsory.Road;

public class Main {
    public static void main(String[] args) {
        Location location1 = new Location("Iasi");
        location1.setType(Location.locationType.CITY);
        location1.setXSetY(47.158455, 27.601442);

        Location location2 = new Location("Bucuresti");
        location2.setType(Location.locationType.CITY);
        location2.setXSetY(44.439663, 26.096306);

        Location location3 = new Location("Brasov");
        location3.setType(Location.locationType.CITY);
        location3.setXSetY(45.657974, 25.601198);

        Road road1 = new Road(location1, location2);//Iasi, Bucuresti
        road1.setType(Road.roadType.HIGHWAYS);
        road1.setSpeedLimit(69);
        road1.setLength(388.6);

        Road road2 = new Road(location1, location3);//Iasi, Brasov
        road2.setType(Road.roadType.COUNTRY);
        road2.setSpeedLimit(66);
        road2.setLength(323.4);

        Road road3 = new Road(location3, location2);//Brasov, Bucuresti
        road3.setType(Road.roadType.EXPRESS);
        road3.setSpeedLimit(70);
        road3.setLength(168);

        System.out.println(location1);
        System.out.println(location2);
        System.out.println(location3);
        System.out.println(road1);
        System.out.println(road2);
        System.out.println(road3);

    }
}