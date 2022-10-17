package octi.map.screen.stage.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.*;
import octi.map.screen.AbstractScreen;
import octi.mapframework.MapCreator;
import octi.mapframework.maptype.PoliticalMap;
import octi.mapframework.maptype.actions.MapClick;
import octi.mapframework.maptype.actions.MapHover;
import octi.mapframework.model.Point;
import octi.mapframework.model.ProvinceMap;
import octi.mapframework.naming.ProvinceBitmap;

public class WorldMapActor extends Actor implements InputProcessor {
    private Texture mapTexture;
    private Rectangle collisionRectangle;
    private ProvinceMap provinceMap;
    private boolean mouseHoverActivated = false;
    private ProvinceBitmap pbmp;

    public WorldMapActor(Texture t){
        this.mapTexture = t;
        setWidth(mapTexture.getWidth());
        setHeight(mapTexture.getHeight());
        setX(0);
        setY(0);
        collisionRectangle = new Rectangle(0, 0, getWidth(), getHeight());
        setTouchable(Touchable.enabled);
        pbmp = new ProvinceBitmap();
    }

    public WorldMapActor(Texture t, ProvinceMap pm){
        this(t);
        this.provinceMap = pm;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(mapTexture, 0, 0);
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
                MapClick mapClick = new PoliticalMap();
                ProvinceMap pm = mapClick.clickColor(provinceMap, new Point(mousePointer.x, mousePointer.y));
                this.mapTexture = MapCreator.generateMapClick(mapClick, new Point(mousePointer.x, mousePointer.y), pm);
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
                MapHover mapHover = new PoliticalMap();
                ProvinceMap pm = mapHover.hoverColor(provinceMap, new Point(mousePointer.x, mousePointer.y));
                this.mapTexture = MapCreator.generateMapHover(mapHover, new Point(mousePointer.x, mousePointer.y), pm);
            }
        }

        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
