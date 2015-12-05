package xyz.rustybus.lanes;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Lanes extends ApplicationAdapter {
    public static final int VIEWPORT_WIDTH=480;
    OrthographicCamera camera;
	SpriteBatch batch;
	Car car;
    ScrollHandler scroller;
	
	@Override
	public void create () {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_WIDTH*Gdx.graphics.getHeight()/Gdx.graphics.getWidth());
		batch = new SpriteBatch();
		car=new Car(new Texture("blue_car.png"));
        scroller=new ScrollHandler();
        Gdx.input.setInputProcessor(new InputHandler(car));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        scroller.update();
        car.update();
        scroller.render(batch);
		car.render(batch);

		batch.end();
	}

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        car.dispose();
        scroller.dispose();
    }
}
