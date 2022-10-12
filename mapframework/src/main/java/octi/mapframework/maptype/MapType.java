package octi.mapframework.maptype;

import octi.mapframework.meta.Experimental;
import octi.mapframework.model.ProvinceMap;


@Experimental
public interface MapType {
    ProvinceMap generateMap(ProvinceMap provinceMap);
}
