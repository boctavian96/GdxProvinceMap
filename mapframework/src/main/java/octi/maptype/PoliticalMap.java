package octi.maptype;

import com.badlogic.gdx.graphics.Color;
import octi.maptype.actions.MapClick;
import octi.model.Point;
import octi.model.Province;
import octi.model.ProvinceMap;
import octi.util.ColorUtils;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.List;

public class PoliticalMap implements MapType, MapClick{

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

            Color playerColor = ColorUtils.parseColor(playerColorId);

            provinces.get(Integer.parseInt(id)).setProvinceColor(playerColor);
        }


        return new ProvinceMap(provinces);
    }

    @Override
    public ProvinceMap clickColor(List<? extends Province> provinces, Point clickPoint) {
        for (Province province : provinces){
            if(province.getPointList().contains(clickPoint)){
                Color originalColor = province.getProvinceColor();
                Color clickColor = originalColor.add(0.01f, 0.01f, 0.01f, 0f);
                province.setProvinceColor(clickColor);
            }
        }
        return new ProvinceMap(provinces);
    }
}
