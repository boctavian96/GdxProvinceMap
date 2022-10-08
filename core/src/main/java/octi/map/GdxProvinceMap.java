package octi.map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import octi.map.screen.FirstScreen;
import octi.map.screen.stage.StageScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GdxProvinceMap extends Game {
	private int mapState = 0;
	private Vector3 mousePosition = new Vector3();
	private Vector2 resolution = new Vector2(640, 480);

	@Override
	public void create() {
		setScreen(new StageScreen(this));
	}

	public void setMapState(int newState){
		this.mapState = newState;
	}

	public void setMousePosition(int x, int y){
		this.mousePosition.set(x, y, 0);
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
}