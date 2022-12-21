public class Main
{
    private static Dog[] dogsArray = new Dog[0];
    public static void main(String[] args)
    {
        Dog[] dogsIncomingArray = {new Dog("Rex", 3), new Dog("Max", 1), new Dog("Wolfie", 5)};
        AddDog(dogsIncomingArray);
        AddDog(dogsIncomingArray);
        for (Dog dog: dogsArray)
        {
            System.out.println(dog.toString());
        }
    }
    public static void AddDog(Dog[] newDogs)
    {
        Dog[] newDogsArray = new Dog[dogsArray.length + newDogs.length];
        int counter = 0;
        for (Dog dog: dogsArray)
        {
            newDogsArray[counter] = dog;
            counter++;
        }
        for (Dog dogFromArray: newDogs)
        {
            newDogsArray[counter] = dogFromArray;
            counter++;
        }
        dogsArray = newDogsArray;
    }
}
class Dog
{
    private String tag;
    private int age = 0;
    Dog(String tag, int age)
    {
        this.tag = tag;
        this.age = age;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        age = age;
    }
    public String getTag()
    {
        return tag;
    }
    public void setTag(String tag)
    {
        tag = tag;
    }
    public int GetDogAgeInHumanAge()
    {
        return age * 7;
    }
    public String toString()
    {
        return String.format("Dog: %s, Age: %s", tag, GetDogAgeInHumanAge());
    }
}