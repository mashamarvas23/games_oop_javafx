package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {
    @Test
    public void whenPositionSuccess() {
        Cell expectedPosition = Cell.A1;
        BishopBlack bishopBlack = new BishopBlack(expectedPosition);
        Cell actualPosition = bishopBlack.position();
        assertThat(expectedPosition).isEqualTo(actualPosition);
    }

    @Test
    public void whenCopeSuccess() {
        Cell position = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(position);
        Figure copyBishopBlack = bishopBlack.copy(position);
        assertThat(bishopBlack.position()).isEqualTo(copyBishopBlack.position());
    }

    @Test
    public void whenWaySuccess() {
        Cell position = Cell.C1;
        Cell dest = Cell.G5;
        Cell[] expectedWays = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        BishopBlack bishopBlack = new BishopBlack(position);
        Cell[] actualWays = bishopBlack.way(dest);
        assertThat(expectedWays).isEqualTo(actualWays);
    }

    @Test
    public void whenWayThenThrowException() {
        Cell position = Cell.C1;
        Cell dest = Cell.C5;
        BishopBlack bishopBlack = new BishopBlack(position);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () ->
                        bishopBlack.way(dest));
        assertThat(exception.getMessage())
                .isEqualTo("Could not way by diagonal from %s to %s", position, dest);
    }
}