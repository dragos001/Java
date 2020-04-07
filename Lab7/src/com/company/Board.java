package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Token> tokenList;
    private long size;

    public Board(int valoare)
    {
        this.size =valoare;
        tokenList= new ArrayList<>();
        for(int i=0;i<valoare;i++)
            tokenList.add(new Token(i));
    }

    public long getSize()
    {
        return size;
    }



}
