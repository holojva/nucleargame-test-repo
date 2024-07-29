package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.AudioManager;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.TutorialScreenUi;

public class TutorialScreen extends BaseScreen {
    TutorialScreenUi ui;
    public TutorialScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new TutorialScreenUi(nuclearGame.skin);
        stage.addActor(ui);
        stage.addListener(tutorialClickedListener);

    }

    ClickListener tutorialClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            TutorialScreenUi.state += 1;
        }
    };
}
