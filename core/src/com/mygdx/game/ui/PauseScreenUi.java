package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;

public class PauseScreenUi extends UiComponent{
    public Button ret;
    public Label retLabel;
    public Label levelsLabel;
    public Button exit;
    public Button level;
    public Label exitLabel;
    public PauseScreenUi(Skin skin) {
        Image image = new Image(new Texture("nuke13.1/nuke13.1/pausescreen.jpeg"));
        retLabel = new Label("return", skin, "molot-font", Color.BLACK);
        exitLabel = new Label("exit", skin, "molot-font", Color.BLACK);
        levelsLabel = new Label("levels", skin, "molot-font", Color.BLACK);
        exit = new Button(skin, "whitebutton");
        ret = new Button(skin, "whitebutton");
        level = new Button(skin, "whitebutton");
        root.setBackground(image.getDrawable());
        root.addActor(ret);
        ret.setPosition(1200, 450);
        ret.setSize(200, 90);
        ret.addActor(retLabel);
        retLabel.setAlignment(Align.center);
        retLabel.setPosition(40, 20);

        root.addActor(level);
        level.setPosition(800, 450);
        level.setSize(200, 90);
        level.addActor(levelsLabel);
        levelsLabel.setAlignment(Align.center);
        levelsLabel.setPosition(50, 20);

        root.addActor(exit);
        exit.setPosition(400, 450);
        exit.setSize(200, 90);
        exit.addActor(exitLabel);
        exitLabel.setAlignment(Align.center);
        exitLabel.setPosition(70, 20);

    }
}
