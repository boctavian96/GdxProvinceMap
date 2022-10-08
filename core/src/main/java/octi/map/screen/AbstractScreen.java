package octi.map.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import octi.map.GdxProvinceMap;

public class AbstractScreen implements Screen {

    protected final GdxProvinceMap context;
    protected final OrthographicCamera camera;

    public AbstractScreen(GdxProvinceMap context){
        this.context = context;
        this.camera = new OrthographicCamera(context.getResolution().x, context.getResolution().y);
        this.camera.position.set(context.getResolution().x/2, context.getResolution().y/2, 0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
