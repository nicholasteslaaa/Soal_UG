package com.ukdw.rplbo;

public class ReverseCards extends ActionCards {
    public ReverseCards(String color) {super(color,"REVERSE");}
    @Override
    public boolean play_card(Gamestate game) {
        if (game.getCurrent_card() != null && game.getCurrent_card().color != this.color){
            return false;
        }

        for (int i = 0; i < (int) (game.getPlayers().size()/2);i++ ){
            game.change_player_position(i,game.getPlayers().size()-i-1);
        }
        game.setCurrent_card(this);
        return false;
    }
}
