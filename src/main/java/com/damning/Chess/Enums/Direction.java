package com.damning.chess.enums;

public enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT,
    UP_RIGHT,
    UP_LEFT,
    DOWN_RIGHT,
    DOWN_LEFT;
    public static Direction[] getDiagonals() {
        return new Direction[]{UP_RIGHT, UP_LEFT, DOWN_RIGHT, DOWN_LEFT};
    }
    public static Direction[] getVerticals () {
        return new Direction[]{UP, RIGHT, DOWN, LEFT};
    }
    public Direction getClockwise() {
        if (this == UP) return RIGHT;
        if (this == RIGHT) return DOWN;
        if (this == DOWN) return LEFT;
        if (this == LEFT) return UP;
        return null;
    }
    public Direction getCounterClockwise() {
        if (this == UP) return LEFT;
        if (this == RIGHT) return UP;
        if (this == DOWN) return RIGHT;
        if (this == LEFT) return DOWN;
        return null;
    }
}
