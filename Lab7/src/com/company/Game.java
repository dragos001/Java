package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private int arithmetic_progression_SIZE;


    public Game() {
        players = new ArrayList<>();
    }


    public synchronized Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public synchronized List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setmasa(this.board);
        player.setjoc(this);
    }
}
