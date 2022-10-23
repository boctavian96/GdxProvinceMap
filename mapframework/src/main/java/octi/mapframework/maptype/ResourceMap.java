package octi.mapframework.maptype;

import com.badlogic.gdx.graphics.Color;
import octi.mapframework.maptype.actions.MapClick;
import octi.mapframework.maptype.actions.MapHover;
import octi.mapframework.maptype.actions.impl.BasicMapClickImpl;
import octi.mapframework.maptype.actions.impl.BasicMapHoverImpl;
import octi.mapframework.model.Point;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;
import org.dom4j.Node;

import java.util.List;

public class ResourceMap implements MapType, MapClick, MapHover {

    private final BasicMapClickImpl mapClickResource = new BasicMapClickImpl();
    private final BasicMapHoverImpl mapHoverResource = new BasicMapHoverImpl();

    @Override
    public ProvinceMap generateMap(ProvinceMap provinceMap) {
        List<Node> list = provinceMap.getDatamodel().selectNodes("//map//province");
        List<Province> provinces = provinceMap.getProvinces();
        int maximumWealth = getMaximum(list);

        for(Node n : list){
            int id = Integer.parseInt(n.valueOf("@id"));
            int wealth = Integer.parseInt(n.valueOf("wealth"));

            provinces.get(id).setProvinceColor(colorProvince(wealth, maximumWealth));
        }

        return new ProvinceMap(provinces);

    }

    private int getMaximum(List<Node> nodes){
        int maximum = 0;
        for(Node n : nodes){
            int newValue = Integer.valueOf(n.valueOf("wealth"));
            if(newValue > maximum){
                maximum = newValue;
            }
        }

        return maximum;
    }

    private Color colorProvince(int actualValue, int maximumValue){
        float f = Float.valueOf(actualValue)/Float.valueOf(maximumValue);

        return new Color(1F - f,0F + f,0,1);
    }

    @Override
    public ProvinceMap clickColor(ProvinceMap provinceMap, Point clickPoint) {
        return mapClickResource.clickColor(provinceMap, clickPoint);
    }

    @Override
    public ProvinceMap hoverColor(ProvinceMap provinceMap, Point hoverPoint) {
        return mapHoverResource.hoverColor(provinceMap, hoverPoint);
    }
}
