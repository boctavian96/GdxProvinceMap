package octi.map.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import octi.map.GdxProvinceMap;


public class BasicInput implements InputProcessor {
    private final GdxProvinceMap context;
    private final OrthographicCamera camera;

    public BasicInput(GdxProvinceMap context, OrthographicCamera camera){
        this.context = context;
        this.camera = camera;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.W){
            context.setMapState(context.getMapState() + 1);
            if(context.getMapState() > 3){
                context.setMapState(3);
            }
            return true;
        }
        if(keycode == Input.Keys.S){
            context.setMapState(context.getMapState() - 1);
            if(context.getMapState() < 0){
                context.setMapState(0);
            }
            return true;
        }
        if(keycode == Input.Keys.Q){
            Gdx.app.exit();
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(Input.Buttons.LEFT == button){
            context.setLmbDown(true);
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(Input.Buttons.LEFT == button && context.getLmbDown()) {
            Vector3 screenCoordinates = new Vector3(screenX, screenY, 0f);
            //Gdx.app.log("Mouse Projected", format("Mouse X: %d, Mouse Y: %d", screenX, screenY));

            Vector3 unprojectedCoordinates = camera.unproject(screenCoordinates);
            //Gdx.app.log("Mouse Unprojected", format("Mouse UX: %f, Mouse UY: %f", unprojectedCoordinates.x, unprojectedCoordinates.y));

            if(unprojectedCoordinates.y <= 128) {
                Vector3 flippedYCoordinates = new Vector3(unprojectedCoordinates.x, 128 - unprojectedCoordinates.y, 0);
                context.setMousePosition(flippedYCoordinates);
                //Gdx.app.log("Mouse Flipped", format("Mouse FX: %f, Mouse FY: %f", flippedYCoordinates.x, flippedYCoordinates.y));
            }
            context.setLmbDown(false);
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
