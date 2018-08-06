package org.kd.lib.background;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import org.kd.exceptions.NotImplementedYetException;
import org.kd.lib.general.Numbers;
import org.kd.lib.sprite.Sprite;

public class Background {
    private static final SnapshotParameters SP = new SnapshotParameters();
    private static final WritableImage WI = new WritableImage(1, 1);
    private static final PixelReader PR = WI.getPixelReader();

    private Background() {
    }

    public static int getArgb(Node n, double x, double y) {
        synchronized (WI) {
            Rectangle2D r = new Rectangle2D(x, y, 1, 1);
            SP.setViewport(r);
            n.snapshot(SP, WI);
            return PR.getArgb(0, 0);
        }
    }

    public static Color getColor(Node n, double x, double y) {
        synchronized (WI) {
            Rectangle2D r = new Rectangle2D(x, y, 1, 1);
            SP.setViewport(r);
            n.snapshot(SP, WI);
            return PR.getColor(0, 0);
        }
    }

    public static boolean collideWithBackground(Canvas canvas, Color backgroundColor, Sprite sprite) {
        long minX = Math.round(Numbers.getMin(sprite.getXpoints()));
        long minY = Math.round(Numbers.getMin(sprite.getYpoints()));
        long maxX = Math.round(Numbers.getMax(sprite.getXpoints()));
        long maxY = Math.round(Numbers.getMax(sprite.getYpoints()));

        //Rectangle2D circumscribedRect = new Rectangle2D(minX, minY, width, height);
        var wrapper = new Object() {
            boolean collided = false;
        };

        throw new NotImplementedYetException("The code below checks in fact if sprite points are different from background." +
                " It will always return false.");
        /*
        LongStream.range(minX, maxX).forEach(x -> {
            LongStream.range(minY, maxY).forEach(y ->
            {
                if (!getColor(canvas, x, y).equals(backgroundColor))
                    wrapper.collided = true;
            });
        });

        return wrapper.collided;*/
    }
}
