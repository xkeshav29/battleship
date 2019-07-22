package com.myapp;

import com.myapp.model.Cell;
import com.myapp.model.Ship;
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
        List<Ship> player1Ships = new ArrayList<>();
        player1Ships.add(new Ship(Arrays.asList(new Cell(0,4), new Cell(0,5), new Cell(0,6))));
        player1Ships.add(new Ship(Arrays.asList(new Cell(3,3), new Cell(3,3))));
        player1Ships.add(new Ship(Arrays.asList(new Cell(2,0), new Cell(2,1), new Cell(2,2), new Cell(2, 3), new Cell(2, 4))));
        player1Ships.add(new Ship(Arrays.asList(new Cell(4,7), new Cell(5,6), new Cell(6,7))));
        player1Ships.add(new Ship(Arrays.asList(new Cell(5,7), new Cell(6,7), new Cell(7,7), new Cell(8, 7))));
        List<Ship> player2Ships = new ArrayList<>();
        player2Ships.add(new Ship(Arrays.asList(new Cell(0,5), new Cell(0,6))));
        player2Ships.add(new Ship(Arrays.asList(new Cell(2,0), new Cell(2,1), new Cell(2,2))));
        player2Ships.add(new Ship(Arrays.asList(new Cell(4,4), new Cell(5,4), new Cell(6,4), new Cell(7, 4), new Cell(8, 4))));
        player2Ships.add(new Ship(Arrays.asList(new Cell(2,6), new Cell(3,6), new Cell(4,6))));
        player2Ships.add(new Ship(Arrays.asList(new Cell(5,2), new Cell(6,2), new Cell(7,2), new Cell(8, 2))));
        gameService.startGame(player1Id, player2Id, player1Ships, player2Ships);
    }
}