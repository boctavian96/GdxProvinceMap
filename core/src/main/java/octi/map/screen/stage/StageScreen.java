package octi.map.screen.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import octi.map.GdxProvinceMap;
import octi.map.input.BasicInput;
import octi.map.screen.AbstractScreen;
import octi.map.screen.stage.actor.WorldMapActor;
import octi.map.screen.stage.widget.MapModeWidget;
import octi.mapframework.MapCreator;
import octi.mapframework.maptype.MapType;
import octi.mapframework.maptype.PoliticalMap;
import octi.mapframework.naming.ProvinceBitmap;
import octi.mapframework.xml.XmlLoader;
import org.dom4j.Document;

public class StageScreen extends AbstractScreen {

    private Stage stage;
    private Stage hud;
    private MapCreator mc;
    private SpriteBatch spriteBatch;
    private ProvinceBitmap provinceBitmap;

    public StageScreen(GdxProvinceMap context){
        super(context);
    }


    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        InputMultiplexer multiplexer = new InputMultiplexer();
        BasicInput inputProcessor = new BasicInput(context, camera);

        multiplexer.addProcessor(inputProcessor);
        stage = new Stage();
        hud = prepareHud();
        multiplexer.addProcessor(hud);

        FileHandle fh = new FileHandle("assets/map/testMap2/mapId.png");
        Document datamodel = XmlLoader.prepareDatamodel("assets/map/testMap2/mapDatamodel.xml");

        mc = new MapCreator(fh, datamodel);
        MapType type = new PoliticalMap();
        Texture t = mc.generateMap(type);
        WorldMapActor wma = new WorldMapActor(t, mc.getProvinceMap());
        multiplexer.addProcessor(wma);

        provinceBitmap = new ProvinceBitmap();

        stage.addActor(wma);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float delta) {
        camera.update();
        Gdx.gl.glClearColor( 0, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        stage.draw();
        stage.act(delta);

        hud.draw();
        hud.act(delta);
    }

    private Stage prepareHud(){
        Stage ui = new Stage();

        Table table = new Table();
        table.setFillParent(true);
        ui.addActor(table);
        table.top().add(new MapModeWidget());

        return ui;
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
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
