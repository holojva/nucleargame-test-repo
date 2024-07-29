package com.mygdx.game.ui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GameSettings;

import java.util.ArrayList;
import java.util.Collections;

public class EnergyChart extends Actor {

    public ArrayList<ChartValues> valuesList;

    private final int VISUALIZING_TIME_GAP = 20; // how many seconds fit in horizontal graph
    private final double VERTICAL_PADDING = 50;
    private final int CENTER_LINE_WIDTH = 8;
    private final int CHART_LINE_WIDTH = 4;
    private final Color LINE_COLOR = Color.BLACK;

    Image greenTransparentRectagleImage;
    Image greenColoredRectangleImage;
    Image borderImage;

    private double minValue;
    private double maxValue;

    public int currentPosition;

    private final ShapeRenderer shapeRenderer;

    public EnergyChart(Skin skin) {
        valuesList = new ArrayList<>();
        shapeRenderer = new ShapeRenderer();

        greenColoredRectangleImage = new Image(skin, "rectangle-green-colored");
        greenTransparentRectagleImage = new Image(skin, "rectangle-green-transparent");
        borderImage = new Image(skin, "rectangle-gray");

        currentPosition = 0;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setValuesList(ArrayList<ChartValues> valuesList, boolean updateBoundaryValues) {
        this.valuesList = new ArrayList<>(valuesList);
        if (updateBoundaryValues) {
            maxValue = Collections.max(valuesList).value;
            minValue = Collections.min(valuesList).value;

        }
    }

    @Override
    public void setSize(float width, float height) {
        // width is ignored
        width = (136f / 226) * height;
        borderImage.setSize(width, height);
        greenTransparentRectagleImage.setSize(width, height);
        greenColoredRectangleImage.setSize(CENTER_LINE_WIDTH, height);
        super.setSize(width, height);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        greenTransparentRectagleImage.setPosition(x, y);
        greenColoredRectangleImage.setPosition(x + greenTransparentRectagleImage.getWidth() / 2 - CENTER_LINE_WIDTH / 2, y);
        borderImage.setPosition(x, y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        greenTransparentRectagleImage.draw(batch, parentAlpha);
        greenColoredRectangleImage.draw(batch, parentAlpha);

        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(LINE_COLOR);

        for (int i = currentPosition - VISUALIZING_TIME_GAP / 2;
             i < ChartValues.getSumTime(valuesList) && i - currentPosition < VISUALIZING_TIME_GAP / 2;
             i++) {

            if (i < 0) continue;

            float part = (float) getMaxPart(ChartValues.getValue(valuesList, i));

            float ratioX = (float) Gdx.graphics.getWidth() / GameSettings.SCREEN_WIDTH;
            float ratioY = (float) Gdx.graphics.getHeight() / GameSettings.SCREEN_HEIGHT;




            float x1 = (float) (getX() * ratioX + (i - (currentPosition - VISUALIZING_TIME_GAP / 2.)) * getWidth() * ratioX / VISUALIZING_TIME_GAP);
            float x2 = x1 + getWidth() * ratioX / VISUALIZING_TIME_GAP;
            float y = (float) (getY() * ratioY + VERTICAL_PADDING + (getHeight() * ratioY - 2 * VERTICAL_PADDING) * part);
            shapeRenderer.rectLine(x1, y , x2 , y , CHART_LINE_WIDTH);

            if (i + 1 < ChartValues.getSumTime(valuesList)
                    && i + 1 - currentPosition < VISUALIZING_TIME_GAP / 2) {

                float part2 =  (float) getMaxPart(ChartValues.getValue(valuesList, i + 1));
                float y2 = (float) (getY() * ratioY + VERTICAL_PADDING + (getHeight() * ratioY - 2 * VERTICAL_PADDING) * part2);
                if (y > y2) shapeRenderer.rectLine(x2, y + CHART_LINE_WIDTH / 2, x2, y2 - CHART_LINE_WIDTH / 2, CHART_LINE_WIDTH);
                else shapeRenderer.rectLine(x2, y - CHART_LINE_WIDTH / 2, x2, y2 + CHART_LINE_WIDTH / 2, CHART_LINE_WIDTH);

            }
        }

        shapeRenderer.end();
        batch.begin();

        borderImage.draw(batch, parentAlpha);

    }

    private double getMaxPart(double value) {
        return ((value - minValue) / (maxValue - minValue));
    }

    @Override
    public void act(float delta) {
        greenColoredRectangleImage.act(delta);
        greenTransparentRectagleImage.act(delta);
        borderImage.act(delta);
    }

}