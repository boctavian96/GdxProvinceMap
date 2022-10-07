package octi.maptype;

import com.badlogic.gdx.graphics.Color;
import octi.model.Province;
import octi.model.ProvinceMap;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.List;

public class PoliticalMap implements MapType{

    private final Document datamodel;

    public PoliticalMap(Document doc) {
        this.datamodel = doc;
    }

    @Override
    public ProvinceMap generateMap(List<? extends Province> provinces) {
        List<Node> list = datamodel.selectNodes("//map//province");

        for(Node n : list){
            String id = n.valueOf("@id");
            String owner = n.valueOf("ownerId");
            String[] playerColorId = owner.split(",");

            float r = Float.parseFloat(playerColorId[0]);
            float g = Float.parseFloat(playerColorId[1]);
            float b = Float.parseFloat(playerColorId[2]);
            Color playerColor = new Color(r, g, b, 1);

            provinces.get(Integer.parseInt(id)).setProvinceColor(playerColor);
        }


        return new ProvinceMap(provinces);
    }
}
