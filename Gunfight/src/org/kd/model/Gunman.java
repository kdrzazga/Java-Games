package org.kd.model;

import javafx.scene.paint.Color;
import org.kd.lib.sprite.SpriteMono;

public class Gunman extends SpriteMono {

    public Gunman(short x, short y) {
        super(x, y, Color.WHITE);

        xPoints = new double[]{8, 8, 24, 25, 16, 20, 28};
        yPoints = new double[]{28, 29, 9, 28, 28, 41, 42};
    }
}
