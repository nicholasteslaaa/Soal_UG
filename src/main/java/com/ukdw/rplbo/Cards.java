package com.ukdw.rplbo;

public abstract class Cards {
    public String color;
    public String type;

    abstract boolean play_card(Gamestate game);

}
