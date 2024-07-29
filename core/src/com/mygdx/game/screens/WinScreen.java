package com.mygdx.game.screens;

import com.mygdx.game.AudioManager;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.ui.WinScreenUi;

public class WinScreen extends BaseScreen {
    WinScreenUi ui;
    public WinScreen(NuclearGame nuclearGame) {
        super(nuclearGame);
        ui = new WinScreenUi(nuclearGame.skin);

        stage.addActor(ui.root);
        if (MemoryManager.loadPassedLevel() == 1) {nuclearGame.gameScreen.setCurrentLevel(2);}
        if (MemoryManager.loadPassedLevel() == 3) {nuclearGame.gameScreen.setCurrentLevel(4);}
        if (MemoryManager.loadPassedLevel() == 5) {nuclearGame.gameScreen.setCurrentLevel(6);}
    }
}
