package ships;

import java.util.ArrayList;
import java.util.List;

public class Harbor {
    private String location;
    private int minDepth;
    private List<Ship> ships;

    public Harbor(String location, int minDepth) {
        this.location = location;
        this.minDepth = minDepth;
        this.ships = new ArrayList<>();
    }
    public String addShip(Ship ship){
        for (Ship ship1 : this.ships) {
            if (ship1.getName().equals(ship.getName())){
                return "Ship with this name already exists!";
            }
        }
        if (ship.getDraft() > this.minDepth){
            return String.format("The ship %s cannot dock due to draft limitations!", ship.getName());
        }
        this.ships.add(ship);
        return String.format("Ship %s added to the harbor.", ship.getName());
    }
    public boolean removeShip(String name){
        for (Ship ship : this.ships) {
            if (ship.getName().equals(name)){
                this.ships.remove(ship);
                return true;
            }
        }
        return false;
    }
    public String getShipsByType(String type){
        List<Ship> shipsByType = new ArrayList<>();
        for (Ship ship : this.ships) {
            if (ship.getType().equals(type)){
                shipsByType.add(ship);
            }
        }
        if (shipsByType.isEmpty()){
            return "There are no ships of the requested type.";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Ships of type %s: ", type));
        for (int i = 0; i < shipsByType.size(); i++) {
            stringBuilder.append(shipsByType.get(i).getName());
            if (i < shipsByType.size() - 1){
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
    public Ship getShipByName(String name){
        for (Ship ship : this.ships) {
            if (ship.getName().equals(name)){
                return ship;
            }
        }
        return null;
    }
    public String getLargestShip(){
        if (this.ships.isEmpty()){
            return "No ships in the harbor.";
        }
        int maxTonnage = Integer.MIN_VALUE;
        Ship biggestShip = null;
        for (Ship ship : this.ships) {
            if (ship.getTonnage() > maxTonnage){
                biggestShip = ship;
                maxTonnage = ship.getTonnage();
            }
        }
        assert biggestShip != null;
        return String.format("%s is the largest ship with a tonnage of %d tons.", biggestShip.getName(), maxTonnage);
    }
    public int getCount(){
        return this.ships.size();
    }
    public String getStatistics(){
        if (this.ships.isEmpty()){
            return String.format("No ships docked in %s.", this.location);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Ships docked in %s:%n", this.location));
        for (Ship ship : this.ships) {
            stringBuilder.append(String.format("* %s%n", ship.getName()));
        }
        return stringBuilder.toString();
    }
}
