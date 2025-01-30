package DefiningClasses.RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tire;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tire){
        this.cargo = cargo;
        this.model = model;
        this.engine = engine;
        this.tire = tire;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public List<Tire> getTire() {
        return tire;
    }

    public String getModel() {
        return model;
    }
}
