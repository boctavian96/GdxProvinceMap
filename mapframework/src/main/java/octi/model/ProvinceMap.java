package octi.model;


import lombok.EqualsAndHashCode;
import org.dom4j.Document;

import java.util.List;

@EqualsAndHashCode
public class ProvinceMap {
    private final List<? extends Province> provinces;
    private Document datamodel;

    public ProvinceMap(List<? extends Province> provinces){
        this.provinces = provinces;
    }
    public List<? extends Province> getProvinces() {
        return provinces;
    }
    public void setDatamodel(Document datamodel){
        this.datamodel = datamodel;
    }
    public Document getDatamodel(){
        return this.datamodel;
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
