public class Main {
    public static void main(String[] args) {
        Phone phone=new Phone("89054557582","Samsung",450);
        Phone phone2=new Phone("89049434432","iPhone",560);
        Phone phone3=new Phone("89997773231","Huawei",435);
        System.out.println(phone.toString()+"\n"+phone2.toString()+"\n"+phone3.toString());
        phone.receiveCall("James");
        System.out.println(phone.getNumber());
        System.out.println(phone2.getNumber());
        System.out.println(phone3.getNumber());
        phone2.receiveCall("Jason", "89997777777");
        System.out.println("Messages will be sent to:");
        phone3.sendMessage("89342352445","89348345242","89991457390");
    }
}
class Phone {
    private String number;
    private String model;
    private int weight;
    public Phone(String number, String model, int weight) {
        this(number, model);
        this.weight = weight;
    }
    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }
    public Phone() {}
    public void receiveCall(String name, String number)
    {
        System.out.println("Call from: " + name + " " + number);
    }
    public void receiveCall(String name)
    {
        System.out.println("Call from " + name);
    }
    public String getNumber() {
        return number;
    }
    public void sendMessage(Object...objects)
    {
        for (Object o : objects)
            System.out.println(o.toString()+" ");
        System.out.println("----------------");
    }
    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }
}