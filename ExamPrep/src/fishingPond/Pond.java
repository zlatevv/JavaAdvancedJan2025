package fishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {
    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishes = new ArrayList<>();
    }
    public void addFish(Fish fish){
        if (this.capacity > 0){
            this.capacity--;
            this.fishes.add(fish);
        }
    }
    public boolean removeFish(String fish){
        for (Fish currentFish : this.fishes) {
            if (currentFish.getSpecies().equals(fish)){
                this.fishes.remove(currentFish);
                capacity++;
                return true;
            }
        }
        return false;
    }
    public Fish getOldestFish(){
        Fish oldestFish = null;
        int oldestAge = 0;
        for (Fish fish : this.fishes) {
            if (fish.getAge() > oldestAge) {
                oldestFish = fish;
                oldestAge = fish.getAge();
            }
        }
        return oldestFish;
    }
    public Fish getFish(String species){

        for (Fish fish : this.fishes) {
            if (fish.getSpecies().equals(species)){
                return fish;
            }
        }
        return null;
    }
    public int getCount(){
        return this.fishes.size();
    }
    public int getVacancies(){
        return this.capacity;
    }
    public String report(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fishes in the pond: \n");
        for (Fish fish : fishes) {
            stringBuilder.append(String.format("This %s is %d years old and reproduces through %s.%n", fish.getSpecies(),
                    fish.getAge(),
                    fish.getMatingSeason()));
        }
        return stringBuilder.toString();
    }
}
