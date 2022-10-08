package octi.map.screen.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import octi.map.GdxProvinceMap;
import octi.map.input.BasicInput;
import octi.map.screen.AbstractScreen;
import octi.map.screen.stage.actor.WorldMapActor;
import octi.mapframework.MapCreator;
import octi.maptype.MapType;
import octi.maptype.PoliticalMap;
import octi.xml.XmlLoader;
import org.dom4j.Document;

public class StageScreen extends AbstractScreen {

    private Stage stage;
    private SpriteBatch batch;
    private Viewport viewport;

    public StageScreen(GdxProvinceMap context){
        super(context);
    }


    @Override
    public void show() {
        BasicInput inputProcessor = new BasicInput(context, camera);
        Gdx.input.setInputProcessor(inputProcessor);

        viewport = new FitViewport(640, 480);
        batch = new SpriteBatch();
        stage = new Stage();

        FileHandle fh = new FileHandle("assets/map/mapId.png");
        Document datamodel = XmlLoader.prepareDatamodel("assets/map/mapDatamodel.xml");

        MapCreator mc = new MapCreator(fh, datamodel);
        MapType type = new PoliticalMap(datamodel);
        Texture t =mc.generateMap(type);
        WorldMapActor wma = new WorldMapActor(t);

        stage.addActor(wma);
    }

    @Override
    public void render(float delta) {
        camera.update();
        Gdx.gl.glClearColor( 0, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        stage.draw();
        stage.act(delta);
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
