package octi.map.screen.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import octi.map.GdxProvinceMap;
import octi.map.input.BasicInput;
import octi.map.screen.AbstractScreen;
import octi.map.screen.stage.actor.WorldMapActor;
import octi.mapframework.MapCreator;
import octi.maptype.MapType;
import octi.maptype.PoliticalMap;
import octi.maptype.actions.MapClick;
import octi.model.Point;
import octi.xml.XmlLoader;
import org.dom4j.Document;

public class StageScreen extends AbstractScreen {

    private Stage stage;
    private Document datamodel;
    private MapCreator mc;

    public StageScreen(GdxProvinceMap context){
        super(context);
    }


    @Override
    public void show() {
        BasicInput inputProcessor = new BasicInput(context, camera);
        stage = new Stage();
        Gdx.input.setInputProcessor(inputProcessor);

        FileHandle fh = new FileHandle("assets/map/mapId.png");
        datamodel = XmlLoader.prepareDatamodel("assets/map/mapDatamodel.xml");

        mc = new MapCreator(fh, datamodel);
        MapType type = new PoliticalMap(datamodel);
        Texture t = mc.generateMap(type);
        WorldMapActor wma = new WorldMapActor(t);

        stage.addActor(wma);
    }

    @Override
    public void render(float delta) {
        camera.update();
        Gdx.gl.glClearColor( 0, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        if(context.getLmbDown()){
            Point clickPoint = new Point(context.getMousePosition().x, context.getMousePosition().y);
            MapClick mapClick = new PoliticalMap(datamodel);
            Texture t = mc.generateMapClick(mapClick, clickPoint);
            WorldMapActor clickWma = new WorldMapActor(t);
            stage.addActor(clickWma);
            context.setMousePosition(Vector3.Zero);
        }

        stage.draw();
        stage.act(delta);
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
