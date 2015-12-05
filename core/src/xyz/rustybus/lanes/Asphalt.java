package xyz.rustybus.lanes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by kienme on 5/12/15.
 *
 */

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
