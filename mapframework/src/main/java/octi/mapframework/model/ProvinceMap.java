package octi.mapframework.model;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.dom4j.Document;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
public class ProvinceMap {
    @Getter @Setter
    private List<Province> provinces;
    @Getter @Setter
    private Document datamodel;

    public ProvinceMap(List<Province> provinceList){
        this.provinces = provinceList;
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
