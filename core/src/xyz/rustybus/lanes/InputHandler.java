package xyz.rustybus.lanes;

import com.badlogic.gdx.InputAdapter;

/**
 * Created by kienme on 4/12/15.
 *
 */

public class InputHandler extends InputAdapter {

    Car car;

    InputHandler(Car car) {
        this.car=car;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        return true;
        //return super.touchDown(screenX, screenY, pointer, button);
    }
}
