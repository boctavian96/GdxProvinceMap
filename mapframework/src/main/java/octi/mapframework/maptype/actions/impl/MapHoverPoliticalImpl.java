package octi.mapframework.maptype.actions.impl;

import com.badlogic.gdx.graphics.Color;
import octi.mapframework.maptype.actions.MapHover;
import octi.mapframework.model.Point;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;
import octi.mapframework.util.ColorUtils;
import org.dom4j.Node;

import static java.util.Objects.nonNull;

public class MapHoverPoliticalImpl implements MapHover {
    @Override
    public ProvinceMap hoverColor(ProvinceMap provinceMap, Point clickPoint) {
        for (Province province : provinceMap.getProvinces()){
            if(province.getPointList().contains(clickPoint)){

                if(nonNull(provinceMap.getClickedProvinceId())){

                    if(provinceMap.getClickedProvinceId().equals(province.getProvinceColorId())){
                        //We hover again the already selected province.
                        return provinceMap;
                    }else{
                        //Recolor the old province back.
                        Province oldProvince = provinceMap.getProvince(provinceMap.getClickedProvinceId());
                        Node node = provinceMap.getDatamodel().selectSingleNode(String.format("//map//province[@id='%s']", oldProvince.getId()));
                        String owner = node.valueOf("ownerId");
                        Color originalColor = ColorUtils.parseColor(owner);
                        oldProvince.setProvinceColor(originalColor);
                    }
                }

                provinceMap.setClickedProvinceId(province.getProvinceColorId());

                //Color with hover color;
                Color originalColor = province.getProvinceColor();
                Color clickColor = originalColor.add(0.40f, 0.40f, 0.40f, 0f);
                province.setProvinceColor(clickColor);
            }
        }
        return provinceMap;
    }
}
