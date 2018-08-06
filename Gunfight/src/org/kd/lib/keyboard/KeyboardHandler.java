package org.kd.lib.keyboard;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class KeyboardHandler {

    public final EventHandler<KeyEvent> keyPressed;
    public final EventHandler<KeyEvent> keyReleased;

    private final List<String> input = new ArrayList<>();

    public KeyboardHandler() {
        keyPressed = new EventHandler<>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                if (!getInput().contains(code))
                    input.add(code);
            }
        };

        keyReleased = new EventHandler<>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                input.remove(code);
            }
        };
    }

    public String getInput() {
        return input.size() > 0 ? input.get(input.size() - 1) : "";
    }
}
