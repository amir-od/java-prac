import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main
{
    private static JLabel jLabel1 = new JLabel();
    private static JLabel jLabel2 = new JLabel();
    private static JLabel jLabel3 = new JLabel();
    public static void main(String args[])
    {
        Game game = new Game();
        jLabel1.setText("");
        jLabel2.setText("");
        jLabel3.setText("");
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(jLabel1);
        topPanel.add(jLabel2);
        topPanel.add(jLabel3);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setBackground(Color.GRAY);
        mainPanel.add(topPanel);
        mainPanel.add(bottomPanel);
        ActionListener actionListener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                game.milan.AddScore();
                SetText(game, game.milan);
            }
        };
        ActionListener actionListener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                game.madrid.AddScore();
                SetText(game, game.madrid);
            }
        };
        JButton buttonMil = new JButton("Milan + 1");
        JButton buttonMad = new JButton("Madrid + 1");
        bottomPanel.add(buttonMil);
        bottomPanel.add(buttonMad);
        buttonMil.addActionListener(actionListener1);
        buttonMad.addActionListener(actionListener2);
        JFrame frame = new JFrame("JFrame");
        frame.setPreferredSize(new Dimension(600,300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
    private static void SetText(Game game, Team lastScorer)
    {
        jLabel1.setText(String.format("Result: %s X %s", game.madrid.GetScore(), game.milan.GetScore()));
        jLabel2.setText(String.format("Last scorer: %s", lastScorer.GetName()));
        if(game.madrid.GetScore() != game.milan.GetScore())
            jLabel3.setText(String.format("Winner: %s", game.madrid.GetName()));
        else if (game.madrid.GetScore() == game.milan.GetScore())
            jLabel3.setText(String.format("Winner: DRAW", game.madrid.GetName()));
    }
}
abstract class Team
{
    private String Name = "team";
    private int Score = 0;
    public int GetScore()
    {
        return Score;
    }
    public void AddScore()
    {
        Score++;
    }
    public void SetName(String name)
    {
        Name = name;
    }
    public String GetName()
    {
        return Name;
    }
}
class Madrid extends Team
{
    Madrid()
    {
        SetName("Madrid");
    }
}
class Milan extends Team
{
    Milan()
    {
        SetName("Milan");
    }
}
class Game
{
    public Milan milan = new Milan();

    public Madrid madrid = new Madrid();
}