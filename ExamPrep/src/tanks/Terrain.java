package tanks;

import java.util.ArrayList;
import java.util.List;

public class Terrain {
    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area) {
        this.type = type;
        this.tanks = new ArrayList<>();
        this.area = area;
    }

    public String addTank(Tank tank){
        for (Tank currentTank : tanks) {
            if (currentTank.getBrand().equals(tank.getBrand()) && currentTank.getModel().equals(tank.getModel())){
                return "Tank with this brand and model already exists!";
            }
        }
        if (type.equals("Swamp") && tank.getWeight() > 14000){
            return String.format("This %s is too heavy for this terrain!", tank.getBrand());
        }
        tanks.add(tank);
        return String.format("Tank %s %s added.", tank.getBrand(), tank.getModel());
    }
    public boolean removeTank(String brand, String model){
        for (Tank tank : tanks) {
            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)){
                tanks.remove(tank);
                return true;
            }
        }
        return false;
    }
    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber){
        List<Tank> tanksByCaliber = new ArrayList<>();
        for (Tank tank : tanks) {
            if (tank.getBarrelCaliber() > barrelCaliber){
                tanksByCaliber.add(tank);
            }
        }
        if (tanksByCaliber.isEmpty()){
            return "There are no tanks with the specified caliber.";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Tanks with caliber more than %dmm: ", barrelCaliber));
        for (int i = 0; i < tanksByCaliber.size(); i++) {
            stringBuilder.append(tanksByCaliber.get(i).getBrand());
            if (i < tanksByCaliber.size() - 1){
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
    public Tank getTankByBrandAndModel(String brand, String model){
        for (Tank tank : tanks) {
            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)){
                return tank;
            }
        }
        return null;
    }
    public String getTheMostArmoredTank(){
        Tank maxTank = null;
        int maxArmor = 0;
        for (Tank tank : tanks) {
            if (tank.getArmor() > maxArmor){
                maxArmor = tank.getArmor();
                maxTank = tank;
            }
        }
        assert maxTank != null;
        return  String.format("%s %s is the most armored tank with %dmm. armor thickness.",
                maxTank.getBrand(),
                maxTank.getModel(),
                maxArmor);
    }
    public int getCount(){
        return tanks.size();
    }
    public String getStatistics(){
        if (this.tanks.isEmpty()){
            return String.format("There are no tanks in the %s.", this.type.toLowerCase());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Tanks located in the %s:%n", this.type));
        for (Tank tank : tanks){
            stringBuilder.append(String.format("-- %s %s%n", tank.getBrand(), tank.getModel()));
        }
        return stringBuilder.toString();
    }
}
