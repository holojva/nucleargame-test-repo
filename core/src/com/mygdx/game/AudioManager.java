package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {
    public static boolean isMusicOn = true;
    public boolean isSoundOn;
    public static Music coffeeScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music\\CoffeeScreenBackgroundMusic.mp3"));
    public static Sound coffeeScreenBadWinSound = Gdx.audio.newSound(Gdx.files.internal("music\\CoffeeScreenBadWinSound.mp3"));
    public static Sound coffeeScreenMediumWinSound = Gdx.audio.newSound(Gdx.files.internal("music\\CoffeeScreenMediumWinSound.mp3"));
    public static Sound coffeeScreenPerfectWinSound = Gdx.audio.newSound(Gdx.files.internal("music\\CoffeeScreenPerfectWinSound.mp3"));
    public static Music coffeeScreenWaterPumpingMusic = Gdx.audio.newMusic(Gdx.files.internal("music\\CoffeeScreenWaterPumpingMusic.mp3"));
    public static Sound gameScreenWheelSound = Gdx.audio.newSound(Gdx.files.internal("music\\GameScreenWheelSound.mp3"));
    public static Sound buttonTouch = Gdx.audio.newSound(Gdx.files.internal("music\\ButtonTouch.mp3"));
    public static Music fireAlarm = Gdx.audio.newMusic(Gdx.files.internal("music\\FireAlarm.mp3"));
    public static Music finalScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music\\FinalScreenBackgroundMusic.mp3"));
    public static Music gameScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music\\GameScreenBackgroundMusic.mp3"));
    public static Music infoScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music\\InfoScreenBackgroundMusic.mp3"));
    public static Music levelScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music\\LevelScreenBackgroundMusic.mp3"));
    public static Music loseScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music\\LoseScreenBackgroundMusic.mp3"));
    public static Music settingsScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music\\SettingsScreenBackgroundMusic.mp3"));
    public static Music startScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music\\StartScreenBackgroundMusic.mp3"));
    public static Music tutorialScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music\\TutorialScreenBackgroundMusic.mp3"));
    public static Music winScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music\\WinScreenBackgroundMusic.mp3"));
    public static Sound secretSound = Gdx.audio.newSound(Gdx.files.internal("music\\CoffeeScreenWaterPumpingMusic.mp3"));
    public AudioManager() {

    }

    public static void stopAllMusic() {
        coffeeScreenBackgroundMusic.stop();
        coffeeScreenWaterPumpingMusic.stop();
        fireAlarm.stop();
        finalScreenBackgroundMusic.stop();
        gameScreenBackgroundMusic.stop();
        infoScreenBackgroundMusic.stop();
        levelScreenBackgroundMusic.stop();
        loseScreenBackgroundMusic.stop();
        settingsScreenBackgroundMusic.stop();
        startScreenBackgroundMusic.stop();
        tutorialScreenBackgroundMusic.stop();
        winScreenBackgroundMusic.stop();

    }
    public static void playMusic(Music music) {
        stopAllMusic();
        if (isMusicOn) music.play();
    }
    public void playSound(Sound sound) {
        if (isSoundOn) sound.play();
    }
}
