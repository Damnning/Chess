package com.damning.chess.player;

import com.damning.chess.figure.Figure;

import java.util.List;

public class Player {
    byte color;
    List<Figure> figures;
    public Player(byte color){
        this.color = color;
    }
    public Player(byte color, List<Figure> figures){
        this.color = color;
        this.figures = figures;
    }
}
