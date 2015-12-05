package xyz.rustybus.lanes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

/**
 * Created by kienme on 5/12/15.
 *
 */

enum Side {
    LEFT, RIGHT
}

class Vehicle {
    TextureRegion vehicle;
    Side side;

    Vehicle(TextureRegion region, Side side) {
        vehicle=region;
        this.side=side;
    }

    public TextureRegion getVehicle() {
        return vehicle;
    }
}

class Asphalt {
    TextureRegion image;
    float x, y;

    Asphalt(float x, float y, Texture texture) {
        this.x=x;
        this.y=y;
        image=new TextureRegion(texture);
    }

    public void moveY(float yDistance) {
        y+=yDistance;
        if((y+ScrollHandler.h)<0)
            y+=(3*(ScrollHandler.h));
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public TextureRegion getImage() {
        return image;
    }
}

public class ScrollHandler {
    static int SCROLL_SPEED=-20;
    Asphalt asphalt1, asphalt2, asphalt3;
    Random random;
    static float w, h;

    ScrollHandler() {
        w=Lanes.VIEWPORT_WIDTH;
        h=Lanes.VIEWPORT_WIDTH* Gdx.graphics.getHeight()/Gdx.graphics.getWidth();

        Texture texture=new Texture("asphalt.png");
        asphalt1=new Asphalt(0, 0, texture);
        asphalt2=new Asphalt(0, asphalt1.getY()+h, texture);
        asphalt3=new Asphalt(0, asphalt2.getY()+h, texture);
        random=new Random();
    }

    public void update() {
        //Handle positions of vehicles
        asphalt1.moveY(SCROLL_SPEED);
        asphalt2.moveY(SCROLL_SPEED);
        asphalt3.moveY(SCROLL_SPEED);
    }

    public void render(SpriteBatch batch) {
        //Draw vehicles to screen
        batch.draw(asphalt1.getImage(), asphalt1.getX(), asphalt1.getY(), w, h);
        batch.draw(asphalt2.getImage(), asphalt2.getX(), asphalt2.getY(), w, h);
        batch.draw(asphalt3.getImage(), asphalt3.getX(), asphalt3.getY(), w, h);
    }

    public void dispose() {
        asphalt1.getImage().getTexture().dispose();
        asphalt2.getImage().getTexture().dispose();
        asphalt3.getImage().getTexture().dispose();

        //Add vehicle dispose
    }
}
