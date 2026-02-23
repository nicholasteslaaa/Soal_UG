package com.ukdw.rplbo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamestate {
    private List<Player> players = new ArrayList<>();
    private List<Cards> cardStack = new ArrayList<>();
    private Cards current_card = null;
    private int current_player_idx = 0;

    public Gamestate(int player_amount){
        set_up_cards();
        shuffle();
        add_player(player_amount);
    }

    public Gamestate(){
        set_up_cards();
        shuffle();
        add_player(2);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Cards> getCardStack() {
        return cardStack;
    }

    public void setCardStack(List<Cards> cardStack) {
        this.cardStack = cardStack;
    }

    public Cards getCurrent_card() {
        return current_card;
    }

    public void setCurrent_card(Cards current_card) {
        this.current_card = current_card;
    }

    public int getCurrent_player_idx() {
        return current_player_idx;
    }

    public void setCurrent_player_idx(int current_player_idx) {
        this.current_player_idx = current_player_idx;
    }

    public void change_player_position(int original_position, int target_position){
        Player temp = players.get(original_position);
        players.set(original_position,players.get(target_position));
        players.set(original_position,temp);
    }


    public void set_up_cards(){
        String[] color = {"RED","YELLOW","BLUE","GREEN"};
        for (int clr_idx = 0; clr_idx < color.length; clr_idx++){
            String clr = color[clr_idx];

            for (int i = 1; i < 10; i++){
                cardStack.add(new NumberCards(clr,i));
            }

            for (int i = 0; i < 3; i++){
                cardStack.add(new SkipCards(clr));
                cardStack.add(new ReverseCards(clr));
                cardStack.add(new DrawTwoCards(clr));
            }

            for (int i = 0; i < 5; i++){
                cardStack.add(new WildCards("WILDCARDS"));
            }
        }
    }

    public void shuffle(){
        Random randomNum = new Random();
        for (int i = 0; i < cardStack.size()*2; i++){
            int x = randomNum.nextInt(cardStack.size());
            int y = randomNum.nextInt(cardStack.size());
            Cards temp = cardStack.get(x);
            cardStack.set(x,cardStack.get(y));
            cardStack.set(y,temp);
        }
    }

    public void add_player(int amount_players){
        this.players.add(new Player("player",this));
        for (int i = 1; i < amount_players+1; i++){
            Player player = new Player("bot "+String.valueOf(i),this);
            this.players.add(player);
        }
    }

    public Player get_player(int player_idx){
        if (player_idx > players.size()-1){player_idx = player_idx % players.size()-1;}
        if (player_idx < 0){player_idx = (player_idx*-1) % players.size()-1;}
        return players.get(player_idx);
    }
}
