package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.GameSettings;
import com.mygdx.game.ui.components.*;

public class Scheme extends Actor {
    public Image[] schemes;
    float accumulator;
    int schemeIdx;

    public Scheme(Skin skin) {
        schemes = new Image[] {
          new Image(skin, "frame1"),
          new Image(skin, "frame2"),
          new Image(skin, "frame3")
        };
        schemeIdx = 0;
    }

    @Override
    public void act(float delta) {
        accumulator += delta;
        if (accumulator >= GameSettings.schemeCoolDown) {
            accumulator -= GameSettings.schemeCoolDown;
            increase();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        schemes[schemeIdx].draw(batch, parentAlpha);
    }

    private void increase() {
        schemeIdx += 1;
        if (schemeIdx >= schemes.length) schemeIdx = 0;
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        for (Image scheme : schemes) {
            scheme.setPosition(x, y);
        }
    }

    @Override
    public void setSize(float x, float y) {
        super.setPosition(x, y);
        for (Image scheme : schemes) {
            scheme.setSize(x, y);
        }
    }
}
