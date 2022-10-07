package octi.maptype;

import octi.model.Province;
import octi.model.ProvinceMap;

import java.util.List;

public class EmptyMap implements MapType{
    @Override
    public ProvinceMap generateMap(List<? extends Province> provinceMap) {
        return new ProvinceMap(provinceMap);
    }
}
