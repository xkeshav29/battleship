package com.myapp.model;
;
import com.myapp.exception.InvalidCellException;
import com.myapp.exception.TargetAlreadyAttackedException;
import com.myapp.factory.CellFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Game {

    private String id;
    private GameContext gameContext;
    private Scanner scanner = new Scanner(System.in);

    private static Logger LOG = LoggerFactory
            .getLogger(Game.class);

    Game(String id, Player player1, Player player2) {
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
            try {
            Cell target = getTargetFromConsole(gameContext.getCurrentPlayer().getId());

                if(gameContext.fire(target))
                    LOG.info("HIT");
                else
                    LOG.info("MISS");
            } catch (TargetAlreadyAttackedException e) {
                LOG.info(e.getMessage());
            } catch (InvalidCellException e) {
                LOG.info(e.getMessage() + e.getX() + " " + e.getY());
            }
        }
        System.out.println("Player won: " + gameContext.getCurrentPlayer().getId());
    }

    private Cell getTargetFromConsole(String playerId) {
        LOG.info("Player {}. Enter a cell to bomb", playerId);
        LOG.info("Enter x and y coordinates:");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return CellFactory.newCell(x,y);
    }


    public boolean isValid() {
        return gameContext.getCurrentPlayer().getBoard().isValid() &&
                gameContext.getCurrentPlayer().getBoard().isValid();
    }
}
