package com.ukdw.rplbo;
public class WildCards extends ActionCards{
    public WildCards(){super(null,"WILDCARD");}
    public WildCards(String color){super(color,"WILDCARD");}

    @Override
    public boolean play_card(Gamestate game) {
        Player nextPlayer = game.get_player(game.getCurrent_player_idx()+1);
        nextPlayer.drawCards(4);
        game.setCurrent_card(this);
        return true;
    }
}
