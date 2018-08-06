package org.kd.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.kd.lib.background.Background;
import org.kd.lib.keyboard.KeyboardHandler;

public class Game {

    private final GraphicsContext gc;
    private final Gunman gunman;
    private final Target target;

    private final KeyboardHandler keyboardHandler;

    public Game(GraphicsContext gc, Gunman gunman, KeyboardHandler keyboardHandler){
        this.gc = gc;

        this.gunman = gunman;
        this.target = new Target((short)(400), (short)(400));
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
        System.out.println(Background.getColor(gc.getCanvas(), 100, 100));
        gc.setFill(Color.ROSYBROWN);
        gc.fillRect(0, 0, 512,512);

    }

    private void drawTarget(long now, GraphicsContext gc) {
        target.move(now);
        target.draw(gc);
    }


}
