package com.myapp.model;

public class Player {

    private String id;
    private Board board;

    public boolean fireMissile(Board board, Cell cell) {
        return board.attack(cell);
    }

    public Player(String id, Board board) {
        this.id = id;
        this.board = board;
    }

    public String getId() {
        return id;
    }

    public Board getBoard() {
        return board;
    }

    public boolean hasLost() {
        return board.hasNoShipRemaining();
    }
}
