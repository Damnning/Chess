package com.damning.chesst.playert;

import com.damning.chesst.figuret.Figure;

import java.util.ArrayList;
import java.util.List;

public class Player {
    byte color;
    List<Figure> figures;

    public Player(byte color) {
        this.color = color;
        figures = new ArrayList<>();
    }

    public byte getColor() {
        return color;
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
    }

    public List<Figure> getFigures() {
        return figures;
    }

}
