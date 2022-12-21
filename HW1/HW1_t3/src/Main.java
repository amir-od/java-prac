public class Main
{
    public static void main(String[] args)
    {
        int[] arr = {1, 4, 5, 10};
        int sum = 0, arith = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            arith = sum / arr.length;
        }
        System.out.println("Sum = " + sum + "\nArithmetical mean = " + arith);
    }
}