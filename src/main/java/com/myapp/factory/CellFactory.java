package com.myapp.factory;

import com.myapp.exception.InvalidCellException;
import com.myapp.model.Cell;

public class CellFactory {

    private static final int BOARD_SIZE = 10;

    public static Cell newCell(int x, int y) {
        Cell cell = new Cell(x, y, BOARD_SIZE);
        if(!cell.isValid())
            throw new InvalidCellException("Invalid Cell:", x, y);
        return cell;
    }

}
