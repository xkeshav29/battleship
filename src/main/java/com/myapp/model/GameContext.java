package com.myapp.model;


public class GameContext {

    private Player currentPlayer;
    private Player otherPlayer;

    public GameContext(Player currentPlayer, Player otherPlayer) {
        this.currentPlayer = currentPlayer;
        this.otherPlayer = otherPlayer;
    }

    public boolean fire(Cell target) {
        if(currentPlayer.fireMissile(otherPlayer.getBoard(), target)) {
            swapTurn();
            return true;
        }
        return false;
    }

    private void swapTurn() {
        Player temp = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = temp;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public boolean hasWon() {
        return otherPlayer.hasLost();
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
}
