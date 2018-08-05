package org.kd.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.kd.lib.keyboard.KeyboardHandler;

public class Game {

    private final GraphicsContext gc;
    private final Gunman gunman;
    private final Target target;
    private long startNanoTime;
    private final KeyboardHandler keyboardHandler;
    private final short center = 232;

    public Game(GraphicsContext gc, Gunman gunman, KeyboardHandler keyboardHandler){
        this.gc = gc;
        this.startNanoTime = System.nanoTime();
        this.gunman = gunman;
        this.target = new Target((short)(center + 128), (short)(center + 128));
        this.keyboardHandler = keyboardHandler;
    }

    public void executeMainLoop(long now){
        updateGunmanPosition();
        clearCanvas();
        drawTarget(now, gc);
        gunman.draw(gc);
    }

    private void updateGunmanPosition() {
        if (keyboardHandler.getInput().contains("LEFT"))
            gunman.moveLeft();
        else if (keyboardHandler.getInput().contains("RIGHT"))
            gunman.moveRight();
        else if (keyboardHandler.getInput().contains("UP"))
            gunman.moveUp();
        else if (keyboardHandler.getInput().contains("DOWN"))
            gunman.moveDown();
    }

    private void clearCanvas() {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 512,512);
    }

    private void drawTarget(long now, GraphicsContext gc) {
        double t = 2 * (now - startNanoTime) / 1000000000.0;

        double x = center + 128;
        double y = center + 128 * Math.sin(t);
        gc.setFill(Color.BLUE);
        gc.fillOval(x, y, 30, 30);
    }


}
