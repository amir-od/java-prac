import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        fact(n);
    }
    static void fact(int n)
    {
        int res = 1;
        if (n < 0)
            System.out.println("Error!");
        else if (n == 0)
            System.out.println("0! = 1");
        else
        {
            for (int i = 1; i <= n; i++)
                res *= i;
            System.out.println(n + "! = " + res);
        }
    }
}