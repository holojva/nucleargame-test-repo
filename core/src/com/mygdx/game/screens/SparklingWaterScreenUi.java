package com.mygdx.game.screens;

import com.mygdx.game.ui.UiComponent;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import java.util.Random;

public class SparklingWaterScreenUi extends UiComponent {
    Image glassImage;
    Image markImage;
    Image waterImage;
    Table table;

    public SparklingWaterScreenUi(Skin skin) {
        glassImage = new Image(skin, "glass");
        markImage = new Image(skin, "tab");
        waterImage = new Image(skin, "tarkhun");
        Image background = new Image(skin, "coffeescreen-bg");
        table = new Table();
        Random r = new Random();

        root.setBackground(background.getDrawable());
        root.addActor(waterImage);
        waterImage.setPosition(1269, 340);
        root.addActor(table);
        table.setPosition(1093, 204);
        table.setSize(600, 600);
        table.add(glassImage);
        glassImage.setPosition(1140,374);
        glassImage.setSize(400, 200);
        table.addActor(markImage);
        markImage.setPosition(234, 470 - r.nextInt(30));
        markImage.setSize(180, 12);

    }
}
