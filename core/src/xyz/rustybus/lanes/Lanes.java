package xyz.rustybus.lanes;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Lanes extends ApplicationAdapter {
    OrthographicCamera camera;
	SpriteBatch batch;
	Car car;
	//Texture img;
    //Sprite car;
	
	@Override
	public void create () {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 480*Gdx.graphics.getHeight()/Gdx.graphics.getWidth());
		batch = new SpriteBatch();

		car=new Car(new Texture("blue_car.png"), 0, 0, 0);
		/*img = new Texture("blue_car.png");
        car = new Sprite(img);
        car.scale(-0.45f);
        car.setPosition(0,0);*/
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
		//car.draw(batch);
		car.render(batch);
		batch.end();
	}
}
