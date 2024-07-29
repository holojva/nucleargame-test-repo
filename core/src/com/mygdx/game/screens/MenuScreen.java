package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.AudioManager;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.ui.MenuScreenUi;

public class MenuScreen extends BaseScreen {
    MenuScreenUi ui;

    public MenuScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new MenuScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);

        ui.exitButton.addListener(exitButtonClickedListener);
        ui.startButton.addListener(startButtonClickedListener);
        ui.settingsButton.addListener(settingsButtonClickedListener);
        if (MemoryManager.loadIsMusicOn()) AudioManager.playMusic(AudioManager.levelScreenBackgroundMusic);

    }

    ClickListener exitButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            Gdx.app.exit();
        }
    };

    ClickListener startButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.levelsScreen);
        }
    };

    ClickListener settingsButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.settingsScreen);
        }
    };
}
