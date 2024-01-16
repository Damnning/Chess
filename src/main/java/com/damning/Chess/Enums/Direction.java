package com.damning.chess.enums;

/**
 * Directions for getting neighbor cells
 */
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

    public static Direction[] getVerticals() {
        return new Direction[]{UP, RIGHT, DOWN, LEFT};
    }

    private Direction getHalf(Direction d1, Direction d2, Direction d3, Direction d4, Direction d5, Direction d6, Direction d7, Direction d8) {
        return switch (this) {
            case UP -> d1;
            case UP_RIGHT -> d2;
            case RIGHT -> d3;
            case DOWN_RIGHT -> d4;
            case DOWN -> d5;
            case DOWN_LEFT -> d6;
            case LEFT -> d7;
            case UP_LEFT -> d8;
        };
    }

    public Direction getClockwiseHalf() {
        return getHalf(UP_RIGHT, RIGHT, DOWN_RIGHT, DOWN, DOWN_LEFT, LEFT, UP_LEFT, UP);
    }

    public Direction getCounterClockwiseHalf() {
        return getHalf(UP_LEFT, UP, UP_RIGHT, RIGHT, DOWN_RIGHT, DOWN, DOWN_LEFT, LEFT);
    }

    public Direction getHalf() {
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
