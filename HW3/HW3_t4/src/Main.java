import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main
{
    static int[] numbers;
    static ArrayList<String> anotherArray;
    public static void main(String[] args)
    {
        System.out.print("Enter values: ");
        CorrectInput();
        GenerateNumbers();
        System.out.println("\n");
        CreateAnotherArray();

        for(String string : anotherArray)
        {
            System.out.print(string + " ");
        }
    }
    private static void CreateAnotherArray()
    {
        ArrayList<String> stringArray = new ArrayList<String>();
        for (int counter = 0; counter < numbers.length; counter++)
        {
            if(numbers[counter] % 2 == 0 && numbers[counter] != 0)
            {
                stringArray.add(String.valueOf(numbers[counter]));
            }
        }
        anotherArray = stringArray;
    }
    private static void GenerateNumbers()
    {
        Random random = new Random();
        for (int counter = 0; counter < numbers.length; counter++)
        {
            System.out.println(numbers[counter] = random.nextInt(0, numbers.length));
        }

    }
    private static void CorrectInput()
    {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        while(true)
        {
            input = scanner.nextInt();
            if(input > 0)
                break;
        }

        numbers = new int[input];
    }
}