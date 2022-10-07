package octi.map.screen;

import com.badlogic.gdx.Screen;
import octi.map.GdxProvinceMap;

public class AbstractScreen implements Screen {

    protected final GdxProvinceMap context;

    public AbstractScreen(GdxProvinceMap context){
        this.context = context;
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
