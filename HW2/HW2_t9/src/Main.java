import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Main
{
    public static void main(String[] args)
    {
        Poker poker = new Poker(3);
        poker.StartGame();
    }
}
enum CardColor
{
    Hearts,
    Diamonds,
    Clubs,
    Spades
}
enum CardName
{
    Card_2,
    Card_3,
    Card_4,
    Card_5,
    Card_6,
    Card_7,
    Card_8,
    Card_9,
    Card_10,
    Card_Jack,
    Card_Queen,
    Card_King,
    Card_Ace
}
class Card
{
    private CardColor color = CardColor.values()[0];
    private CardName name = CardName.values()[0];
    Card(CardColor color, CardName name)
    {
        this.color = color;
        this.name = name;
    }
    public CardName GetName()
    {
        return name;
    }
    public CardColor GetColor()
    {
        return color;
    }
}
class Player
{
    private int id = 0;
    private List<Card> hand = new ArrayList<>();
    private int cardsCount = 0;
    Player(int id)
    {
        this.id = id;
    }
    public boolean AddCard(Card card)
    {
        if(hand.size() < 6)
        {
            hand.add(card);
            cardsCount++;
            return true;
        }
        return false;
    }
    public String GiveAwayCards()
    {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n");
        stringBuffer.append("Player: " + id + "\n");
        for (Card card: hand)
        {
            stringBuffer.append(String.format("Suit: %s Name: %s \n",card.GetColor(),card.GetName()));
        }
        return stringBuffer.toString();
    }
}
class Poker
{
    private ArrayList<Card> cardsInPokerHand = new ArrayList<Card>();
    private ArrayList<Player> playersProfiles = new ArrayList<Player>();
    private int playersAtTheTable = 0;
    Poker(int howManyPlayers)
    {
        playersAtTheTable = howManyPlayers;
    }
    public void StartGame()
    {
        CreatePlayersProfiles(playersAtTheTable);
        GenerateNewPokerHand();
        SpreadCards();
        for (Player player : playersProfiles)
        {
            System.out.println(player.GiveAwayCards());
        }
    }
    private void CreatePlayersProfiles(int howManyPlayers)
    {
        playersProfiles.clear();
        for (int counter = 1; counter <= howManyPlayers; counter++)
        {
            Player playerProfile = new Player(counter);
            playersProfiles.add(playerProfile);
        }
    }
    private void SpreadCards()
    {
        int fullHands = 0;
        boolean cardAdded = false;
        Random random = new Random();
        while(fullHands < playersAtTheTable)
        {
            for (Player player: playersProfiles)
            {
                if(cardsInPokerHand.size() <= 1)
                    GenerateNewPokerHand();
                int cardId = random.nextInt(cardsInPokerHand.size()-1);
                Card card = cardsInPokerHand.get(cardId);
                cardAdded = player.AddCard(card);
                if(cardAdded == false)
                    fullHands++;
                cardsInPokerHand.remove(cardId);
            }
        }
    }
    private void GenerateNewPokerHand()
    {
        for(CardColor cardColor: CardColor.values())
        {
            ArrayList<Card> newCards = CreateCards(cardColor);
            cardsInPokerHand = SummCards(newCards, cardsInPokerHand);
        }
    }
    private ArrayList<Card> CreateCards(CardColor cardColor)
    {
        ArrayList<Card> cards = new ArrayList<Card>();
        for (int counter = 0; counter < CardName.values().length; counter++)
        {
            Card card = new Card(cardColor,CardName.values()[counter]);
            cards.add(card);
        }
        return cards;
    }
    private ArrayList<Card> SummCards(ArrayList<Card> firstArray, ArrayList<Card> secondArray)
    {
        ArrayList<Card> newArrayOfCards = new ArrayList<Card>();
        for (Card card: firstArray)
        {
            newArrayOfCards.add(card);
        }
        for (Card card: secondArray)
        {
            newArrayOfCards.add(card);
        }
        return newArrayOfCards;
    }
}