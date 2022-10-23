package octi.mapframework.maptype.actions;

import octi.mapframework.model.Point;
import octi.mapframework.model.ProvinceMap;


public interface MapHover {
    ProvinceMap hoverColor(ProvinceMap provinceMap, Point hoverPoint);
}
