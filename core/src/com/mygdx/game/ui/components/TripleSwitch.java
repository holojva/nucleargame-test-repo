package com.mygdx.game.ui.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

public class TripleSwitch extends Actor {

    Image baseImage;
    Image buttonImage;
    Label[] labels;

    public byte currentState = 0;

    public TripleSwitch(Skin skin) {
        baseImage = new Image(skin, "round-white");
        buttonImage = new Image(skin, "button");
        labels = new Label[]{
                new Label("1", skin),
                new Label("2", skin),
                new Label("3", skin)
        };

        setSize(420, 70);
        setPosition(450, 20);
        setState((byte) 1);

        addListener(new SwitcherTripleInputListener());
    }

    public void setState(byte state) {
        if (state < 0 || state >= 3) throw new IllegalArgumentException();

        setPosition(getX(), getY());
        currentState = state;
        for (int i = 0; i < labels.length; i++) {
            labels[i].getColor().a = (i == currentState) ? 1f : 0f;
        }
        buttonImage.setPosition(
                (buttonImage.getX() + 1f/10) + ((currentState) * buttonImage.getWidth()),
                baseImage.getY() + 1f / 10 * baseImage.getHeight()
        );
    }

    @Override
    public void setSize(float width, float height) {
        height = (200 / 520f) * width;
        baseImage.setSize(width, height);
        buttonImage.setSize((4f / 5) * height, (4f / 5) * height);
        super.setSize(width, height);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        baseImage.setPosition(x, y);
        buttonImage.setPosition(
                x + 1f / 10 * baseImage.getHeight(),
                y + 1f / 10 * baseImage.getWidth()
        );
        for (int i = 0; i < labels.length; i++) {
            labels[i].setPosition(
                    buttonImage.getX() + buttonImage.getWidth()/2f + ((buttonImage.getWidth() + 1/10f) * i) - 5,
                    buttonImage.getY() + 30
            );
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        baseImage.draw(batch, parentAlpha);
        buttonImage.draw(batch, parentAlpha);
        for (Label label : labels)
            label.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        baseImage.act(delta);
        buttonImage.act(delta);
        for (Label label : labels) label.act(delta);
    }

    public void switchLeft() {
        if (currentState <= 0) return;
        currentState -= 1;

        buttonImage.addAction(Actions.moveTo(
                buttonImage.getX() - buttonImage.getWidth(),
                buttonImage.getY(),
                0.2f
        ));


        labels[currentState].addAction(sequence(Actions.delay(0.2f), Actions.fadeIn(0.2f)));
        labels[currentState + 1].addAction(sequence(Actions.fadeOut(0.1f)));
    }

    public void switchRight() {
        if (currentState >= 2) return;
        currentState += 1;
        MoveToAction moveAction = new MoveToAction();
        moveAction.setPosition(buttonImage.getX() + buttonImage.getWidth(), buttonImage.getY());
        moveAction.setDuration(0.2f);
        buttonImage.addAction(moveAction);
        labels[currentState].addAction(sequence(Actions.delay(0.2f), Actions.fadeIn(0.2f)));
        labels[currentState - 1].addAction(sequence(Actions.fadeOut(0.1f)));

    }

    private class SwitcherTripleInputListener extends InputListener {

        Vector2 initialPosition;

        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            initialPosition = new Vector2(x, y);
            return true;
        }

        @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            if (x < initialPosition.x) switchLeft();
            else if (x > initialPosition.x) switchRight();
        }
    }

}
