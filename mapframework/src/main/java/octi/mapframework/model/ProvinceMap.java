package octi.mapframework.model;


import com.badlogic.gdx.graphics.Color;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.dom4j.Document;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ProvinceMap {
    private List<Province> provinces;
    private Document datamodel;
    private Color clickedProvinceId;

    public ProvinceMap(List<Province> provinceList){
        this.provinces = provinceList;
    }

    public ProvinceMap(List<Province> provinceList, Document datamodel){
        this(provinceList);
        this.datamodel = datamodel;
    }

    public Province getProvince(Color colorId){
        for(Province province : provinces){
            if(province.getProvinceColorId().equals(colorId)){
                return province;
            }
        }
        return null;
    }

    public boolean containsPoint(Point p){
        for(Province province : provinces){
            if(province.getPointList().contains(p)){
                return true;
            }
        }
        return false;
    }
}
