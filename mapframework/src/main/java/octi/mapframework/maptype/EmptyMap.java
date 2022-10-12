package octi.mapframework.maptype;

import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;

import java.util.List;

public class EmptyMap implements MapType{
    @Override
    public ProvinceMap generateMap(ProvinceMap provinceMap) {
        return provinceMap;
    }
}
