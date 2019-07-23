package com.myapp.factory;

import com.myapp.exception.InvalidShipException;
import com.myapp.model.Cell;
import com.myapp.model.Ship;
import com.myapp.model.ShipType;

import java.util.List;


public class ShipFactory {

    public static Ship createShip(List<Cell> cells, ShipType shipType) {
        Ship ship = new Ship(cells, shipType);
        if(!ship.isValid())
            throw new InvalidShipException(String.format("Invalid Ship. Cells required %s Found %s", shipType.getSize(),
                    cells.size()));
        return ship;
    }

}
