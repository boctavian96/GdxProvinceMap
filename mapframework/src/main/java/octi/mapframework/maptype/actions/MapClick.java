package octi.mapframework.maptype.actions;

import octi.mapframework.model.Point;
import octi.mapframework.model.ProvinceMap;


public interface MapClick {
    ProvinceMap clickColor(ProvinceMap provinceMap, Point clickPoint);
}
