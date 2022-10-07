package octi.map;

import com.badlogic.gdx.Game;
import octi.map.screen.FirstScreen;
import octi.map.screen.stage.StageScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GdxProvinceMap extends Game {
	private int mapState = 0;

	@Override
	public void create() {
		setScreen(new FirstScreen(this));
	}

	public void setMapState(int newState){
		this.mapState = newState;
	}

	public int getMapState(){
		return this.mapState;
	}
}