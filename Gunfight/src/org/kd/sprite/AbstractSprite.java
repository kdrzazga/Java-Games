package org.kd.sprite;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

abstract class AbstractSprite implements Sprite {

    protected short x;
    protected short y;
    private short singleStep = 3;
    protected double[] xPoints;
    protected double[] yPoints;

    public AbstractSprite(short x, short y) {
        this.x = x;
        this.y = y;
    }

    public AbstractSprite(short x, short y, double[] xPoints, double[] yPoints) {
        this.x = x;
        this.y = y;
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    @Override
    public void moveLeft() {
        this.x -= singleStep;
    }

    @Override
    public void moveRight() {
        this.x += singleStep;
    }

    @Override
    public void moveUp() {
        this.y -= singleStep;
    }

    @Override
    public void moveDown() {
        this.y += singleStep;
    }

    public Polygon getOutline() {
        double[] outline = new double[this.xPoints.length + this.yPoints.length];
        for (int i = 0; i < xPoints.length; i++) {
            outline[2 * i] = xPoints[i];
            outline[2 * i + 1] = yPoints[i];
        }
        return new Polygon(outline);

    }

    boolean checkCollision(AbstractSprite anotherSprite) {
        var wrapper = new Object() {
            boolean collided = false;
        };

        anotherSprite.getVertices().forEach(vertex -> {
            if (this.getOutline().contains(vertex))
                wrapper.collided = true;
        });

        return wrapper.collided;
    }

    @Override
    public short getSingleStep() {
        return singleStep;
    }

    @Override
    public void setSingleStep(short singleStep) {
        this.singleStep = singleStep;
    }

    @Override
    public short getX() {
        return x;
    }

    @Override
    public short getY() {
        return y;
    }

    @Override
    public void setPosition(short x, short y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setXpoints(double[] xpoints) {
        this.xPoints = xpoints;
    }

    @Override
    public void setYpoints(double[] ypoints) {
        this.yPoints = ypoints;
    }

    @Override
    public double[] getXpoints() {
        return this.xPoints;
    }

    @Override
    public double[] getYpoints() {
        return this.yPoints;
    }

    public List<Point2D> getVertices() {
        List<Point2D> vertices = new ArrayList<>(this.xPoints.length);
        IntStream.range(0, this.xPoints.length).forEach(i -> vertices.add(new Point2D(xPoints[i], yPoints[i])));
        return vertices;
    }
}