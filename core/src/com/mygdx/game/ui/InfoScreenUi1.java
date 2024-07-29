package com.mygdx.game.ui;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.GameSettings;

public class InfoScreenUi1 extends UiComponent {

    public Image station;

    public InfoScreenUi1(Skin skin) {
        station = new Image(new Texture("Group 396.png"));
        root.setBackground(station.getDrawable());
    }
}
