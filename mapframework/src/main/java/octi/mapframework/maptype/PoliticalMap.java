package octi.mapframework.maptype;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import octi.mapframework.maptype.actions.MapClick;
import octi.mapframework.maptype.actions.MapHover;
import octi.mapframework.model.Point;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;
import octi.mapframework.util.ColorUtils;
import org.dom4j.Node;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

public class PoliticalMap implements MapType, MapClick, MapHover {

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
    public ProvinceMap clickColor(ProvinceMap provinceMap, Point clickPoint) {
        for (Province province : provinceMap.getProvinces()){
            if(province.getPointList().contains(clickPoint)){

                if(nonNull(provinceMap.getClickedProvinceId())){

                    if(provinceMap.getClickedProvinceId().equals(province.getProvinceColorId())){
                        //We click again the already selected province.
                        Gdx.app.log("DEBUG", "Clicked the same province.");
                        return provinceMap;
                    }else{
                        //Recolor the old province back.
                        Gdx.app.log("DEBUG", "Recolor the old province.");
                        Province oldProvince = provinceMap.getProvince(provinceMap.getClickedProvinceId());
                        Node node = provinceMap.getDatamodel().selectSingleNode(String.format("//map//province[@id='%s']", oldProvince.getId()));
                        String owner = node.valueOf("ownerId");
                        Color originalColor = ColorUtils.parseColor(owner);
                        oldProvince.setProvinceColor(originalColor);
                    }
                }

                provinceMap.setClickedProvinceId(province.getProvinceColorId());

                //Color with click color;
                Gdx.app.log("DEBUG", "Coloring the clicked province");
                Color originalColor = province.getProvinceColor();
                Color clickColor = originalColor.add(0.40f, 0.40f, 0.40f, 0f);
                province.setProvinceColor(clickColor);
            }
        }
        return provinceMap;
    }

    @Override
    public ProvinceMap hoverColor(ProvinceMap provinceMap, Point clickPoint) {
        for (Province province : provinceMap.getProvinces()){
            if(province.getPointList().contains(clickPoint)){
                Color originalColor = province.getProvinceColor();
                Color hoverColor = originalColor.add(0.01f, 0.01f, 0.01f, 0f);
                province.setProvinceColor(hoverColor);
            }
        }
        return provinceMap;
    }
}
