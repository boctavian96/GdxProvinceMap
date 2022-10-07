package octi.map.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import octi.map.GdxProvinceMap;
import octi.map.input.BasicInput;
import octi.mapframework.MapCreator;
import octi.maptype.*;
import octi.xml.XmlLoader;
import org.dom4j.Document;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen extends AbstractScreen{

	//Map Types.
	private Texture emptyMap;
	private Texture politicalMap;
	private Texture terrainMap;
	private Texture resourceMap;

	private SpriteBatch batch;

	private final BitmapFont font = new BitmapFont();
	String mapTypeInfo = "Empty Map";

	public FirstScreen(GdxProvinceMap context){
		super(context);
	}

	@Override
	public void show() {
		BasicInput inputProcessor = new BasicInput(context);
		Gdx.input.setInputProcessor(inputProcessor);

		// Prepare your screen here.
		FileHandle fileHandle = new FileHandle("assets/map/mapId.png");
		Document datamodel = XmlLoader.prepareDatamodel("assets/map/mapDatamodel.xml");

		MapCreator mapCreator = new MapCreator(fileHandle);
		MapType emptyMap = new EmptyMap();
		MapType politicalMap = new PoliticalMap(datamodel);
		MapType resourceMap = new ResourceMap(datamodel);
		MapType terrainMap = new TerrainMap(datamodel);


		this.emptyMap = mapCreator.generateMap(emptyMap);
		this.politicalMap = mapCreator.generateMap(politicalMap);
		this.resourceMap = mapCreator.generateMap(resourceMap);
		this.terrainMap = mapCreator.generateMap(terrainMap);
		batch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		// Draw your screen here. "delta" is the time since last render in seconds.
		Gdx.gl.glClearColor( 0, 0, 0, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

		batch.begin();
		if(context.getMapState() == 0) {
			mapTypeInfo = "1 - Empty Map";
			batch.draw(emptyMap, 0, 0);
		}
		if(context.getMapState() == 1){
			mapTypeInfo = "2 - Political Map";
			batch.draw(politicalMap, 0, 0);
		}
		if(context.getMapState() == 2){
			mapTypeInfo = "3 - Resource Map";
			batch.draw(resourceMap, 0, 0);
		}
		if(context.getMapState() == 3){
			mapTypeInfo = "4 - Terrain Map";
			batch.draw(terrainMap, 0, 0);
		}
		font.draw(batch, mapTypeInfo, 0, 200);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// Resize your screen here. The parameters represent the new window size.
	}

	@Override
	public void pause() {
		// Invoked when your application is paused.
	}

	@Override
	public void resume() {
		// Invoked when your application is resumed after pause.
	}

	@Override
	public void hide() {
		// This method is called when another screen replaces this one.
	}

	@Override
	public void dispose() {
		// Destroy screen's assets here.
	}
}