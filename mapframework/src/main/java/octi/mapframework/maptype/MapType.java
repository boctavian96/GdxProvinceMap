package octi.mapframework.maptype;

import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;

import java.util.List;

public interface MapType {
    ProvinceMap generateMap(List<Province> provinceMap);
}
