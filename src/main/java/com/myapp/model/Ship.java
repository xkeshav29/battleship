package com.myapp.model;

import java.util.List;

public class Ship {
    private List<Cell> cells;

    public Ship(List<Cell> cells) {
        this.cells = cells;
    }

    public boolean isDestroyed() {
        return cells.stream()
                .allMatch(Cell::isAttacked);
    }

    public boolean containsCell(Cell cell) {
        return cells.contains(cell);
    }

    public List<Cell> getCells() {
        return cells;
    }
}
