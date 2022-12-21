import java.util.Scanner;
public class Main
{
    private static Food[] food = new Food[3];
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        food[0] = new Food(1,500 ,"Apples");
        food[1] = new Food(2,5240,"Bananas");
        food[2] = new Food(3,9999,"Lemons");
        for(Food food : food)
        {
            System.out.println(String.format("№%s %s: %s %s",food.GetId(), food.GetName(), food.ShowInCurrency(Currencies.Ruble), Currencies.Ruble.toString()));
        }
        System.out.print("\nAvailable currencies: ");
        for(Currencies currency : Currencies.values())
        {
            System.out.print(String.format("%s ",currency.toString()));
        }
        System.out.println("\n\n");
        boolean correctCurency = false;
        Currencies selectedCurrency = Currencies.Ruble;
        String readLine;
        do
        {
            System.out.print("\nEnter a currency: ");
            readLine = scanner.nextLine();
            for(Currencies currency : Currencies.values())
            {
                if(currency.toString().equals(readLine)) {
                    selectedCurrency = currency;
                    correctCurency = true;
                }
            }
        }
        while(correctCurency == false);
        for(Food food : food)
        {
            System.out.println(String.format("№%s %s: %s %s",food.GetId(), food.GetName(), food.ShowInCurrency(selectedCurrency), selectedCurrency.toString()));
        }
    }
}
enum Currencies
{
    Dollar,
    Euro,
    Ruble
}
class Food
{
    private int Id = 0;
    private String name = "";
    private Currency currency = new Currency(Currencies.Ruble, 500);
    Food(int id, int price, String name)
    {
        currency.SetCurrencyValue(price);
        this.Id = id;
        this.name = name;
    }
    public int ShowInCurrency(Currencies needCurrency)
    {
        if(needCurrency == Currencies.Dollar)
            return (int)((float)currency.GetCurrencyValue() * 0.016662f);

        if(needCurrency == Currencies.Euro)
            return (int)((float)currency.GetCurrencyValue() * 0.019653f);

        return currency.GetCurrencyValue();
    }
    public String GetName()
    {
        return name;
    }
    public int GetId()
    {
        return Id;
    }
}
class Currency
{
    private Currencies type = Currencies.Ruble;
    private int value = 0;

    Currency(Currencies currencies, int value)
    {
        this.type = currencies;
        this.value = value;
    }

    public Currencies GetCurrencyType() {
        return type;
    }

    public int GetCurrencyValue() {
        return value;
    }

    public void SetCurrencyValue(int price)
    {
        this.value = price;
    }
}