package com.ukdw.rplbo;

import java.util.Scanner;

public class WildCards extends ActionCards{
    WildCards(){super("WILDCARD","WILDCARD");}
    @Override
    boolean play_card(Gamestate game) {
        String[] color = {"RED","GREEN","BLUE","YELLOW"};
        for (int i = 0; i < color.length; i++){
            System.out.println(String.valueOf(i+1)+". "+color[i]);
        }
        Scanner scanner = new Scanner(System.in);
        this.color = color[Integer.parseInt(scanner.nextLine().split(" ")[0])-1];

        Player nextPlayer = game.get_player(game.get_current_player_idx()+1);
        nextPlayer.drawCards(4);
        game.setCurrent_card(this);
        return true;
    }
}
