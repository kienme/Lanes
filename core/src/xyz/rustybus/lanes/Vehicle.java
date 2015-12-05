package xyz.rustybus.lanes;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

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
    float x, y;

    Vehicle(Side side, TextureRegion region) {
        vehicle=region;
        this.side=side;
        y=0;
        x=Lanes.VIEWPORT_WIDTH/4;
        if(side==Side.RIGHT)
            x*=3;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public TextureRegion getVehicle() {
        return vehicle;
    }
}