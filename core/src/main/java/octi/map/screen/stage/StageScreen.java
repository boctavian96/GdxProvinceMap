package octi.map.screen.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import octi.map.GdxProvinceMap;
import octi.map.input.BasicInput;
import octi.map.screen.AbstractScreen;
import octi.map.screen.stage.actor.WorldMapActor;
import octi.map.screen.stage.widget.MapModeWidget;
import octi.mapframework.MapCreator;
import octi.mapframework.maptype.MapType;
import octi.mapframework.maptype.PoliticalMap;
import octi.mapframework.maptype.ResourceMap;
import octi.mapframework.maptype.TerrainMap;
import octi.mapframework.xml.XmlLoader;
import org.dom4j.Document;

public class StageScreen extends AbstractScreen {

    private Stage stage;
    private Stage hud;
    private MapCreator mc;

    private WorldMapActor wmaPolitical;
    private WorldMapActor wmaResource;
    private WorldMapActor wmaTerrain;

    public StageScreen(GdxProvinceMap context){
        super(context);
    }


    @Override
    public void show() {
        InputMultiplexer multiplexer = new InputMultiplexer();
        BasicInput inputProcessor = new BasicInput(context, camera);

        multiplexer.addProcessor(inputProcessor);
        stage = new Stage();
        hud = prepareHud();
        multiplexer.addProcessor(hud);

        FileHandle fh = new FileHandle("assets/map/testMap2/mapId.png");
        Document datamodel = XmlLoader.prepareDatamodel("assets/map/testMap2/mapDatamodel.xml");

        mc = new MapCreator(fh, datamodel);

        wmaPolitical = new WorldMapActor(fh, datamodel, new PoliticalMap());
        wmaResource = new WorldMapActor(fh, datamodel, new ResourceMap());
        wmaTerrain = new WorldMapActor(fh, datamodel, new TerrainMap());

        wmaResource.setVisible(false);
        wmaTerrain.setVisible(false);

        multiplexer.addProcessor(wmaPolitical);
        multiplexer.addProcessor(wmaResource);
        multiplexer.addProcessor(wmaTerrain);

        stage.addActor(wmaPolitical);
        stage.addActor(wmaResource);
        stage.addActor(wmaTerrain);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float delta) {
        handleState();
        camera.update();
        Gdx.gl.glClearColor( 0, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        stage.draw();
        stage.act(delta);

        hud.draw();
        hud.act(delta);
    }

    private void handleState(){
        if(context.isMapStateChanged()) {
            if (context.getMapState() == 0) {
                //Political Map.
                stage.getActors().get(0).setVisible(true);
                stage.getActors().get(0).setTouchable(Touchable.enabled);
                stage.getActors().get(1).setVisible(false);
                stage.getActors().get(1).setTouchable(Touchable.disabled);
                stage.getActors().get(2).setVisible(false);
                stage.getActors().get(2).setTouchable(Touchable.disabled);
            }
            if (context.getMapState() == 1) {
                //Resource Map.
                stage.getActors().get(0).setVisible(false);
                stage.getActors().get(0).setTouchable(Touchable.disabled);
                stage.getActors().get(1).setVisible(true);
                stage.getActors().get(1).setTouchable(Touchable.enabled);
                stage.getActors().get(2).setVisible(false);
                stage.getActors().get(2).setTouchable(Touchable.disabled);
            }
            if (context.getMapState() == 2) {
                //Terrain Map.
                stage.getActors().get(0).setVisible(false);
                stage.getActors().get(0).setTouchable(Touchable.disabled);
                stage.getActors().get(1).setVisible(false);
                stage.getActors().get(1).setTouchable(Touchable.disabled);
                stage.getActors().get(2).setVisible(true);
                stage.getActors().get(2).setTouchable(Touchable.enabled);
            }
            context.acted();
        }
    }

    private Stage prepareHud(){
        Stage ui = new Stage();

        Table table = new Table();
        table.setFillParent(true);
        ui.addActor(table);
        table.top().add(new MapModeWidget(context));

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
