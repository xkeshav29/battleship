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

    private boolean isAttacked(Cell cell) {
        return cells[cell.getX()][cell.getY()].isAttacked();
    }

    public boolean attack(Cell cell) {
        if(isAttacked(cell))
            return false;
        cells[cell.getX()][cell.getY()].attack();
        return true;
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
}
