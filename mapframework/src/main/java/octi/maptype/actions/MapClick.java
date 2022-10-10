package octi.maptype.actions;

import com.badlogic.gdx.graphics.Color;
import octi.model.Point;
import octi.model.Province;
import octi.model.ProvinceMap;

import java.util.List;

public interface MapClick {
    ProvinceMap clickColor(List<? extends Province> provinces, Point clickPoint);
}
