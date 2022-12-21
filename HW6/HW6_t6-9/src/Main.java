import java.util.Random;
public class Main
{
    private static Printable[] printables = new Printable[]
            {
                    new Shop(),
                    new Book(),
                    new Shop(),
                    new Book(),
                    new Book(),
                    new Shop()
            };
    public static void main(String args[])
    {
        for(Printable printable : printables)
        {
            printable.print();
        }
    }
}
interface Printable
{
    public void print();
}
class Book implements Printable
{
    public void print()
    {
        System.out.print(String.format("Book's part number: %s\n", new Random().nextInt(10)));
    }
}
class Shop implements Printable
{
    public void print()
    {
        System.out.print(String.format("Magazine's number: %s\n",  new Random().nextInt(10)));
    }
}