package octi.mapframework.maptype;

import com.badlogic.gdx.graphics.Color;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;
import org.dom4j.Node;

import java.util.List;

public class TerrainMap implements MapType{
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
}
