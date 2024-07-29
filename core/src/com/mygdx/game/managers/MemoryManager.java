package com.mygdx.game.managers;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class MemoryManager {

    private static final Preferences preferences = Gdx.app.getPreferences("User saves");

    public static void saveSoundSettings(boolean isOn) {
        preferences.putBoolean("isSoundOn", isOn);
        preferences.flush();
    }

    public static boolean loadIsSoundOn() {
        return preferences.getBoolean("isSoundOn", true);
    }

    public static void saveMusicSettings(boolean isOn) {
        preferences.putBoolean("isMusicOn", isOn);
        preferences.flush();
    }

    public static boolean loadIsMusicOn() {
        return preferences.getBoolean("isMusicOn", true);
    }

    public static int loadPassedLevel() {
        return preferences.getInteger("passedLevel", 0);
    }

    public static void savePassedLevel(int level) {
        preferences.putInteger("passedLevel", level);
        preferences.flush();
    }

}