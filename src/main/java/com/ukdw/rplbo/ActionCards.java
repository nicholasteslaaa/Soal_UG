package com.ukdw.rplbo;

public class ActionCards extends Cards {
    public ActionCards(String color, String actionType){
        this.color = color;
        this.type = actionType;
    }

    @Override
    boolean play_card(Gamestate game) {

        return false;
    }
}
