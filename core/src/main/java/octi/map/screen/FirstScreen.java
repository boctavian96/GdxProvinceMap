package octi.map.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import octi.mapframework.MapCreator;
import octi.maptype.*;
import octi.xml.XmlLoader;
import org.dom4j.Document;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen, InputProcessor {

	//Map Types.
	private Texture emptyMap;
	private Texture politicalMap;
	private Texture terrainMap;
	private Texture resourceMap;

	private SpriteBatch batch;
	private MapCreator mapCreator;
	private Document datamodel;

	private BitmapFont font = new BitmapFont();
	String mapTypeInfo = "Empty Map";

	private int gameState = 0;

	public FirstScreen(){
	}

	@Override
	public void show() {
		// Prepare your screen here.
		FileHandle fileHandle = new FileHandle("assets/map/mapId.png");
		datamodel = XmlLoader.prepareDatamodel("assets/map/mapDatamodel.xml");

		mapCreator = new MapCreator(fileHandle);
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
		Gdx.input.setInputProcessor(this);
		// Draw your screen here. "delta" is the time since last render in seconds.
		Gdx.gl.glClearColor( 0, 0, 0, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

		batch.begin();
		if(gameState == 0) {
			mapTypeInfo = "Empty Map";
			batch.draw(emptyMap, 0, 0);
		}
		if(gameState == 1){
			mapTypeInfo = "Political Map";
			batch.draw(politicalMap, 0, 0);
		}
		if(gameState == 2){
			mapTypeInfo = "Resource Map";
			batch.draw(resourceMap, 0, 0);
		}
		if(gameState == 3){
			mapTypeInfo = "Terrain Map";
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

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Input.Keys.W){
			gameState++;
			if(gameState > 3){
				gameState = 3;
			}
			return true;
		}
		if(keycode == Input.Keys.S){
			gameState--;
			if(gameState < 0){
				gameState = 0;
			}
			return true;
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
		Gdx.app.log("MOUSE_POSITION", String.format("Mouse X: %d, Mouse Y: %d", screenX, screenY));
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