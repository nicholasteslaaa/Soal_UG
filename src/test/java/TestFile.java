import com.ukdw.rplbo.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestFile {
    @Test
    void DrawTwoCardsTest() {
        Gamestate uno = new Gamestate();
        DrawTwoCards red = new DrawTwoCards("RED");
        Cards firstCard = uno.getCardStack().get(0);
        Cards secondCard = uno.getCardStack().get(1);

        red.play_card(uno);

        Player player = uno.get_player(1);

        assertEquals(7,uno.get_player(1).getPlayer_hand().size(), "expected 7, actual: "+uno.get_player(1).getPlayer_hand().size());
        assertEquals(player.getPlayer_hand().get(player.getPlayer_hand().size()-1),secondCard, " ");
        assertEquals(player.getPlayer_hand().get(player.getPlayer_hand().size()-2),firstCard, " ");

    }

    @Test
    void NumberCardsTest() {
        Gamestate uno = new Gamestate();
        NumberCards red = new NumberCards("RED",1);
        NumberCards green = new NumberCards("green",1);
        NumberCards blue = new NumberCards("blue",1);
        NumberCards yellow = new NumberCards("yellow",1);

        red.play_card(uno);
        assertEquals(uno.getCurrent_card(), red, "Current Card: "+red.toString());
        green.play_card(uno);
        assertEquals(uno.getCurrent_card(), green, "Current Card: "+green.toString());
        blue.play_card(uno);
        assertEquals(uno.getCurrent_card(), blue, "Current Card: "+blue.toString());
        yellow.play_card(uno);
        assertEquals(uno.getCurrent_card(), yellow, "Current Card: "+yellow.toString());

        NumberCards red1 = new NumberCards("RED",2);
        red1.play_card(uno);
        assertEquals(uno.getCurrent_card(), yellow, "Current Card: "+yellow.toString());
    }

    @Test
    void ReverseCardsTest() {
        Gamestate uno = new Gamestate();
        Player firstPlayer = uno.get_player(0);
        Player lastPlayer = uno.get_player(uno.getPlayers().size());
        ReverseCards rc = new ReverseCards("RED");
        rc.play_card(uno);

        Player firstPlayer1 = uno.get_player(0);
        Player lastPlayer1= uno.get_player(uno.getPlayers().size());

        boolean result = firstPlayer == firstPlayer1;
        boolean result1 = lastPlayer == lastPlayer1;

        assertEquals(true, result1==result, "");
    }

    @Test
    void SkipCardsTest() {
        Gamestate uno = new Gamestate();

        SkipCards rc = new SkipCards("RED");
        rc.play_card(uno);

        assertEquals(true, uno.get_player(1).isSkipped(), "");
    }


    @Test
    void WildCardsTest() {
        Gamestate uno = new Gamestate();
        WildCards wc = new WildCards("RED");
        wc.play_card(uno);
        assertEquals(9, uno.get_player(1).getPlayer_hand().size(), "Expected: 9, Actual: "+uno.get_player(1).getPlayer_hand().size());

        WildCards wc1 = new WildCards();
        assertEquals(null, wc1.color, "Expected: 9, Actual: "+uno.get_player(1).getPlayer_hand().size());
    }


}