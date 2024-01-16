package com.damning.chess.player;

import com.damning.chess.figure.Figure;

import java.util.ArrayList;
import java.util.List;

public class Player {
    byte color;
    List<Figure> figures;
    public void addFigure(Figure figure){
        figures.add(figure);
    }
    public List<Figure> getFigures(){
        return figures;
    }
    public Player(byte color){
        this.color = color;
        figures = new ArrayList<>();
    }
    public Player(byte color, List<Figure> figures){
        this.color = color;
        this.figures = figures;
    }

    public byte getColor() {
        return color;
    }
}
