package com.mygdx.game.screens;

import com.mygdx.game.NuclearGame;
import com.mygdx.game.ui.LoseScreenUi;

public class LoseScreen extends BaseScreen {
    LoseScreenUi ui;
    public LoseScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new LoseScreenUi(nuclearGame.skin);
    }
}
