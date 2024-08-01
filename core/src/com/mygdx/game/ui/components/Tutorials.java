package com.mygdx.game.ui.components;

import com.mygdx.game.ui.UiComponent;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.*;


public class Tutorials extends UiComponent {
    public Image[] tutorials;

    public static int ttrIdx;

    public Tutorials(Skin skin) {
        tutorials = new Image[] {
                new Image(skin, "tutorial1"),
                new Image(skin, "tutorial2"),
                new Image(skin, "tutorial3"),
                new Image(skin, "tutorial4"),
                new Image(skin, "tutorial5"),
                new Image(skin, "tutorial6"),
                new Image(skin, "tutorial7"),
                new Image(skin, "tutorial8"),
                new Image(skin, "tutorial9"),
                new Image(skin, "tutorial10"),
                new Image(skin, "tutorial11"),
                new Image(skin, "tutorial12"),
        };
        ttrIdx = 0;
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        tutorials[ttrIdx].draw(batch, parentAlpha);
    }

    public static void increase(){
        ttrIdx++;
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        for (Image tutorial : tutorials) {
            tutorial.setPosition(x, y);
        }
    }

    @Override
    public void setSize(float x, float y) {
        super.setPosition(x, y);
        for (Image tutorial : tutorials) {
           tutorial.setSize(x, y);
        }
    }
}
