import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a string: ");
        String text = scanner.nextLine();
        System.out.println("You input " + text.split(" ").length + " words" );
    }
}