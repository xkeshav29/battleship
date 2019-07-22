package com.myapp.factory;

import com.myapp.model.Board;
import com.myapp.model.Player;


public class PlayerFactory {

    public static Player createPlayer(String id, Board board) {
        return new Player(id, board);
    }
}
