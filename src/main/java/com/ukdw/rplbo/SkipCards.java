package com.ukdw.rplbo;

public class SkipCards extends ActionCards{
    SkipCards(String color){super(color,"SKIP");}
    @Override
    boolean play_card(Gamestate game) {
        if (game.getCurrent_card() != null && game.getCurrent_card().color != this.color){
            return false;
        }

        if (game.getCurrent_card().color == this.color){
            game.setCurrent_card(this);
            return true;
        }
        return false;
    }
}
