package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenIsDiagonal() {
        BishopBlack bb1 = new BishopBlack(Cell.C8);
        Cell dest = Cell.G4;
        Cell pos = bb1.position();
        assertThat(bb1.isDiagonal(pos, dest), is(true));
    }

    @Test
    public void whenIsNotDiagonal() {
        BishopBlack bb1 = new BishopBlack(Cell.C8);
        Cell dest = Cell.A1;
        Cell pos = bb1.position();
        assertThat(bb1.isDiagonal(pos, dest), is(false));
    }

    @Test()
    public void whenIsValidWay() {
        BishopBlack bb1 = new BishopBlack(Cell.C1);
        Cell dest = Cell.E3;
        Cell[] steps = new Cell[]{Cell.D2, Cell.E3};
        Cell[] way1 = bb1.way(dest);
        assertThat(way1, is(steps));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenIsNotValidWay() {
        BishopBlack bb1 = new BishopBlack(Cell.C8);
        Cell dest = Cell.A1;
        bb1.way(dest);
    }
}
