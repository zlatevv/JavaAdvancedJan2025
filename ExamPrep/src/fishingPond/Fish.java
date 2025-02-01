package fishingPond;

public class Fish {
    private String species;
    private int age;
    private String matingSeason;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getMatingSeason() {
        return matingSeason;
    }

    public void setMatingSeason(String matingSeason) {
        this.matingSeason = matingSeason;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Fish(String species, int age, String matingSeason) {
        this.species = species;
        this.age = age;
        this.matingSeason = matingSeason;
    }

    @Override
    public String toString() {
        return String.format("This %s is %d years old and reproduces through %s.", this.species,
                this.age,
                this.matingSeason);
    }
}
