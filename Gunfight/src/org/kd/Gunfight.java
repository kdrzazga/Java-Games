package org.kd;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import org.kd.model.Game;
import org.kd.lib.keyboard.KeyboardHandler;
import org.kd.model.GameAnimationTimer;
import org.kd.model.Gunman;


public class Gunfight extends Application {

    private KeyboardHandler keyboardHandler;
    private GraphicsContext gc;
    private Scene scene;
    private Group root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        initGraphCtx();
        initScene(stage);
        initKeyboard(scene);

        Gunman gunman = new Gunman((short)50, (short)50);

        Game game = new Game(gc, gunman, keyboardHandler);

        AnimationTimer animationTimer = new GameAnimationTimer(game);
        animationTimer.start();

        stage.show();
    }

    private void initScene(Stage theStage) {
        theStage.setTitle("Mock Game");
        scene = new Scene(root);
        theStage.setScene(scene);
    }

    private void initGraphCtx() {
        root = new Group();
        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
    }

    private void initKeyboard(Scene theScene) {
        keyboardHandler = new KeyboardHandler();

        theScene.setOnKeyPressed(keyboardHandler.keyPressed);
        theScene.setOnKeyReleased(keyboardHandler.keyReleased);
    }
}
