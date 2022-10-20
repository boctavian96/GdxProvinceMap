package octi.mapframework.maptype;

import com.badlogic.gdx.graphics.Color;
import octi.mapframework.maptype.actions.MapClick;
import octi.mapframework.maptype.actions.MapClickImpl;
import octi.mapframework.maptype.actions.MapHover;
import octi.mapframework.maptype.actions.MapHoverImpl;
import octi.mapframework.model.Point;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;
import org.dom4j.Node;

import java.util.List;

public class TerrainMap implements MapType, MapClick, MapHover {
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
            case "Mountains": newColor = Color.BROWN; break;
            case "Plains": newColor = Color.FOREST; break;
            default: newColor = Color.GRAY;
        }

        return newColor;
    }

    @Override
    public ProvinceMap clickColor(ProvinceMap provinceMap, Point clickPoint) {
        return new MapClickImpl().clickColor(provinceMap, clickPoint);
    }

    @Override
    public ProvinceMap hoverColor(ProvinceMap provinceMap, Point clickPoint) {
        return new MapHoverImpl().hoverColor(provinceMap, clickPoint);
    }
}
