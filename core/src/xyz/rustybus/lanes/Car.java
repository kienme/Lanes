package xyz.rustybus.lanes;

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
    static final int SIDE_SPEED=15;
    static final int ROTATION_SPEED=3;
    static final int MAX_ROTATION=15;
    static int LEFT_POS, RIGHT_POS;
    Sprite car;
    //float scale;
    float x, y, rotation;
    State state;

    Car(Texture img) {
        car=new Sprite(img);

        LEFT_POS=Lanes.VIEWPORT_WIDTH/4;
        RIGHT_POS=LEFT_POS*3;
        state=State.LEFT;

        x=LEFT_POS-car.getWidth()/2;
        y=20;
        rotation=0;
        car.setOriginCenter();

        //car.scale(scale);
        //float w=car.getWidth();
        //w=w+(w*scale);
        //car.setRotation(40);
        //car.setOriginCenter();
        //car.rotate(-rotation);
    }

    public void update() {
        switch (state) {
            case TURNING_LEFT:
                if(x>(LEFT_POS-car.getWidth()/2)) {
                    x -= SIDE_SPEED;
                    if(rotation<MAX_ROTATION)
                        rotation+=ROTATION_SPEED;
                }
                else
                    state=State.LEFT;
                break;

            case TURNING_RIGHT:
                if(x<(RIGHT_POS-car.getWidth()/2)) {
                    x += SIDE_SPEED;
                    if(rotation>-MAX_ROTATION)
                        rotation-=ROTATION_SPEED;
                }
                else
                    state=State.RIGHT;
                break;

            case LEFT:
                if(rotation>0)
                    rotation-=6;
                else
                    rotation=0;
                break;

            case RIGHT:
                if(rotation<0)
                    rotation+=6;
                else
                    rotation=0;
                break;
        }

        car.setRotation(rotation);
        car.setPosition(x, y);
    }

    public void render(SpriteBatch batch) {
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

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRotation() {
        return rotation;
    }
}
