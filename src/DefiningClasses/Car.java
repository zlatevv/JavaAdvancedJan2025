package DefiningClasses;

public class Car {
    public String brand;
    public String model;
    public int horsePower;

    public Car(){
        this("unknown", "unknown", -1);
    }
    public Car(String brand){
        this(brand, "unknown", -1);
    }
    public Car(String brand, String model){
        this(brand, model, -1);
    }
    public Car(String brand, String model, int horsePower){
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }
}
