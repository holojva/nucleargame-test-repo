package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {
    public  boolean isMusicOn;
    public boolean isSoundOn;
    public  Music coffeeScreenBackgroundMusic;
    public  Sound coffeeScreenBadWinSound = Gdx.audio.newSound(Gdx.files.internal("music\\CoffeeScreenBadWinSound.mp3"));
    public  Sound coffeeScreenMediumWinSound = Gdx.audio.newSound(Gdx.files.internal("music\\CoffeeScreenMediumWinSound.mp3"));
    public  Sound coffeeScreenPerfectWinSound = Gdx.audio.newSound(Gdx.files.internal("music\\CoffeeScreenPerfectWinSound.mp3"));
    public  Music coffeeScreenWaterPumpingMusic;
    public  Music fireAlarm;
    public  Music finalScreenBackgroundMusic;
    public  Music gameScreenBackgroundMusic;
    public  Music infoScreenBackgroundMusic;
    public  Music levelScreenBackgroundMusic;
    public  Music loseScreenBackgroundMusic;
    public  Music settingsScreenBackgroundMusic;
    public Music startScreenBackgroundMusic;
    public  Music tutorialScreenBackgroundMusic;
    public  Music winScreenBackgroundMusic;
    public  Sound secretSound = Gdx.audio.newSound(Gdx.files.internal("music\\CoffeeScreenWaterPumpingMusic.mp3"));

    public AudioManager() {
        coffeeScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/CoffeeScreenBackgroundMusic.mp3"));
        coffeeScreenWaterPumpingMusic = Gdx.audio.newMusic(Gdx.files.internal("music/CoffeeScreenWaterPumpingMusic.mp3"));
        fireAlarm = Gdx.audio.newMusic(Gdx.files.internal("music/FireAlarm.mp3"));
        finalScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/FinalScreenBackgroundMusic.mp3"));
        gameScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/GameScreenBackgroundMusic.mp3"));
        infoScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/InfoScreenBackgroundMusic.mp3"));
        levelScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/LevelScreenBackgroundMusic.mp3"));
        loseScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/LoseScreenBackgroundMusic.mp3"));
        settingsScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/SettingsScreenBackgroundMusic.mp3"));
        startScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/StartScreenBackgroundMusic.mp3"));
        tutorialScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/TutorialScreenBackgroundMusic.mp3"));
        winScreenBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/WinScreenBackgroundMusic.mp3"));

        updateSoundFlag();
        updateMusicFlag();
    }

    public void updateSoundFlag() {
        isSoundOn = MemoryManager.loadIsSoundOn();
    }

    public void updateMusicFlag() {
        isMusicOn = MemoryManager.loadIsMusicOn();

    }
}






