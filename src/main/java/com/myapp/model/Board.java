package com.myapp.model;

import java.util.List;
import java.util.stream.IntStream;

public class Board {

    private Cell[][] cells;
    private List<Ship> ships;

    public Board(Cell[][] cells, List<Ship> ships) {
        this.cells = cells;
        this.ships = ships;
    }

    public boolean hasNoShipRemaining() {
        return ships.stream()
                .allMatch(Ship::isDestroyed);
    }

    public boolean attack(Cell cell) {
        Cell target = cells[cell.getX()][cell.getY()];
        target.attack();
        return ships.stream()
                .flatMap(ship -> ship.getCells().stream())
                .anyMatch(c -> c.equals(target));
    }

    public void display() {
        IntStream.range(0, cells.length)
                .forEach(r -> {
                    System.out.println();
                    System.out.println();
                    IntStream.range(0, cells.length)
                            .forEach(c -> System.out.print(cells[r][c]));
                });
    }

    public boolean isValid() {
        //no two ships have same cell
        return ships.stream().allMatch(Ship::isValid);
    }
}
