package octi.map.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import octi.map.GdxProvinceMap;

public class BasicInput implements InputProcessor {
    private final GdxProvinceMap context;

    public BasicInput(GdxProvinceMap context){
        this.context = context;
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
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("Mouse Position", String.format("Mouse X: %d, Mouse Y: %d", screenX, screenY));
        context.setMousePosition(screenX, screenY);
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
