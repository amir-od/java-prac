public class Main
{
    public static void main(String[] args)
    {
        Author author = new Author("John", "jc@gmail.com", 'M');
        System.out.println(String.format("%s %s %s",author.GetName(), author.GetEmail(), author.GetGender()));
        author.SetEmail("cj@gmail.com");
        System.out.println(author.ToString());
    }
}
class Author
{
    private String Name;
    private String eMail;
    private char Gender;
    Author(String name, String email, char gender)
    {
        Name = name;
        eMail = email;
        Gender = gender;
    }
    public String GetName()
    {
        return Name;
    }
    public String GetEmail()
    {
        return eMail;
    }
    public void SetEmail(String email)
    {
        eMail = email;
    }
    public char GetGender()
    {
        return Gender;
    }
    public String ToString()
    {
        return String.format("%s %s %s",Name, eMail, Gender);
    }
}