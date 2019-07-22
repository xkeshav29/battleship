package com.myapp.service;


import com.myapp.factory.GameFactory;
import com.myapp.model.Ship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameService {

    private static Logger LOG = LoggerFactory
            .getLogger(GameService.class);

    public void startGame(String player1Id, String player2Id, List<Ship> player1Ship, List<Ship> player2Ship) {
        LOG.info("Starting Battleship game");
        GameFactory.createGame(player1Id, player2Id, player1Ship, player2Ship)
                .start();
    }

}
