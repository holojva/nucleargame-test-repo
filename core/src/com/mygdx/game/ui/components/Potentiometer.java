package com.mygdx.game.ui.components;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Potentiometer extends Actor {

    Image baseImage;
    Image spinnerImage;

    public double a = Math.PI / 3.7;

    private final float SPINNER_SIZE_RATIO = 0.78f;

    public Potentiometer(Skin skin) {
        baseImage = new Image(skin, "graybutton");
        spinnerImage = new Image(skin, "potentiometer");

        setPosition(0, 0);
        addListener(new PotentiometerInputLister());
        spinnerImage.setRotation(180);
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);
        baseImage.setSize(width, height);
        spinnerImage.setSize(width * SPINNER_SIZE_RATIO, width * SPINNER_SIZE_RATIO);
        spinnerImage.setOrigin(spinnerImage.getWidth() / 2, spinnerImage.getHeight() / 2);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        baseImage.setPosition(x, y);
        spinnerImage.setPosition(
                x + (baseImage.getWidth() / 2) - 26,
                y + (baseImage.getHeight() / 2) + 2
        );
        spinnerImage.setOrigin(spinnerImage.getWidth() / 2, spinnerImage.getHeight() / 2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        baseImage.draw(batch, parentAlpha);
        spinnerImage.draw(batch, parentAlpha);
    }

    public float getValue() {
        return (float) (1 - (Math.toRadians(spinnerImage.getRotation()) - a) / (Math.PI * 2 - a * 2));
    }

    private class PotentiometerInputLister extends InputListener {

        double touchInitialAngle;
        double touchCurrentAngle;
        double spinnerInitialAngle;
        double spinnerCurrentAngle;

        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            spinnerInitialAngle = Math.toRadians(spinnerImage.getRotation());
            touchInitialAngle = getAngle(x, y);
            return true;
        }

        @Override
        public void touchDragged(InputEvent event, float x, float y, int pointer) {
            touchCurrentAngle = getAngle(x, y);
            double dAngle = -touchInitialAngle + touchCurrentAngle;

            spinnerCurrentAngle = spinnerInitialAngle + dAngle;

            if (spinnerCurrentAngle < 0) {
                spinnerCurrentAngle = Math.PI * 2 + spinnerCurrentAngle;
            }

            if (spinnerCurrentAngle > Math.PI * 2) {
                spinnerCurrentAngle = spinnerCurrentAngle - Math.PI * 2;
            }

            if ((spinnerCurrentAngle + dAngle <= a)) {
                touchInitialAngle = getAngle(x, y);
                return;
            }

            if ((spinnerCurrentAngle + dAngle >= Math.PI * 2 - a)) {
                touchInitialAngle = getAngle(x, y);
                return;
            }

            spinnerImage.setRotation((float) (Math.toDegrees(spinnerCurrentAngle)));
            spinnerInitialAngle = Math.toRadians(spinnerImage.getRotation());
            touchInitialAngle = getAngle(x, y);
        }

        private double getAngle(float x, float y) {
            double dx = (x - (spinnerImage.getX() - baseImage.getX()) - spinnerImage.getWidth() / 2);
            double dy = (y - (spinnerImage.getY() - baseImage.getY()) - spinnerImage.getHeight() / 2);
            double angle = Math.atan(dy / dx);

            if (dx < 0) {
                angle += Math.PI;
            }

            angle += Math.PI / 2;

            return angle;
        }

    }

}

