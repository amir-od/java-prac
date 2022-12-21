import java.util.Scanner;
public class Main
{
    public static void main(String args[])
    {
        System.out.print("Enter the number of computers: ");
        Scanner scanner = new Scanner(System.in);
        int computersCount = scanner.nextInt();
        Shop shop = new Shop(computersCount);
        String inputComputerName = "No pc name";
        while(shop.GetCurrentComputersCount() < shop.GetMaxComputersCount())
        {
            System.out.print(String.format("Enter computer's name No %s: ", shop.GetCurrentComputersCount() + 1));
            inputComputerName = scanner.next();
            shop.AddComputer(new Computer(inputComputerName));
            System.out.println("Computer : " + inputComputerName + " added to the shop");
        }
        System.out.println(String.format("Computers in the shop's database: \n%s", shop.ToString()));
        System.out.print("Enter the name of the computer that you are looking for: ");
        inputComputerName = scanner.next();
        boolean computerFound = shop.FindComputer(inputComputerName);
        if(computerFound == true)
            System.out.println("The computer is in the shop");
        else
            System.out.println("The computer is not in the shop");
    }
}
class Computer
{
    private int Id = 0;
    private String Name = "No pc name";
    private ComputerBrand computerBrand = ComputerBrand.MSI;
    private Processor processor = new Processor();
    private Monitor  monitor = new Monitor();
    private Memory memory = new Memory();
    Computer(String name)
    {
        Name = name;
    }
    public String getName()
    {
        return Name;
    }
    public int getId()
    {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public Memory getMemory() {
        return memory;
    }
    public Monitor getMonitor() {
        return monitor;
    }
    public Processor getProcessor() {
        return processor;
    }
    public void setMemory(Memory memory) {
        this.memory = memory;
    }
    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
    public void setComputerBrand(ComputerBrand computerBrand) {
        this.computerBrand = computerBrand;
    }
    public ComputerBrand getComputerBrand() {
        return computerBrand;
    }
}
enum ComputerBrand
{
    MSI,
    HP,
    Lenovo
}
class ComputerBuilder implements UserInput {
    private enum electronicsNames
    {
        Computer,
        Memory,
        Processor,
        Monitor
    }
    @Override
    public String GetComputerName() {
        return GetElectronic(electronicsNames.Computer);
    }
    @Override
    public String GetComputerProcessor() {
        return GetElectronic(electronicsNames.Processor);
    }
    @Override
    public String GetComputerMemory() {
        return GetElectronic(electronicsNames.Memory);
    }
    @Override
    public String GetComputerMonitor() {
        return GetElectronic(electronicsNames.Monitor);
    }
    private String GetElectronic(electronicsNames name)
    {
        System.out.print("Enter the name"+ name.toString() +": ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        return scanner.nextLine();
    }
}
class Memory
{
    private String name = "Memory n/a";
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class Monitor
{
    private String name = "Monitor n/a";
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class Processor
{
    private String name = "Processor n/a";
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class Shop
{
    private Computer[] computersArray = null;
    private int maxComputersCount = 0;
    private int computersCount = 0;
    Shop(int computerCount)
    {
        maxComputersCount = computerCount;
        computersArray = new Computer[computerCount];
    }
    public void AddComputer(Computer computer)
    {
        computer.setId(computersCount);
        computersArray[computersCount] = computer;
        computersCount++;
    }
    public void DeleteComputer(String computerName)
    {
        Computer[] computers = new Computer[computersCount - 1];
        int counter = 0;
        for (Computer computer: computersArray)
        {
            if(computer.getName() == computerName)
            {
                computersCount--;
                continue;
            }
            computers[counter] = computer;
            counter++;
        }
    }
    public Boolean FindComputer(String computerName)
    {
        for (Computer computer: computersArray)
        {
            if(computer.getName().equals(computerName))
                return true;
        }
        return false;
    }
    public int GetCurrentComputersCount()
    {
        return computersCount;
    }
    public int GetMaxComputersCount()
    {
        return maxComputersCount;
    }
    public String ToString()
    {
        StringBuffer computers = new StringBuffer();
        for (Computer computer : computersArray)
        {
            computers.append(String.format("%s) Computer: %s Monitor: %s Processor: %s Memory: %s\n",
                    computer.getId(),
                    computer.getName(),
                    computer.getMonitor().getName(),
                    computer.getProcessor().getName(),
                    computer.getMemory().getName()));
        }
        return computers.toString();
    }
}
interface UserInput
{
    public String GetComputerName();
    public String GetComputerProcessor();
    public String GetComputerMemory();
    public String GetComputerMonitor();
}

