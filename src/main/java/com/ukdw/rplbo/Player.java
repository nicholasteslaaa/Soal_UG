package com.ukdw.rplbo;
import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Cards> player_hand = new ArrayList<>();
    private Gamestate game;
    private boolean isSkipped = false;

    public Player(String name, Gamestate game){
        this.name = name;
        this.game = game;

        drawCards(5);
    }

    public void drawCards(){
        player_hand.add(game.getCardStack().get(0));
        game.getCardStack().remove(0);
    }

    public void drawCards(int amount){
        for (int i = 0; i < amount; i++){
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
            game.setCurrent_player_idx(game.getCurrent_player_idx()+1);
        }else{
            System.out.println("ERROR: color, type or number isn't the with current card");
        }

    }

    public boolean isSkipped() {
        return isSkipped;
    }

    public void setSkipped(boolean skipped) {
        isSkipped = skipped;
    }

    public List<Cards> getPlayer_hand(){
        return  player_hand;
    }
}
