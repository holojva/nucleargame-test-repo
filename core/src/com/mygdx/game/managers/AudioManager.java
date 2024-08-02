package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.GameSettings;

public class AudioManager {

    public boolean isSoundOn;
    public boolean isMusicOn;
    public Music menuMusic;
    public Music infoMusic;
    public Music gameMusic;

    public Music sparklingWaterMusic;

    public AudioManager() {
        isMusicOn = true;
        isSoundOn = true;
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal(GameSettings.MENU_MUSIC));
        infoMusic = Gdx.audio.newMusic(Gdx.files.internal(GameSettings.INFO_MUSIC));
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal(GameSettings.GAME_MUSIC));
        sparklingWaterMusic = Gdx.audio.newMusic(Gdx.files.internal(GameSettings.SPARKLING_WATER_MUSIC));

        menuMusic.setVolume(0.2f);
        menuMusic.setLooping(true);

        updateMusicFlag();
        updateSoundFlag();
    }

    public void updateSoundFlag() {
        isSoundOn = MemoryManager.loadIsSoundOn();
    }

    public void updateMusicFlag() {
        isMusicOn = MemoryManager.loadIsMusicOn();
    }
}
