package com.mygdx.game.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.LoseScreenUi;

public class LoseScreen extends BaseScreen {
    LoseScreenUi ui;
    public LoseScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new LoseScreenUi();
        stage.addActor(ui.root);
        stage.addListener(loseButtonClickedListener);
    }

    ClickListener loseButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.levelsScreen);
            nuclearGame.gameScreen.loos = false;
        }
    };
}
