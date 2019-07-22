package com.myapp.model;

public class GameBuilder {
    private String id;
    private Player player1;
    private Player player2;

    public GameBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public GameBuilder setPlayer1(Player player1) {
        this.player1 = player1;
        return this;
    }

    public GameBuilder setPlayer2(Player player2) {
        this.player2 = player2;
        return this;
    }

    public Game createGame() {
        return new Game(id, player1, player2);
    }
}