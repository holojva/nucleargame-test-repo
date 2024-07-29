package com.mygdx.game.ui.components;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GameSettings;

public class PowerDisplay extends Actor {
    private final float minValue;
    private final float maxValue;
    private float idealValue;
    private final float inaccuracy;
    private float currentValue;
    private final ShapeRenderer shapeRenderer;

    private boolean showError = true;

    private static final Color PROGRESS_BACKGROUND = new Color(0xDDf8E2ff);
    private static final Color PROGRESS_FOREGROUND = new Color(0x85CA92ff);
    private static final Color INACCURACY_BORDERS = new Color(0xFFFFFFff);
    private static final Color BORDER_COLOR = new Color(0x000000ff);

    public PowerDisplay(float minValue, float maxValue, float idealValue, float inaccuracy) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.idealValue = idealValue;
        this.inaccuracy = inaccuracy;
        this.currentValue = minValue;
        this.shapeRenderer = new ShapeRenderer();
        setSize(327, 28);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();

        float ratioX = (float) Gdx.graphics.getWidth() / GameSettings.SCREEN_WIDTH;
        float ratioY = (float) Gdx.graphics.getHeight() / GameSettings.SCREEN_HEIGHT;

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(BORDER_COLOR);
        shapeRenderer.rect(getX() * ratioX, getY() * ratioY, getWidth() * ratioX, getHeight() * ratioY);

        float lineSize = Math.min(Math.round(Math.min(getHeight() * ratioY , getWidth() * ratioX) / 20), 5);


        float LinedX = getX() * ratioX + lineSize;
        float LinedY = getY() * ratioY+ lineSize;
        float LinedWidth = getWidth() * ratioX  - lineSize * 2 * ratioX;
        float LinedHeight = getHeight() * ratioY - lineSize * 2 * ratioY;

        shapeRenderer.setColor(PROGRESS_BACKGROUND);
        shapeRenderer.rect(LinedX, LinedY, LinedWidth, LinedHeight);

        float progressWidth = (currentValue - minValue) / (maxValue - minValue) * LinedWidth;

        shapeRenderer.setColor(PROGRESS_FOREGROUND);
        shapeRenderer.rect(LinedX, LinedY, progressWidth, LinedHeight);

        if (showError) {
            shapeRenderer.setColor(INACCURACY_BORDERS);
            if (idealValue - inaccuracy > minValue) {
                shapeRenderer.rect(LinedX + (idealValue - inaccuracy - minValue) / (maxValue - minValue) * LinedWidth, LinedY, lineSize, LinedHeight);
            }
            if (idealValue + inaccuracy < maxValue) {
                shapeRenderer.rect(LinedX + (idealValue + inaccuracy - minValue) / (maxValue - minValue) * LinedWidth, LinedY, lineSize, LinedHeight);
            }
        }
        shapeRenderer.end();

        batch.begin();
    }

    public void setShowError(boolean showError) {
        this.showError = showError;
    }

    public void setCurrentValue(float currentValue) {
        this.currentValue = Math.max(minValue, Math.min(maxValue, currentValue));
    }
    public float getCurrentValue() {
        return currentValue;
    }

    public float getInaccuracy() {
        return inaccuracy;
    }

    public float getIdealValue() {
        return idealValue;
    }

    public void increaseValue(float coefficient) {
        setCurrentValue(currentValue + coefficient);
    }
    public void decreaseValue(float coefficient) {
        setCurrentValue(currentValue - coefficient);
    }

    public void setIdealValue(float idealValue) {
        this.idealValue = idealValue;
    }

}
