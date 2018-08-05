package org.kd.model;

import javafx.scene.paint.Color;
import org.kd.lib.sprite.SpriteMono;

public class Target extends SpriteMono {

    public Target(short x, short y) {
        super(x, y, Color.LIGHTGREY);

        xPoints = new double[]{0, 6, 12, 19, 27, 39, 45, 50, 55, 50, 46, 39, 27, 19, 12, 6, 0};
        yPoints = new double[]{20, 9, 5, 2, 0, 2, 5, 9, 20, 35, 38, 41, 43, 41, 38, 34, 20};
    }


}
