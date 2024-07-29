package com.mygdx.game.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public abstract class UiComponent extends Actor {
    public Table root;

    public UiComponent() {
        root = new Table();
        root.setFillParent(true);
    }
}
