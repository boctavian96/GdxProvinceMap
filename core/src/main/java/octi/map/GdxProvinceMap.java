package octi.map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import octi.map.screen.FirstScreen;
import octi.map.screen.stage.StageScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GdxProvinceMap extends Game {
	private int mapState = 0;
	private Vector2 mousePosition = new Vector2();

	@Override
	public void create() {
		setScreen(new StageScreen(this));
	}

	public void setMapState(int newState){
		this.mapState = newState;
	}

	public void setMousePosition(int x, int y){
		this.mousePosition.set(x, y);
	}

	public int getMapState(){
		return this.mapState;
	}

	public Vector2 getMousePosition(){
		return this.mousePosition;
	}
}