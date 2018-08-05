package org.kd.lib.sprite;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import org.kd.lib.general.Numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

abstract class AbstractSprite implements Sprite {

    protected short x;
    protected short y;
    private short singleStep = 3;
    private final static double NO_LIMIT = -1;
    protected double[] xPoints;
    protected double[] yPoints;
    protected Point2D topLeftMoveLimit;
    protected Point2D bottomRightMoveLimit;

    public AbstractSprite(short x, short y) {
        init(x, y);
    }

    private void init(short x, short y) {
        this.x = x;
        this.y = y;
        setMoveLimits(new Point2D(0, 0), new Point2D(350, 512));
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
        if (!isWithinBounds()) this.x += singleStep;
    }

    @Override
    public void moveRight() {
        this.x += singleStep;
        if (!isWithinBounds()) this.x -= singleStep;
    }

    @Override
    public void moveUp() {
        this.y -= singleStep;
        if (!isWithinBounds()) this.y += singleStep;
    }

    @Override
    public void moveDown() {
        this.y += singleStep;
        if (!isWithinBounds()) this.y -= singleStep;
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

        for (Point2D vertex : anotherSprite.getVertices()) {
            if (this.getOutline().contains(vertex))
                wrapper.collided = true;
        }

        return wrapper.collided;
    }

    public void setMoveLimits(Point2D topLeft, Point2D bottomRight) {
        this.topLeftMoveLimit = topLeft;
        this.bottomRightMoveLimit = bottomRight;
    }

    public double computeWidth() {
        return computeMaxX() - computeMinX();
    }

    public double computeHeight() {
        return computeMaxY() - computeMinY();
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

    public double computeMinX() {
        return Numbers.getMin(this.xPoints);
    }

    public double computeMaxX() {
        return Numbers.getMax(this.xPoints);
    }

    public double computeMinY() {
        return Numbers.getMin(this.yPoints);
    }

    public double computeMaxY() {
        return Numbers.getMax(this.yPoints);
    }

    private boolean isWithinBounds() {
        return
                this.x >= topLeftMoveLimit.getX()
                        && this.x + computeWidth() <= bottomRightMoveLimit.getX()
                        && this.y >= topLeftMoveLimit.getY()
                        && this.y + computeHeight() <= bottomRightMoveLimit.getY();
    }
}