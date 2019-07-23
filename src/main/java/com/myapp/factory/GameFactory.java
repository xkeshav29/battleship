package com.myapp.factory;

import com.myapp.exception.InvalidGameException;
import com.myapp.model.*;

import java.util.List;
import java.util.UUID;

public class GameFactory {

    public static Game createGame(String player1Id, String player2Id, List<Ship> player1Ships, List<Ship> player2Ships) {
        Board board1 = BoardFactory.createBoard(player1Ships);
        Board board2 = BoardFactory.createBoard(player2Ships);
        Player player1 = PlayerFactory.createPlayer(player1Id, board1);
        Player player2 = PlayerFactory.createPlayer(player2Id, board2);
        Game game = new GameBuilder()
                .setId(UUID.randomUUID().toString())
                .setPlayer1(player1)
                .setPlayer2(player2)
                .createGame();
        if(!game.isValid())
            throw new InvalidGameException("Invalid Setup of ships");
        return game;
    }
}
