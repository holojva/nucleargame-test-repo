package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class LevelsScreenUi extends UiComponent {
    public Image level1;
    public Image level2;
    public Image level3;
    public Image level4;
    public Button exit;
    public Label exitLabel;
    private final Skin skin;

    public LevelsScreenUi(Skin skin) {
        this.skin = skin;
        Table table = new Table();
        Label title = new Label("Choose NPP", skin, "molot-font", Color.BLACK);
        Image image = new Image(skin, "levelscreen-bg");
        Image level11 = new Image(skin, "obninsk-level-color");
        level1 = new Image();
        level1.setDrawable(level11.getDrawable());
        level3 = new Image(new Image(skin, "beloyarsk-level-bw").getDrawable());


        level2 = new Image(new Image(skin, "bilibino-level-bw").getDrawable());
        level4 = new Image(new Image(skin, "chernobyl-level-bw").getDrawable());
        exit = new Button(skin,"whitebutton");
        exitLabel = new Label("return", skin, "molot-font", Color.BLACK);

        root.setBackground(image.getDrawable());

        root.addActor(title);
        title.setAlignment(Align.center);
        title.setFontScale(2.5f);
        title.setColor(Color.BLACK);
        title.setPosition(420, 900);
        title.setSize(1000, 100);

        root.addActor(table);
        table.setPosition(79, 370);
        table.setSize(1780, 420);

        table.addActor(level1);
        level1.setPosition(30, 18);
        level1.setSize(390, 390);
        table.addActor(level2);
        level2.setPosition(470, 18);
        level2.setSize(390, 390);
        table.addActor(level3);
        level3.setPosition(910, 18);
        level3.setSize(390, 390);
        table.addActor(level4);
        level4.setPosition(1360, 18);
        level4.setSize(390, 390);

        root.addActor(exit);
        exit.setPosition(820, 120);
        exit.setSize(200, 100);

        root.addActor(exitLabel);
        exitLabel.setPosition(852, 120);
        exitLabel.setSize(200, 100);
    }

    public void updateNpp2(boolean comp) {
        level2.setDrawable(new Image(
                skin, comp ? "bilibino-level-color" : "bilibino-level-bw").getDrawable()
        );
    }

    public void updateNpp3(boolean comp) {
        level3.setDrawable(new Image(
                skin, comp ? "beloyarsk-level-color" : "beloyarsk-level-bw").getDrawable()
        );
    }

    public void updateNpp4(boolean comp) {
        level4.setDrawable(new Image(
                skin, comp ? "chernobyl-level-color" : "chernobyl-level-bw").getDrawable()
        );
    }
}
