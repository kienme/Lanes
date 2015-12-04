package xyz.rustybus.lanes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by kienme on 4/12/15.
 *
 */

enum State {
    LEFT, RIGHT, TURNING_LEFT, TURNING_RIGHT
}

public class Car {
    static final int TURN_SPEED=15;
    static int LEFT_POS, RIGHT_POS;
    Sprite car;
    float scale;
    int x, y, rotation;
    State state;

    Car(Texture img) {
        LEFT_POS=Lanes.VIEWPORT_WIDTH/4;
        RIGHT_POS=LEFT_POS*3;

        x=LEFT_POS;
        y=0;
        rotation=0;

        car=new Sprite(img);
        scale=-0.5f;
        state=State.LEFT;
        car.scale(scale);
        float w=car.getHeight();
        w=w+(w*scale);
        car.setOrigin(-w/2, 0);
    }

    public void update() {
        switch (state) {
            case TURNING_LEFT:
                if(x>LEFT_POS)
                    x-=TURN_SPEED;
                else
                    state=State.LEFT;
                break;

            case TURNING_RIGHT:
                if(x<RIGHT_POS)
                    x+=TURN_SPEED;
                else
                    state=State.RIGHT;
                break;
        }
    }

    public void render(SpriteBatch batch) {
        car.setPosition(x, y);
        car.draw(batch);
    }

    public void onTouch() {
        switch (state) {
            case LEFT:
            case TURNING_LEFT:
                state=State.TURNING_RIGHT;
                break;

            case RIGHT:
            case TURNING_RIGHT:
                state=State.TURNING_LEFT;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRotation() {
        return rotation;
    }
}
