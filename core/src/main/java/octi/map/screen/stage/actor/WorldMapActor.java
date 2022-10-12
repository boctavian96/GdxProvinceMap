package octi.map.screen.stage.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class WorldMapActor extends Actor {
    private Texture mapTexture;
    private int width;
    private int height;

    public WorldMapActor(Texture t){
        this.mapTexture = t;
        this.width = mapTexture.getWidth();
        this.height = mapTexture.getHeight();
        setTouchable(Touchable.enabled);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(mapTexture, 0, 0);
    }
}
