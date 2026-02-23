package com.ukdw.rplbo;

public class DrawTwoCards extends  ActionCards{
    public DrawTwoCards(String color){super(color,"DRAWTWOCARDS");}

    @Override
    public boolean play_card(Gamestate game) {
        if (game.getCurrent_card() != null && game.getCurrent_card().color != this.color){
            return false;
        }

        Player nextPlayer = game.get_player(game.getCurrent_player_idx()+1);
        nextPlayer.drawCards(2);
        game.setCurrent_card(this);
        return true;
    }
}
