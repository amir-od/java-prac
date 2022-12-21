public class Main
{
    public static void main(String[] args)
    {
        System.out.println("");
    }
}
interface Movable
{
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();
}
class MovablePoint implements Movable
{
    protected int x = 0;
    protected int y = 0;
    protected int xSpeed = 0;
    protected int ySpeed = 0;
    MovablePoint(int x, int y, int xSpeed, int ySpeed)
    {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    @Override
    public void moveDown() {}
    @Override
    public void moveLeft() {}
    @Override
    public void moveRight() {}
    @Override
    public void moveUp() {}
    @Override
    public String toString()
    {
        return "string";
    }
}
class MovableCircle implements Movable
{
    private int radius = 0;
    private MovablePoint center = new MovablePoint(0,0,0,0);
    MovableCircle(int x, int y, int xSpeed, int ySpeed)
    {
        center = new MovablePoint(x,y,xSpeed,ySpeed);
    }
    @Override
    public void moveDown() {}
    @Override
    public void moveLeft() {}
    @Override
    public void moveRight() {}
    @Override
    public void moveUp() {}
    @Override
    public String toString()
    {
        return "string";
    }
}