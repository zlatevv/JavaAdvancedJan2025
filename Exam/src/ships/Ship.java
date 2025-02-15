package ships;

public class Ship {
    private String name;
    private String type;
    private int tonnage;
    private int draft;

    public Ship(String name, String type, int tonnage, int draft) {
        this.name = name;
        this.type = type;
        this.tonnage = tonnage;
        this.draft = draft;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDraft() {
        return draft;
    }

    public int getTonnage() {
        return tonnage;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Type: %s, Tonnage: %d tons, Draft: %d meters.",
                name,
                type,
                tonnage,
                draft);
    }
}
