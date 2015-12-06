package xyz.rustybus.lanes;

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
    Random random;
    Side side;
    float x, y;

    Vehicle(float y, TextureRegion region) {
        random=new Random();
        side=random.nextInt(2)==0?Side.LEFT:Side.RIGHT;
        vehicle=region;
        this.y=y;
        x=Lanes.VIEWPORT_WIDTH/4;
        if(side==Side.RIGHT)
            x*=3;
    }

    public void moveY(float yDistance) {
        y+=yDistance;
        if((y+vehicle.getRegionHeight())<0) {
            y = ScrollHandler.NO_OF_VEHICLES * ScrollHandler.VEHICLE_GAP;
            side=random.nextInt(2)==0?Side.LEFT:Side.RIGHT;
            x=Lanes.VIEWPORT_WIDTH/4;
            if(side==Side.RIGHT)
                x*=3;
            //Change texture to random vehicle
        }
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