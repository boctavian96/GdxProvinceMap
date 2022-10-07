package octi.maptype;

import octi.model.Province;
import octi.model.ProvinceMap;

import java.util.List;

public interface MapType {
    public ProvinceMap generateMap(List<? extends Province> provinceMap);
}
