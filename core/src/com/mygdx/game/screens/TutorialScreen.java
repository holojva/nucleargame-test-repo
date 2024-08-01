package com.mygdx.game.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.TutorialScreenUi;
import com.mygdx.game.ui.components.Tutorials;

public class TutorialScreen extends BaseScreen {
    TutorialScreenUi ui;

    public TutorialScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new TutorialScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);
        stage.addListener(tutorialClickedListener);
    }



    ClickListener tutorialClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            Tutorials.increase();
            if (Tutorials.ttrIdx >= 12) {
                nuclearGame.setScreen(nuclearGame.gameScreen);
                Tutorials.ttrIdx = 0;
            }
        }
    };
}
