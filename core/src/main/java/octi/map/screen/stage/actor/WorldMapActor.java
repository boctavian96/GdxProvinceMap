package octi.map.screen.stage.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.*;
import octi.map.screen.AbstractScreen;
import octi.mapframework.MapCreator;
import octi.mapframework.maptype.MapType;
import octi.mapframework.maptype.actions.MapClick;
import octi.mapframework.maptype.actions.MapHover;
import octi.mapframework.model.Point;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;
import octi.mapframework.label.ProvinceBitmap;
import org.dom4j.Document;


public class WorldMapActor extends Actor implements InputProcessor {
    private Texture mapTexture;
    private Rectangle collisionRectangle;
    private ProvinceMap provinceMap;
    private boolean mouseHoverActivated = true;
    private ProvinceBitmap labelProcessor;
    private MapCreator mapManager;
    private MapClick mapClick;
    private MapHover mapHover;

    public WorldMapActor(FileHandle fh, Document doc, MapType mapType){
        mapManager = new MapCreator(fh, doc);
        this.mapTexture = mapManager.generateMap(mapType);
        mapClick = (MapClick) mapType;
        mapHover = (MapHover) mapType;
        this.provinceMap = mapManager.getProvinceMap();
        setWidth(mapTexture.getWidth());
        setHeight(mapTexture.getHeight());
        setX(0);
        setY(0);
        collisionRectangle = new Rectangle(0, 0, getWidth(), getHeight());
        labelProcessor = new ProvinceBitmap();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(mapTexture, 0, 0);

        labelProcessor.drawProvinceNames(batch, provinceMap.getDatamodel());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
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
        if(button == Input.Buttons.LEFT) {
            Vector3 mousePointer = new Vector3(screenX, screenY, 0);
            mousePointer = AbstractScreen.unprojectCamera(mousePointer);
            mousePointer = AbstractScreen.transform(mousePointer, (int) getHeight());

            if (collisionRectangle.contains(mousePointer.x, mousePointer.y) && provinceMap.containsPoint(new Point(mousePointer.x, mousePointer.y))) {
                this.mapTexture = mapManager.generateMapClick(mapClick, new Point(mousePointer.x, mousePointer.y));
            }
        }else if(button == Input.Buttons.RIGHT){
            Gdx.app.log("Actor touch", "RMB pushed");
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        if(mouseHoverActivated) {
            Vector3 mousePointer = new Vector3(screenX, screenY, 0);
            mousePointer = AbstractScreen.unprojectCamera(mousePointer);
            mousePointer = AbstractScreen.transform(mousePointer, (int) getHeight());

            if (collisionRectangle.contains(mousePointer.x, mousePointer.y) && provinceMap.containsPoint(new Point(mousePointer.x, mousePointer.y))) {
                this.mapTexture = mapManager.generateMapHover(mapHover, new Point(mousePointer.x, mousePointer.y));
            }
        }

        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
