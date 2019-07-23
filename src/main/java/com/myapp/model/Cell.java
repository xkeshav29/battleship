package com.myapp.model;

import com.myapp.exception.TargetAlreadyAttackedException;

import java.util.Objects;

public class Cell {
    private int x;
    private int y;
    private boolean isAttacked;
    private int boardSize;

    public Cell(int x, int y, int boardSize) {
        this.x = x;
        this.y = y;
        this.boardSize = boardSize;
        this.isAttacked = false;
    }

    public boolean isValid (){
        return (x>=0 && x<boardSize) && (y>=0 && y<boardSize);
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
        if(this.isAttacked)
            throw new TargetAlreadyAttackedException(String.format("%s %s already attacked", x, y));
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
