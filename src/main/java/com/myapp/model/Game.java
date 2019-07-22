package com.myapp.model;
;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Game {

    private String id;
    private GameContext gameContext;
    private Scanner scanner = new Scanner(System.in);

    private static Logger LOG = LoggerFactory
            .getLogger(Game.class);

    public Game(String id, Player player1, Player player2) {
        this.id = id;
        this.gameContext = new GameContext(player1, player2);
    }

    private boolean hasEnded() {
        return gameContext.hasWon();
    }

    public void start() {
        while(!this.hasEnded()) {
            LOG.info("Player {} Board", gameContext.getOtherPlayer().getId());
            gameContext.getOtherPlayer().getBoard().display();
            Cell target = getTargetFromConsole(gameContext.getCurrentPlayer().getId());
            gameContext.fire(target);
        }
        System.out.println("Player won: " + gameContext.getCurrentPlayer().getId());
    }

    private Cell getTargetFromConsole(String playerId) {
        LOG.info("Player {}. Enter a cell to bomb", playerId);
        LOG.info("Enter x and y coordinates:");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Cell(x,y);
    }


}
