package com.myapp.model;

import java.util.Objects;

public class Cell {
    private int x;
    private int y;
    private boolean isAttacked;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.isAttacked = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAttacked() {
        return isAttacked;
    }

    public void attack() {
        isAttacked = true;
    }

    @Override
    public String toString() {
        return isAttacked + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
