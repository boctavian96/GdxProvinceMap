package octi.map.screen.stage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class WorldMapActor extends Actor {
    private Texture mapTexture;

    public WorldMapActor(Texture t){
        this.mapTexture = t;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(mapTexture, 0, 0);
    }
}
