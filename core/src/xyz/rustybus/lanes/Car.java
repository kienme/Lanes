package xyz.rustybus.lanes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by kienme on 4/12/15.
 *
 */

public class Car {
    Sprite car;
    float scale;
    public int x, y, rotation;

    Car(Texture img, int x, int y, int rotation) {
        this.x=x;
        this.y=y;
        this.rotation=rotation;
        car=new Sprite(img);
        scale=-0.5f;

        car.scale(scale);
        car.setOrigin(0, 0);
    }

    public void render(SpriteBatch batch) {
        car.setPosition(x, y);
        car.draw(batch);
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
