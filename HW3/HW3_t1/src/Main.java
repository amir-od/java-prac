import java.util.Random;
public class Main
{
    private static float[] numbers;

    public static void main(String[] args)
    {
        System.out.print ("Generation by Random: ");
        GenerateVariant1(10);
        System.out.print ("Generation by Math.random: ");
        GenerateVariant2(10);

        SortNumbers();
        System.out.print ("Sorted second array: ");

        for(int counter = 0; counter < numbers.length; counter++)
        {
            System.out.print(numbers[counter] +  " ");
        }
    }
    private static void GenerateVariant1(int count)
    {
        numbers = new float[count];
        for(int counter = 0; counter < count; counter++)
        {
            Random random = new Random();
            numbers[counter] = random.nextFloat();
            System.out.print(numbers[counter] +  " ");
        }
        System.out.println();
    }
    private static void GenerateVariant2(int count)
    {
        numbers = new float[count];
        for(int counter = 0; counter < count; counter++)
        {
            numbers[counter] = (float) Math.random();
            System.out.print(numbers[counter] +  " ");
        }
        System.out.println();
    }
    public static void SortNumbers()
    {
        float temp1 = numbers[0];
        int temp1Id = 0;
        int sortedNumbers = 0;
        while (sortedNumbers < numbers.length)
        {
            for (int counter = 0; counter < numbers.length - sortedNumbers; counter++) {
                float circle = numbers[counter];

                if (circle > temp1)
                {
                    temp1 = circle;
                    temp1Id = counter;
                }
            }
            int lastUnSortedNumbers = numbers.length - 1 - sortedNumbers;
            numbers[temp1Id] = numbers[lastUnSortedNumbers];
            numbers[lastUnSortedNumbers] = temp1;

            temp1 = numbers[0];
            temp1Id = 0;
            sortedNumbers++;
        }
    }
}