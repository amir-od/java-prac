import java.util.Random;
public class Main
{
    public static int[] numbers;

    public static void main(String[] args)
    {
        System.out.println("Generating numbers...");

        GenerateRandomNumbers();

        for(int counter = 0; counter < numbers.length; counter++ )
        {
            System.out.print(numbers[counter] + " ");
        }

        System.out.println("\nSequence is ascending: " + IsSequence());
    }
    private static void GenerateRandomNumbers()
    {
        numbers = new int[4];

        for(int counter = 0; counter < numbers.length; counter++ )
        {
            numbers[counter] = (new Random()).nextInt(10,99);
        }
    }
    private static boolean IsSequence()
    {
        int tempPreviousNumber = numbers[0];
        for(int counter = 1; counter < numbers.length; counter++ )
        {
            if(tempPreviousNumber > numbers[counter])
                return false;
            tempPreviousNumber = numbers[counter];
        }
        return true;
    }
}