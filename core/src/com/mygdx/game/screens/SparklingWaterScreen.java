package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.AudioManager;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.managers.MemoryManager;

public class SparklingWaterScreen extends BaseScreen {
    SparklingWaterScreenUi ui;

    float waterLevel;
    long startTime;
    float fullFillTime = 10 * 1000; // in seconds
    float maxWaterHeight = 336; // in pixels

    public SparklingWaterScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new SparklingWaterScreenUi(nuclearGame.skin);

        stage.addActor(ui.root);
        stage.addListener(stageClickListener);
    }

    @Override
    public void show() {
        super.show();
        waterLevel = 0;
        startTime = TimeUtils.millis();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        long time = TimeUtils.millis() - startTime;
        waterLevel = time / fullFillTime;

        ui.waterImage.setDrawable(new TextureRegionDrawable(new TextureRegion(
                nuclearGame.skin.getRegion("tarkhun"), 0, (int) (maxWaterHeight - waterLevel * maxWaterHeight), 200, (int) (waterLevel * maxWaterHeight)
        )));
        ui.waterImage.setHeight(waterLevel * maxWaterHeight);
        if (time > fullFillTime) {
            nuclearGame.setScreen(nuclearGame.gameScreen);
        }

    }

    ClickListener stageClickListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            float decreasePart = waterLevel * maxWaterHeight / ui.markImage.getY();
            System.out.println("decrease part: " + decreasePart);
            nuclearGame.gameScreen.ui.fatigue.decreaseValue(
                    nuclearGame.gameScreen.ui.fatigue.getCurrentValue() * decreasePart
            );
            nuclearGame.setScreen(nuclearGame.gameScreen);
            if (MemoryManager.loadIsMusicOn()) AudioManager.playMusic(AudioManager.gameScreenBackgroundMusic);
        }
    };

}
