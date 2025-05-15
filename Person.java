import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public interface Person {
    public void addCard(Card card);
    public void clearHand();
    public int score();
    public ArrayList<Card> getHand();


}