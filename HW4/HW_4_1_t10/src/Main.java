import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double time;
        double price;
        double priceRate;
        Transport[] transports={new Car(60,10,50,2),
                new Plane(700,1578,51,1.6),
                new Train(140, 400,52,1.5),
                new Ship(30,280, 5,3)};
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance: ");
        double S=input.nextInt();
        for (Transport transport:transports)
        {
            time=S/ transport.getSpeed();
            price= transport.getPrise_1km()*S;
            priceRate=price* transport.getCargoRate();
            System.out.println("\nType of transport: "+ transport.toString());
            System.out.println(String.format("Time of transportation: %.1f minutes",time*60));
            System.out.println("Price of transportation of a person: "+ price+" rubles");
            System.out.println("Price of transportation of cargo: "+ priceRate+" rubles");
        }
    }
}
abstract class Transport {
    private int speed;
    private int fuel;
    private int priceFuel;
    private double cargoRate;
    private double price_1km;
    public Transport(int speed, int fuel, int priceFuel, double cargoRate) {
        this.speed = speed;
        this.fuel = fuel;
        this.priceFuel = priceFuel;
        this.cargoRate = cargoRate;
        price_1km=(fuel*priceFuel)/100;
    }
    public double getPrise_1km() {
        return price_1km;
    }
    public int getFuel() {
        return fuel;
    }
    public double getCargoRate() {
        return cargoRate;
    }
    public int getPriceFuel() {
        return priceFuel;
    }
    public int getSpeed() {
        return speed;
    }
    @Override
    public abstract String toString() ;
}
class Car extends Transport{
    public Car(int speed, int fuel, int priceFuel, double cargoRate) {
        super(speed, fuel, priceFuel, cargoRate);
    }
    @Override
    public double getCargoRate() {
        return super.getCargoRate();
    }
    @Override
    public int getFuel() {
        return super.getFuel();
    }
    @Override
    public int getPriceFuel() {
        return super.getPriceFuel();
    }
    @Override
    public int getSpeed() {
        return super.getSpeed();
    }
    @Override
    public String toString() {
        return "Car";
    }
}
class Plane extends Transport{
    public Plane(int speed, int fuel, int priceFuel, double cargoRate) {
        super(speed, fuel, priceFuel, cargoRate);
    }
    @Override
    public double getCargoRate() {
        return super.getCargoRate();
    }
    @Override
    public int getFuel() {
        return super.getFuel();
    }
    @Override
    public int getPriceFuel() {
        return super.getPriceFuel();
    }
    @Override
    public int getSpeed() {
        return super.getSpeed();
    }
    @Override
    public String toString() {
        return "Plane";
    }
}
class Ship extends Transport{
    public Ship(int speed, int fuel, int priceFuel, double cargoRate) {
        super(speed, fuel, priceFuel, cargoRate);
    }
    @Override
    public double getCargoRate() {
        return super.getCargoRate();
    }
    @Override
    public int getFuel() {
        return super.getFuel();
    }
    @Override
    public int getPriceFuel() {
        return super.getPriceFuel();
    }
    @Override
    public int getSpeed() {
        return super.getSpeed();
    }
    @Override
    public String toString() {
        return "Ship";
    }
}
class Train extends Transport{
    public Train(int speed, int fuel, int priceFuel, double cargoRate) {
        super(speed, fuel, priceFuel, cargoRate);
    }
    @Override
    public double getCargoRate() {
        return super.getCargoRate();
    }
    @Override
    public int getFuel() {
        return super.getFuel();
    }
    @Override
    public int getPriceFuel() {
        return super.getPriceFuel();
    }
    @Override
    public int getSpeed() {
        return super.getSpeed();
    }
    @Override
    public String toString() {
        return "Train";
    }
}