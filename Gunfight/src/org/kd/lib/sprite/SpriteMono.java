package org.kd.lib.sprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Arrays;

public class SpriteMono extends AbstractSprite {

    private Color color;

    public SpriteMono(short x, short y, Color color) {
        super(x, y);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);

        double[] xs = new double[xPoints.length];
        Arrays.setAll(xs, i -> xPoints[i] + this.x);

        double[] ys = new double[yPoints.length];
        Arrays.setAll(ys, j -> yPoints[j] + this.y);

        gc.fillPolygon(xs, ys, ys.length);
    }

}
