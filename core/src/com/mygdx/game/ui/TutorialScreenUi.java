package com.mygdx.game.ui;

import com.mygdx.game.ui.components.Tutorials;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.GameSettings;
import com.mygdx.game.ui.components.*;

public class TutorialScreenUi extends UiComponent {
    public Tutorials tutorials;

    public TutorialScreenUi(Skin skin) {
        tutorials = new Tutorials(skin);
        root.addActor(tutorials);
        tutorials.setSize(GameSettings.SCREEN_WIDTH, GameSettings.SCREEN_HEIGHT);
    }
}
