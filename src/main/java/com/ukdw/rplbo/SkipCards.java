package com.ukdw.rplbo;

public class SkipCards extends ActionCards{
    public SkipCards(String color){super(color,"SKIP");}
    @Override
    public boolean play_card(Gamestate game) {
        if (game.getCurrent_card() == null){
            game.setCurrent_card(this);
            game.get_player(game.getCurrent_player_idx()+1).setSkipped(true);
            return true;
        }
        if(game.getCurrent_card().color != this.color){
            return  false;
        }
        if (game.getCurrent_card().color == this.color){
            game.setCurrent_card(this);
            game.get_player(game.getCurrent_player_idx()+1).setSkipped(true);
            return true;
        }
        return false;
    }
}
