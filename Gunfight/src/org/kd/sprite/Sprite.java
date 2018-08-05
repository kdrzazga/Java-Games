package org.kd.sprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polygon;

public interface Sprite {

    void draw(GraphicsContext gc);

    void moveLeft();

    void moveRight();

    void moveUp();

    void moveDown();

    short getSingleStep();

    void setSingleStep(short singleStep);

    short getX();

    void setPosition(short x, short y);

    short getY();

    void setXpoints(double xpoints[]);

    void setYpoints(double ypoints[]);

    double[] getXpoints();

    double[] getYpoints();

    Polygon getOutline();
}
