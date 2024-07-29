package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class WinScreenUi extends UiComponent {

    public WinScreenUi(Skin skin) {
        Image background = new Image(new Texture("shift.png"));
        root.setBackground(background.getDrawable());
    }
}
