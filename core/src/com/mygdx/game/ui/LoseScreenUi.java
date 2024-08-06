package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.GameSettings;

public class LoseScreenUi extends UiComponent {
    public LoseScreenUi() {
        Image background = new Image(new Texture("nuke14/Group 396 (1).png"));


        root.addActor(background);
        background.setSize(GameSettings.SCREEN_WIDTH, GameSettings.SCREEN_HEIGHT);
    }
}
