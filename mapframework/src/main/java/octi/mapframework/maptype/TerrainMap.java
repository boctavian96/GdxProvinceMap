package octi.mapframework.maptype;

import com.badlogic.gdx.graphics.Color;
import octi.mapframework.maptype.actions.MapClick;
import octi.mapframework.maptype.actions.MapHover;
import octi.mapframework.maptype.actions.impl.MapClickTerrainImpl;
import octi.mapframework.maptype.actions.impl.MapHoverPoliticalImpl;
import octi.mapframework.model.Point;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;
import org.dom4j.Node;

import java.util.List;

public class TerrainMap implements MapType, MapClick, MapHover {
    private final MapClickTerrainImpl mapClickTerrain = new MapClickTerrainImpl();

    @Override
    public ProvinceMap generateMap(ProvinceMap provinceMap) {
        List<Node> list = provinceMap.getDatamodel().selectNodes("//map//province");
        List<Province> provinces = provinceMap.getProvinces();

        for(Node n : list){
            String id = n.valueOf("@id");
            String terrainType = n.valueOf("terrainType");

            provinces.get(Integer.parseInt(id)).setProvinceColor(generateColor(terrainType));
        }

        return new ProvinceMap(provinces);
    }

    private Color generateColor(String terrainType){
        Color newColor;
        switch (terrainType){
            case "Mountains": newColor = new Color(Color.BROWN); break;
            case "Plains": newColor = new Color(Color.FOREST); break;
            default: newColor = new Color(Color.GRAY);
        }

        return newColor;
    }

    @Override
    public ProvinceMap clickColor(ProvinceMap provinceMap, Point clickPoint) {
        return mapClickTerrain.clickColor(provinceMap, clickPoint);
    }

    @Override
    public ProvinceMap hoverColor(ProvinceMap provinceMap, Point clickPoint) {
        return new MapHoverPoliticalImpl().hoverColor(provinceMap, clickPoint);
    }
}
