package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int x1 = position.getX();
        int y1 = position.getY();
        int x2 = dest.getX();
        int y2 = dest.getY();
        int size = Math.abs(x2 - x1);
        Cell[] mass = new Cell[size];
        int deltaX = (x2 - x1)/Math.abs((x2 - x1));
        int deltaY = (y2 - y1)/Math.abs(y2 - y1);
        for (int i = 0; i < size; i++) {
            mass[i] = Cell.findBy(x1 + deltaX * (i + 1), y1 + deltaY * (i + 1));
        }
        return mass;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int x1 = source.getX();
        int y1 = source.getY();
        int x2 = dest.getX();
        int y2 = dest.getY();
        return (Math.abs(x2 - x1) == Math.abs(y2 - y1));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
