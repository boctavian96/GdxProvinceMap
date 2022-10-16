package octi.map.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import octi.map.GdxProvinceMap;

public class AbstractScreen implements Screen {

    protected final GdxProvinceMap context;
    protected static OrthographicCamera camera;

    public AbstractScreen(GdxProvinceMap context){
        this.context = context;
        this.camera = new OrthographicCamera(context.getResolution().x, context.getResolution().y);
        this.camera.position.set(context.getResolution().x/2, context.getResolution().y/2, 0);
    }

    public static Vector3 unprojectCamera(Vector3 pointer){
        return camera.unproject(pointer);
    }

    /**
     * Transform mouse coordinates to texture coordinates.
     * @param mousePosition
     */
    public static Vector3 transform(Vector3 mousePosition, int height){
        return new Vector3(mousePosition.x, height - mousePosition.y, 0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        camera.position.set(width/2, height/2, 0);
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
