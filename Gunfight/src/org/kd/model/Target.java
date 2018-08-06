package org.kd.model;

import javafx.scene.paint.Color;
import org.kd.lib.sprite.SpriteMono;

public class Target extends SpriteMono {

    private long startNanoTime;
    private final short center = 232;

    public Target(short x, short y) {
        super(x, y, Color.YELLOW);

        xPoints = new double[]{0, 6, 12, 19, 27, 39, 45, 50, 55, 50, 46, 39, 27, 19, 12, 6, 0};
        yPoints = new double[]{20, 9, 5, 2, 0, 2, 5, 9, 20, 35, 38, 41, 43, 41, 38, 34, 20};

        this.startNanoTime = System.nanoTime();
    }

    public void move(long now){
        double t = 2 * (now - startNanoTime) / 1000000000.0;

        this.x = center + 128;
        this.y = (short)(center + 128 * Math.sin(t));
    }

}
