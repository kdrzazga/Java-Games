package org.kd.model;

import javafx.animation.AnimationTimer;

public class GameAnimationTimer extends AnimationTimer {

    private final Game game;

    public GameAnimationTimer(Game game){
        this.game = game;
    }

    @Override
    public void handle(long now) {
        game.executeMainLoop(now);
    }

}
