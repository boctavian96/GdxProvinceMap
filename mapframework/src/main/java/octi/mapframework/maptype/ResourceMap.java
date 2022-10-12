package octi.mapframework.maptype;

import com.badlogic.gdx.graphics.Color;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.List;

public class ResourceMap implements MapType{

    private final Document datamodel;

    public ResourceMap(Document doc){
        this.datamodel = doc;
    }

    @Override
    public ProvinceMap generateMap(List<Province> provinceMap) {
        List<Node> list = datamodel.selectNodes("//map//province");
        int maximumWealth = getMaximum(list);

        for(Node n : list){
            int id = Integer.parseInt(n.valueOf("@id"));
            int wealth = Integer.parseInt(n.valueOf("wealth"));

            provinceMap.get(id).setProvinceColor(colorProvince(wealth, maximumWealth));
        }

        return new ProvinceMap(provinceMap);

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
}
