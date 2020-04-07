package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private String nume;
    private Board masa;
    private List<Token> tokenList;
    private Game joc;
    public Player(String nume)
    {
        this.nume = nume;
        tokenList = new ArrayList<>();
    }

    public synchronized String getName() {
        return nume;
    }

    public void setName(String nume) {
        this.nume = nume;
    }

    public synchronized List<Token> getTokens() {
        return tokenList;
    }

    public void setTokens(List<Token> tokens) {
        this.tokenList = tokens;
    }

    public void setjoc(Game joc) {
        this.joc = joc;
    }
    public void setmasa(Board masa) {
        this.masa = masa;
    }

}
