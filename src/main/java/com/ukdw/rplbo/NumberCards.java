package com.ukdw.rplbo;

public class NumberCards extends Cards{
    public int number;

    public NumberCards(String color,int number){
        this.type = "NUMBER";
        this.color = color;
        this.number = number;
    }

    @Override
    public boolean play_card(Gamestate game) {
        Cards currCard = game.getCurrent_card();
        if (currCard == null){
            game.setCurrent_card(this);
            return true;
        }

        NumberCards numCard = (NumberCards) currCard;
        if (numCard.color == this.color || numCard.number == this.number){
            game.setCurrent_card(this);
            return true;
        }
        return false;
    }
}
