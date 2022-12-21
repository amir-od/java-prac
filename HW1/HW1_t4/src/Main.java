import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        int i;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        for (i = 0; i < n; i++)
        {
            System.out.print("Element[" + i + "] = ");
            arr[i] = in.nextInt();
        }
        for (i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        int sum = 0, min = arr[0], max = arr[0];
        for (i = 0; i < n; i++)
        {
            sum += arr[i];
        }
        for (i = 0; i < n; i++)
        {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("\nSum = " + sum + "\nMax = " + max + "\nMin = " + min);
    }
}