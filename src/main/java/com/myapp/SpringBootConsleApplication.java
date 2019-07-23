package com.myapp;

import com.myapp.factory.CellFactory;
import com.myapp.factory.ShipFactory;
import com.myapp.model.Cell;
import com.myapp.model.Ship;
import com.myapp.model.ShipType;
import com.myapp.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class SpringBootConsleApplication
        implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(SpringBootConsleApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(SpringBootConsleApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Autowired
    private GameService gameService;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        LOG.info("Please enter player 1 id: ");
        String player1Id = scanner.next();
        LOG.info("Please enter player 2 id: ");
        String player2Id = scanner.next();
        gameService.startGame(player1Id, player2Id, getPlayer1Ships(), getPlayer2Ships());
    }

    public List<Ship> getPlayer1Ships() {
        List<Ship> player1Ships = new ArrayList<>();
        player1Ships.add(ShipFactory.createShip(Arrays.asList(newCell(0,4), newCell(0,5),
                newCell(0,6)), ShipType.SUBMARINE));
        player1Ships.add(ShipFactory.createShip(Arrays.asList(newCell(3,3), newCell(3,4)),
                ShipType.DESTROYER));
        player1Ships.add(ShipFactory.createShip(Arrays.asList(newCell(2,0), newCell(2,1),
                newCell(2,2), newCell(2, 3), newCell(2, 4)), ShipType.CARRIER));
        player1Ships.add(ShipFactory.createShip(Arrays.asList(newCell(4,7), newCell(5,6),
                newCell(6,7)), ShipType.CRUISER));
        player1Ships.add(ShipFactory.createShip(Arrays.asList(newCell(5,7), newCell(6,7),
                newCell(7,7), newCell(8, 7)), ShipType.BATTLESHIP));
        return player1Ships;
    }

    public List<Ship> getPlayer2Ships() {
        List<Ship> player2Ships = new ArrayList<>();
        player2Ships.add(ShipFactory.createShip(Arrays.asList(newCell(0, 5), newCell(0, 6)),
                ShipType.DESTROYER));
        player2Ships.add(ShipFactory.createShip(Arrays.asList(newCell(2, 0), newCell(2, 1),
                newCell(2, 2)), ShipType.SUBMARINE));
        player2Ships.add(ShipFactory.createShip(Arrays.asList(newCell(4, 4), newCell(5, 4),
                newCell(6, 4), newCell(7, 4), newCell(8, 4)), ShipType.CARRIER));
        player2Ships.add(ShipFactory.createShip(Arrays.asList(newCell(2, 6), newCell(3, 6),
                newCell(4, 6)), ShipType.CRUISER));
        player2Ships.add(ShipFactory.createShip(Arrays.asList(newCell(5, 2), newCell(6, 2),
                newCell(7, 2), newCell(8, 2)), ShipType.BATTLESHIP));
        return player2Ships;
    }
    
    public Cell newCell(int x, int y) {
        return CellFactory.newCell(x, y);
    }
}