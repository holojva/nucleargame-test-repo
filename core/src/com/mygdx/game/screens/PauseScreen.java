package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.GameScreenUi;
import com.mygdx.game.ui.PauseScreenUi;
import com.mygdx.game.ui.components.Potentiometer;

public class PauseScreen extends BaseScreen{
    PauseScreenUi ui;
    public PauseScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new PauseScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);
        ui.ret.addListener(retClickedListener);
        ui.exit.addListener(exitClickedListener);
        ui.level.addListener(levelsClickedListener);
    }
    ClickListener retClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.gameScreen);
        }
    };
    ClickListener levelsClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.levelsScreen);
            nuclearGame.gameScreen.ui.kernels.setValue(0f);
            nuclearGame.gameScreen.ui.speedControl.spinnerImage.setRotation(180);
            nuclearGame.gameScreen.ui.generatedPower.setCurrentValue(0);
            nuclearGame.gameScreen.xValues.clear();
            nuclearGame.gameScreen.yValues.clear();
            nuclearGame.gameScreen.ui.closeToFail.setCurrentValue(0);
            nuclearGame.gameScreen.ui.fatigue.setCurrentValue(0);
            nuclearGame.gameScreen.ui.batteryCharge.setCurrentValue(0);
            nuclearGame.gameScreen.ui.battery.setState((byte) 1);
            nuclearGame.gameScreen.ui.SPOT.setState((byte) 0);
        }
    };
    ClickListener exitClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.pauseScreen);
            Gdx.app.exit();
        }
    };
}
