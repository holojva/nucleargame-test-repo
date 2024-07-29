package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GameSettings;

public class TutorialScreenUi extends UiComponent {
    public static byte state = 0;
    public TutorialScreenUi(Skin skin) {
        Image background = new Image(new Texture(tutorialGetter(TutorialScreenUi.state)));
        root.setBackground(background.getDrawable());
    }
    private String tutorialGetter(byte state) {
        return GameSettings.tutorialTexts[state];
    }
}

