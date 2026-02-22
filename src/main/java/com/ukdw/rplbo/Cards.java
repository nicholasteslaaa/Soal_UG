package com.ukdw.rplbo;

abstract class Cards {
    String color;
    String type;

    abstract boolean play_card(Gamestate game);

}
