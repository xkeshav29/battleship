package com.myapp.factory;

import com.myapp.model.Board;
import com.myapp.model.Cell;
import com.myapp.model.Ship;

import java.util.List;
import java.util.stream.IntStream;

public class BoardFactory {

    public static Board createBoard(List<Ship> ships) {
        Cell[][] cells = new Cell[10][10];
        IntStream.range(0, cells.length)
                .forEach(r -> IntStream.range(0, cells.length)
                        .forEach(c -> cells[r][c] = CellFactory.newCell(r, c)));
        ships.stream()
                .flatMap(ship -> ship.getCells().stream())
                .forEach(cell -> cells[cell.getX()][cell.getY()] = cell);
        return new Board(cells, ships);
    }
}
