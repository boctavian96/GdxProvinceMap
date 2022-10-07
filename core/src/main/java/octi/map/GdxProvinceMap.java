package octi.map;

import com.badlogic.gdx.Game;
import octi.map.screen.FirstScreen;
import octi.map.screen.stage.StageScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GdxProvinceMap extends Game {
	@Override
	public void create() {
		setScreen(new FirstScreen());
	}
}