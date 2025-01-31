package surfers;

import java.util.ArrayList;
import java.util.List;

public class Beach {
    private String name;
    private int surfboardsForRent;
    private List<Surfer> surfers;

    public Beach(String name, int surfboardsForRent) {
        this.name = name;
        this.surfboardsForRent = surfboardsForRent;
        this.surfers = new ArrayList<>();
    }
    public String addSurfer(Surfer surfer){
        if (!surfer.getOwnsASurfBoard()){
            if (surfer.getMoney() > 50){
                if (this.surfboardsForRent > 0) {
                    this.surfboardsForRent--;
                    surfers.add(surfer);
                    return String.format("Surfer %s added.", surfer.getName());
                }else{
                    return "There are no free surfboards.";
                }
            }else{
                return String.format("%s has not enough money to rent a surfboard.", surfer.getName());
            }
        }else{
            surfers.add(surfer);
            return String.format("Surfer %s added.", surfer.getName());
        }
    }
    public boolean removeSurfer(String name){
        for (Surfer surfer : surfers) {
            if (surfer.getName().equals(name)){
                surfers.remove(surfer);
                return true;
            }
        }
        return false;
    }
    public String getMostExperiencedSurfer(){
        int mostExperience = 0;
        Surfer mostExperiencedSurfer = null;
        if (surfers.isEmpty()){
            return "There are no surfers";
        }
        for (Surfer surfer : surfers) {
            if (surfer.getExperience() > mostExperience){
                mostExperience = surfer.getExperience();
                mostExperiencedSurfer = surfer;
            }
        }
        return String.format("%s is most experienced" +
                " surfer with %d years experience.", mostExperiencedSurfer.getName(), mostExperiencedSurfer.getExperience());
    }
    public Surfer getSurfer(String name){
        Surfer surfer = null;
        for (Surfer surfer1 : surfers) {
            if (surfer1.getName().equals(name)){
                surfer = surfer1;
            }
        }
        return surfer;
    }
    public int getCount(){
        return surfers.size();
    }
    public String getSurfersWithPersonalSurfboards(){
        if (surfers.isEmpty()){
            return "There are no surfers";
        }
        List<String> surferList = new ArrayList<>();
        for (Surfer surfer : surfers) {
            if (surfer.getOwnsASurfBoard()){
                surferList.add(surfer.getName());
            }
        }
        return "Surfers who have their own surfboards: " + String.join(", ", surferList);
    }
    public String getReport(){
        if (surfers.isEmpty()){
            return String.format("There are no surfers on %s beach.", this.name);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Beach %s was visited by the following surfers:%n", this.name));
        int counter = 0;
        for (Surfer surfer : surfers) {
            counter++;
            if (surfer.getExperience() == 0){
                stringBuilder.append(String.format("%d. %s with no experience.%n", counter, surfer.getName()));
            }else{
                stringBuilder.append(String.format("%d. %s with %d years experience.%n", counter, surfer.getName(),
                        surfer.getExperience()));
            }
        }
        return stringBuilder.toString();
    }
}
