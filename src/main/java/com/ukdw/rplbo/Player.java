package com.ukdw.rplbo;
import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    List<Cards> player_hand = new ArrayList<>();
    Gamestate game;

    public Player(String name, Gamestate game){
        this.name = name;
        this.game = game;

        drawCards(this.game.getCard_start_amount());
    }

    public void drawCards(){
        player_hand.add(game.cardStack.get(0));
        game.cardStack.remove(0);
    }

    public void drawCards(int amount){
        for (int i = 0; i < amount+1; i++){
            drawCards();
        }
    }

    public void print_cards_in_hand(){
        System.out.println("0. Draw Cards");
        for (int i = 0; i < player_hand.size(); i++){
            Cards current_cards = player_hand.get(i);
            String cardInfo = " | "+current_cards.color+" | "+current_cards.type;
            if (current_cards.type == "NUMBER"){
                NumberCards numCards = (NumberCards) current_cards;
                cardInfo += " | " + numCards.number;
            }
            System.out.println(String.valueOf(i+1)+". "+cardInfo);
        }
    }

    public void play_card(int card_idx){
        if (card_idx-1 == -1){
            drawCards();
            return;
        }
        if (player_hand.get(card_idx-1).play_card(game)){
            player_hand.remove(card_idx-1);
        }else{
            System.out.println("ERROR: color, type or number isn't the same ");
        }

    }
}
