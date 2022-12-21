public class Main
{
    public static void main(String[] args)
    {
        for (Season season:Season.values())
        {
            System.out.println(season.ToString());
            season.getDescription();
            switch(season){
                case SUMMER:
                    System.out.println("I love summer"+"\n");
                    continue;
                case AUTUMN:
                    System.out.println("I love autumn"+"\n");
                    continue;
                case WINTER:
                    System.out.println("I love winter"+"\n");
                    continue;
                case SPRING:
                    System.out.println("I love spring"+"\n");
                    continue;
            }
        }
    }
}
enum Season
{
    SUMMER(30)
            {
                public void getDescription()
                {
                    System.out.println("Hot");
                }

            },
    AUTUMN(10),
    WINTER(-10),
    SPRING(15);
    private int temp;
    Season(int temp)
    {
        this.temp=temp;
    }
    public void getDescription()
    {
        System.out.println("Cold");
    }
    public String ToString()
    {
        return name()  + " average temperature = " + temp + "\u00B0C";
    }
}