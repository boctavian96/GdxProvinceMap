package octi.map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import octi.map.screen.stage.StageScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GdxProvinceMap extends Game {
	private int mapState = 0;
	private Vector3 mousePosition = Vector3.Zero;
	private Vector2 resolution = new Vector2(640, 480);

	private boolean lmbDown = false;
	private boolean rmbDown = false;

	@Override
	public void create() {
		setScreen(new StageScreen(this));
	}

	public void setMapState(int newState){
		this.mapState = newState;
	}

	public void setMousePosition(float x, float y){
		this.mousePosition.set(x, y, 0);
	}

	public void setMousePosition(Vector3 position){
		this.mousePosition = position;
	}

	public int getMapState(){
		return this.mapState;
	}

	public Vector3 getMousePosition(){
		return this.mousePosition;
	}

	public Vector2 getResolution() {
		return resolution;
	}

	public void setResolution(Vector2 resolution) {
		this.resolution = resolution;
	}

	public boolean getLmbDown(){
		return lmbDown;
	}

	public boolean getRmbDown(){
		return rmbDown;
	}

	public void setLmbDown(boolean newLMB){
		this.lmbDown = newLMB;
	}

	public void setRmbDown(boolean newRMB){
		this.rmbDown = newRMB;
	}
}