package octi.mapframework.maptype.actions.impl;

import com.badlogic.gdx.graphics.Color;
import octi.mapframework.maptype.actions.MapHover;
import octi.mapframework.model.Point;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;

import static java.util.Objects.nonNull;

public class BasicMapHoverImpl implements MapHover {

    private Color cachedColor;

    @Override
    public ProvinceMap hoverColor(ProvinceMap provinceMap, Point hoverPoint) {
        for (Province province : provinceMap.getProvinces()){
            if(province.getPointList().contains(hoverPoint)){
                if(nonNull(provinceMap.getClickedProvinceId())){
                    if(provinceMap.getClickedProvinceId().equals(province.getProvinceColorId())){
                        //We click again the already selected province.
                        return provinceMap;
                    }else{
                        //Recolor the old province back.
                        Province oldProvince = provinceMap.getProvince(provinceMap.getClickedProvinceId());
                        oldProvince.setProvinceColor(cachedColor);
                    }
                }
                provinceMap.setClickedProvinceId(province.getProvinceColorId());

                //Color with click color;
                Color originalColor = province.getProvinceColor();
                this.cachedColor = new Color(originalColor);

                Color clickColor = originalColor.add(0.40f, 0.40f, 0.40f, 0f);
                province.setProvinceColor(clickColor);
            }
        }
        return provinceMap;
    }
}
