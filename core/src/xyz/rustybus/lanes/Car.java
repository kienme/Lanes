package xyz.rustybus.lanes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by kienme on 4/12/15.
 */
public class Car {
    Sprite car;
    int x, y, rotation;

    Car(Texture img, int x, int y, int rotation) {
        this.x=x;
        this.y=y;
        this.rotation=rotation;

        car=new Sprite(img);
        car.scale(-0.45f);
        car.setPosition(x, y);
    }

    public void render(SpriteBatch batch) {
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
