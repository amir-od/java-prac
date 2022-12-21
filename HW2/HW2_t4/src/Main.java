import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        System.out.print("Input a number of computers: ");
        Scanner scanner = new Scanner(System.in);
        int computersCount = scanner.nextInt();
        Shop shop = new Shop(computersCount);
        String inputedComputerName = "No pc name";
        while(shop.GetCurrentComputersCount() < shop.GetMaxComputersCount())
        {
            System.out.print(String.format("Input the name of the computer No %s: ", shop.GetCurrentComputersCount() + 1));
            inputedComputerName = scanner.next();
            shop.AddComputer(inputedComputerName);
            System.out.println("Computer : " + inputedComputerName + " is added");
        }
        System.out.println(String.format("Computers in the shop: \n%s", shop.ToString()));
        System.out.print("Input the name of the computer you are looking for: ");
        inputedComputerName = scanner.next();
        boolean computerFound = shop.FindComputer(inputedComputerName);
        if(computerFound == true)
            System.out.println("This computer is in the shop");
        else
            System.out.println("This computer is not in the shop");
    }
}
class Computer
{
    private int Id = 0;
    private String Name = "No pc name";
    Computer(int id, String name)
    {
        Id = id;
        Name = name;
    }
    public String GetName()
    {
        return Name;
    }
    public int GetId()
    {
        return Id;
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
    public void AddComputer(String computerName)
    {
        Computer newComputer = new Computer(computersCount + 1, computerName);
        computersArray[computersCount] = newComputer;
        computersCount++;
    }
    public void DeleteComputer(String computerName)
    {
        Computer[] computers = new Computer[computersCount - 1];
        int counter = 0;
        for (Computer computer: computersArray)
        {
            if(computer.GetName() == computerName)
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
            if(computer.GetName().equals(computerName))
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
        for (Computer computer: computersArray)
        {
            computers.append(String.format("%s) %s\n",computer.GetId(), computer.GetName()));
        }
        return computers.toString();
    }
}