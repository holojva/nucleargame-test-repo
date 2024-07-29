package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.GameScreenUi;
import com.mygdx.game.ui.PauseScreenUi;

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
