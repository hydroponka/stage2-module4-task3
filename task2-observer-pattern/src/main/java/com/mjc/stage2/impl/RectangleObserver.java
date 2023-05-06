package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    private RectangleWarehouse warehouse = RectangleWarehouse.getInstance();
    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        int id = rectangle.getId();
        double sideA = rectangle.getSideA();
        double sideB = rectangle.getSideB();
        RectangleValues values = warehouse.get(id);
        values.setPerimeter(sideA + sideB);
        values.setSquare(sideA * sideB);
        warehouse.put(id,values);
    }
    // Write your code here!
}
