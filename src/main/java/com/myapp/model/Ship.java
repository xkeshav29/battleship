package com.myapp.model;

import java.util.List;

public class Ship {
    private List<Cell> cells;
    private ShipType shipType;

    public Ship(List<Cell> cells, ShipType shipType) {
        this.cells = cells;
        this.shipType = shipType;
    }

    public boolean isValid() {
        //all cells belong to same row or column
        //all cells are within range of the rows and columns
        return cells.size() == shipType.getSize();
    }

    public boolean isDestroyed() {
        return cells.stream()
                .allMatch(Cell::isAttacked);
    }

    public List<Cell> getCells() {
        return cells;
    }
}
