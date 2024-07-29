package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.GameSettings;

public class LoseScreenUi extends UiComponent {
    public LoseScreenUi(Skin skin) {
        Image background = new Image(new Texture("Group 396 (1).png"));


        root.setBackground(background.getDrawable());
    }
}
