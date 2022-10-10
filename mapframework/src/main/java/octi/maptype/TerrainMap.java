package octi.maptype;

import com.badlogic.gdx.graphics.Color;
import octi.model.Province;
import octi.model.ProvinceMap;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.List;

public class TerrainMap implements MapType{
    private final Document datamodel;

    public TerrainMap(Document doc){
        this.datamodel = doc;
    }
    @Override
    public ProvinceMap generateMap(List<? extends Province> provinceMap) {
        List<Node> list = datamodel.selectNodes("//map//province");

        for(Node n : list){
            String id = n.valueOf("@id");
            String terrainType = n.valueOf("terrainType");

            provinceMap.get(Integer.parseInt(id)).setProvinceColor(generateColor(terrainType));
        }


        return new ProvinceMap(provinceMap);
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
