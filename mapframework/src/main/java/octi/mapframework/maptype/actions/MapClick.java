package octi.mapframework.maptype.actions;

import octi.mapframework.model.Point;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;

import java.util.List;

public interface MapClick {
    ProvinceMap clickColor(List<? extends Province> provinces, Point clickPoint);
}
