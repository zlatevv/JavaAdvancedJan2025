package DefiningClasses.RawData;

public class Engine {
    private int engineSpeed;
    private int enginePower;

    public Engine(int speed, int power){
        this.enginePower = power;
        this.engineSpeed = speed;
    }

    public int getEnginePower() {
        return enginePower;
    }
}
