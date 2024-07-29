package com.mygdx.game.screens;
import com.badlogic.gdx.Gdx;
import static com.mygdx.game.GameSettings.TextInfoScreenOne;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.AudioManager;
import com.mygdx.game.GameSettings;
import com.mygdx.game.NuclearGame;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.screens.infoScreens.InfoScreen;
import com.mygdx.game.screens.infoScreens.InfoScreen12;
import com.mygdx.game.ui.LevelsScreenUi;

public class LevelsScreen extends BaseScreen {
    public LevelsScreenUi ui;
    GameScreen gameScreen;
    NuclearGame nuke;
    SettingsScreen settingsScreen;
    LevelsScreenUi levelsScreenui;
    public static InfoScreen12 infoScreen12;

    public static InfoScreen infoScreen;

    public LevelsScreen(NuclearGame nuclearGame) {


        super(nuclearGame);
        infoScreen12 = new InfoScreen12(nuclearGame, TextInfoScreenOne, "menuscreen-bg");
        gameScreen = new GameScreen(nuclearGame);
        nuke = new NuclearGame();
        ui = new LevelsScreenUi(nuclearGame.skin);
        stage.addActor(ui.root);

        ui.exitLabel.addListener(exitButtonClickedListener);
        ui.level1.addListener(levelOneButtonClickedListener);
        ui.level2.addListener(levelTwoButtonClickedListener);
        ui.level3.addListener(levelThreeButtonClickedListener);
        ui.level4.addListener(levelFourButtonClickedListener);
    }

    @Override
    public void show() {
        super.show();
        updateLevelsButton();

    }

    ClickListener exitButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.menuScreen);
        }
    };
    ClickListener levelOneButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.infoScreen);
            if (MemoryManager.loadIsMusicOn()) AudioManager.playMusic(AudioManager.infoScreenBackgroundMusic);
            nuclearGame.gameScreen.setCurrentLevel(1);
            infoScreen = new InfoScreen(nuclearGame);
            infoScreen12 = new InfoScreen12(nuclearGame, textInfoFinal(), pictureInfoFinal());
            nuclearGame.setScreen(infoScreen);
        }
    };
    ClickListener levelTwoButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.infoScreen);
            if (MemoryManager.loadIsMusicOn()) AudioManager.playMusic(AudioManager.infoScreenBackgroundMusic);

            if (MemoryManager.loadPassedLevel() >= 2) {
                nuclearGame.gameScreen.setCurrentLevel(3);
                infoScreen = new InfoScreen(nuclearGame);
                infoScreen12 = new InfoScreen12(nuclearGame, textInfoFinal(), pictureInfoFinal());
                nuclearGame.setScreen(infoScreen);
            }
        }
    };
    ClickListener levelThreeButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.infoScreen);
            if (MemoryManager.loadIsMusicOn()) AudioManager.playMusic(AudioManager.infoScreenBackgroundMusic);
            if (MemoryManager.loadPassedLevel() >= 4) {
                nuclearGame.gameScreen.setCurrentLevel(5);
                infoScreen = new InfoScreen(nuclearGame);
                infoScreen12 = new InfoScreen12(nuclearGame, textInfoFinal(), pictureInfoFinal());
                nuclearGame.setScreen(infoScreen);
            }
        }
    };
    ClickListener levelFourButtonClickedListener = new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            nuclearGame.setScreen(nuclearGame.infoScreen);
            if (MemoryManager.loadIsMusicOn()) AudioManager.playMusic(AudioManager.infoScreenBackgroundMusic);
            if (MemoryManager.loadPassedLevel() >= 6) {
                nuclearGame.gameScreen.setCurrentLevel(7);
                infoScreen = new InfoScreen(nuclearGame);
                infoScreen12 = new InfoScreen12(nuclearGame, textInfoFinal(), pictureInfoFinal());
                nuclearGame.setScreen(infoScreen);
            }
        }
    };

    private void updateLevelsButton() {
        int passedLevel = MemoryManager.loadPassedLevel();
        System.out.println("passed level: "  + passedLevel );
        switch (passedLevel) {
            case 8:
            case 6:
                ui.updateNpp4(true);
            case 4:
                ui.updateNpp3(true);
            case 2:
                ui.updateNpp2(true);
        }
    }
    public String textInfo(){
        System.out.println(nuclearGame.gameScreen.getCurrentLevel());
        switch (nuclearGame.gameScreen.getCurrentLevel()){
            case 2:
                System.out.println("loadPassedLevel: 1");
                return GameSettings.TextInfoScreenOne;
            case 4:
                System.out.println("loadPassedLevel: 2");
                return GameSettings.TextInfoScreenTwo;
            case 6:
                System.out.println("loadPassedLevel: 3");
                return GameSettings.TextInfoScreenThree;
            case 8:
                System.out.println("loadPassedLevel: 4");
                return GameSettings.TextInfoScreenFour;
            default:
                return GameSettings.Err;
        }
    }
    public String textInfoFinal(){
        System.out.println(nuclearGame.gameScreen.getCurrentLevel());
        switch (nuclearGame.gameScreen.getCurrentLevel()){
            case 1:
                System.out.println("loadPassedLevel: 1");
                return GameSettings.TextInfoScreenOneFinal;
            case 2:
                System.out.println("loadPassedLevel: 2");
                return GameSettings.TextInfoScreenTwoFinal;
            case 3:
                System.out.println("loadPassedLevel: 3");
                return GameSettings.TextInfoScreenThreeFinal;
            case 4:
                System.out.println("loadPassedLevel: 4");
                return GameSettings.TextInfoScreenFourFinal;
            default:
                System.out.println();
                return GameSettings.Err;
        }
    }

    public String pictureInfo(){
        switch (nuclearGame.gameScreen.getCurrentLevel()){
            case 1:
                return "obninsk-npp";
            case 2:
                return "beloyarsk-npp";
            case 3:
                return "bilibino-npp";

            default:
                return "chernobyl-npp";
        }
    }
    public String pictureInfoFinal(){
        switch (nuclearGame.gameScreen.getCurrentLevel()){
            case 1:
                return "obninsk-reactor";
            case 2:
                return "beloyarsk-reactor";
            case 3:
                return "bilibino-reactor";

            default:
                return "chernobyl-reactor";
        }
    }
}


