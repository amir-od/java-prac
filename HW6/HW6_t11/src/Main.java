import java.util.Scanner;
public class Main
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Celsius degrees: ");
        float c = in.nextFloat();
        float converted_C_to_F = new Converter().convert_C_to_F(c);
        System.out.println(String.format("%.2f F",converted_C_to_F));
        float converted_C_to_K = new Converter().convert_C_to_K(c);
        System.out.println(String.format("%.2f K",converted_C_to_K));
    }
}
interface IConverter
{
    public float convert_C_to_F(float celsius);
    public float convert_C_to_K(float celsius);
}
class Converter implements IConverter
{
    @Override
    public float convert_C_to_F(float celsius)
    {
        float converted_C_to_F = (float) (celsius * 1.8 + 32);
        return converted_C_to_F;
    }
    @Override
    public float convert_C_to_K(float celsius)
    {
        float converted_C_to_K = (float) (celsius + 273.15);
        return converted_C_to_K;
    }
}


