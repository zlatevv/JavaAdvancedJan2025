package spaceCrafts;

import java.util.ArrayList;
import java.util.List;

public class LaunchPad {
    public String name;
    public int capacity;
    public List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();
    }
    public void addSpacecraft(Spacecraft spacecraft){
        if (capacity > 0){
            capacity--;
            spacecrafts.add(spacecraft);
        }else{
            System.out.println("This launchpad is at full capacity!");
        }
    }
    public boolean removeSpacecraft(String name){
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft.getName().equals(name)){
                spacecrafts.remove(spacecraft);
                return true;
            }
        }
        return false;
    }
    public String getHeaviestSpacecraft(){
        int heaviestWeight = 0;
        Spacecraft heaviestSpacecraft = null;
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft.getWeight() > heaviestWeight){
                heaviestSpacecraft = spacecraft;
                heaviestWeight = spacecraft.getWeight();
            }
        }
        return String.format("%s - %dkg.", heaviestSpacecraft.getName(), heaviestSpacecraft.getWeight());
    }
    public Spacecraft getSpacecraft(String name){
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft.getName().equals(name)){
                return spacecraft;
            }
        }return null;
    }
    public int getCount(){
        return this.spacecrafts.size();
    }
    public List<Spacecraft> getSpacecraftsByMissionType(String missionType){
        List<Spacecraft> spacecraftsByMissionType = new ArrayList<>();
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft.getMissionType().equals(missionType)){
                spacecraftsByMissionType.add(spacecraft);
            }
        }
        if (spacecrafts.isEmpty()){
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return spacecraftsByMissionType;
    }
    public String getStatistics(){
        if (spacecrafts.isEmpty()){
            return String.format("Spacecrafts launched from %s:\nnone", this.name);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Spacecrafts launched from %s:%n", this.name));
        for (int i = 0; i < spacecrafts.size(); i++) {
            stringBuilder.append(String.format("%d. %s%n", i + 1, spacecrafts.get(i).getName()));
        }
        return stringBuilder.toString();
    }
}
