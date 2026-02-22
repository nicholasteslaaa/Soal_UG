package com.ukdw.rplbo;

public class ReverseCards extends ActionCards {
    ReverseCards(String color) {super(color,"REVERSE");}
    @Override
    boolean play_card(Gamestate game) {
        if (game.getCurrent_card() != null && game.getCurrent_card().color != this.color){
            return false;
        }

        for (int i = 0; i < (int) (game.get_player_amount()/2);i++ ){
            game.change_player_position(i,game.get_player_amount()-i-1);
        }
        game.setCurrent_card(this);
        return false;
    }
}
