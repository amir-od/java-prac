import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class Main
{
    public static void main(String[] args)
    {
        JPanel container = new JPanel();
        CardLayout cardLayout = new CardLayout();
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(container);
            }
        };
        container.setLayout(cardLayout);
        for(int counter = 1; counter <= 10; counter++)
        {
            Figure figure = new Figure(0,0,100,200);
            figure.SetNumber(counter);
            figure.SetColor(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
            JButton jButton = new JButton();
            jButton.add(figure.GetJFectangle());
            jButton.addActionListener(actionListener);
            container.add(jButton);
        }
        JFrame jFrame = new JFrame("JFrame");
        jFrame.setPreferredSize(new Dimension(800,500));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(container, BorderLayout.CENTER);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
abstract class Shape
{
    private int X = 0;
    private  int y = 0;
    private float width = 10;
    private  float height = 10;
    private Color color = new Color(38, 171, 93);
    public void SetY(int y)
    {
        this.y = y;
    }
    public void SetX(int x)
    {
        X = x;
    }
    public int GetY()
    {
        return y;
    }
    public int GetX()
    {
        return X;
    }
    public void SetColor(int r, int g, int b)
    {
        this.color = new Color(r,g,b);
    }
    public Color GetColor()
    {
        return color;
    }
    public void SetWidth(float width)
    {
        this.width = width;
    }
    public void SetHeight(float height)
    {
        this.height = height;
    }

    public float GetHeight()
    {
        return height;
    }
    public float GetWidth()
    {
        return width;
    }
}
class Figure extends Shape
{
    private int number = 0;
    private int[][] placement = new int[4][2];
    private boolean placementGenerated = false;
    Figure(int x, int y, int width, int height)
    {
        super();
        SetX(x);
        SetY(y);
        SetWidth(width);
        SetHeight(height);
    }
    public JComponent GetJFectangle()
    {
        JComponent jComponent = new JComponent()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                Graphics2D graphics2D = (Graphics2D)g;
                if(placementGenerated == false)
                {
                    GeneratePositionsOfPoints();
                    placementGenerated = true;
                }
                graphics2D.setColor(Color.black);
                graphics2D.fillRect(0, 0, (int)GetWidth() - 1  + GetX(), (int)GetHeight() - 1  + GetY());
                graphics2D.setColor(GetColor());
                graphics2D.drawLine(placement[0][0], placement[0][1], placement[1][0], placement[1][1]);
                graphics2D.drawLine(placement[1][0], placement[1][1], placement[2][0], placement[2][1]);
                graphics2D.drawLine(placement[2][0], placement[2][1], placement[3][0], placement[3][1]);
                graphics2D.drawLine(placement[3][0], placement[3][1], placement[0][0], placement[0][1]);
                graphics2D.setFont(new Font("Times New Roman",1,30));
                graphics2D.drawString(String.valueOf(number),5, 25);
            }
        } ;
        jComponent.setMinimumSize(new Dimension( (int)GetWidth() + GetX(), (int)GetHeight() + GetY()));
        jComponent.setMaximumSize(new Dimension( (int)GetWidth()+20 + GetX(), (int)GetHeight()+20 + GetY()));
        jComponent.setPreferredSize(new Dimension((int)GetWidth() + GetX(), (int)GetHeight() + GetY()));
        return jComponent;
    }
    private void GeneratePositionsOfPoints()
    {
        placement[0][0] = new Random().nextInt(GetX(), (int)GetWidth()/2 - 10 + GetX());
        placement[1][0] = new Random().nextInt((int)GetWidth()/2 - 10 + GetX(), (int)GetWidth() - 10 + GetX());
        placement[3][0] = new Random().nextInt(GetX(), (int)GetWidth()/2 - 10 + GetX());
        placement[2][0] = new Random().nextInt((int)GetWidth()/2 - 10 + GetX(), (int)GetWidth() - 10 + GetX());
        placement[0][1] = new Random().nextInt(GetY(), (int)GetHeight()/2-10 + GetY());
        placement[1][1] = new Random().nextInt(GetY(), (int)GetHeight()/2-10 + GetY());
        placement[3][1] = new Random().nextInt((int)GetHeight()/2-10 + GetY(), (int)GetHeight()-10 + GetY());
        placement[2][1] = new Random().nextInt((int)GetHeight()/2-10 + GetY(), (int)GetHeight()-10 + GetY());
    }
    public void SetNumber(int number) {
        this.number = number;
    }
}