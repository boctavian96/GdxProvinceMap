package octi.mapframework.maptype;

import com.badlogic.gdx.graphics.Color;
import octi.mapframework.maptype.actions.MapClick;
import octi.mapframework.model.Point;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;
import octi.mapframework.util.ColorUtils;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.List;

public class PoliticalMap implements MapType, MapClick {

    @Override
    public ProvinceMap generateMap(ProvinceMap provinceMap) {
        List<Node> list = provinceMap.getDatamodel().selectNodes("//map//province");
        List<Province> provinces = provinceMap.getProvinces();

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
    public ProvinceMap clickColor(List<Province> provinces, Point clickPoint) {
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
