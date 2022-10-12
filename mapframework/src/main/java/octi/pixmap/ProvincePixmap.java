package octi.pixmap;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Vector3;
import octi.model.Point;
import octi.model.Province;
import octi.model.ProvinceMap;
import octi.util.Version;
import org.dom4j.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProvincePixmap extends Pixmap {

    private final Set<Color> provinceIds;
    private final List<Province> provinces;
    private final ProvinceMap provinceMap;

    @Version(version = "0.1.1")
    public ProvincePixmap(FileHandle file) {
        super(file);

        this.provinceIds = generateProvinceIds();
        this.provinces = generateProvinces();
        this.provinceMap = new ProvinceMap(provinces);

    }

    public ProvincePixmap(FileHandle file, Document datamodel){
        super(file);
        this.provinceIds = generateProvinceIds();
        this.provinces = generateProvinces();
        this.provinceMap = new ProvinceMap(provinces);
        this.provinceMap.setDatamodel(datamodel);
    }

    private Set<Color> generateProvinceIds(){
        Set<Color> colorSet = new HashSet<>();

        int height = getHeight();
        int width = getWidth();

        for(int x = 0; x<width; x++){
            for(int y = 0; y<height; y++){
                Color c = new Color(getPixel(x, y));

                if(c.equals(Color.BLACK) || c.a == 0){
                    continue;
                }
                colorSet.add(new Color(getPixel(x, y)));
            }
        }

        return colorSet;
    }

    private List<Province> generateProvinces(){
        List<Province> provinces = new ArrayList<>();
        int id = 0;
        for(Color provinceId : provinceIds){
            List<Point> provincePoints = new ArrayList<>();
            for(int x=0; x<getWidth(); x++){
                for(int y=0; y<getHeight(); y++){
                    if(new Color(getPixel(x, y)).equals(provinceId)){
                        provincePoints.add(new Point(x, y));
                    }
                }
            }
            provinces.add(new Province(id, provinceId, provincePoints));
            id++;
        }
        return provinces;
    }

    public void recolorProvince(Color newColor, List<Point> points){
        points.forEach(point ->
            drawPixel(point.getX(), point.getY(), Color.rgba8888(newColor))
        );
    }

    public void recolorProvince(Color newColor, Province province){
        recolorProvince(newColor, province.getPointList());
    }

    public void recolorProvince(Color newColor, int id){
        Province p = provinceMap.getProvinces().get(id);
        p.setProvinceColor(newColor);
        provinces.set(id, p);
    }

    public void updateProvinces(){
        for(Province province : provinceMap.getProvinces()){
            recolorProvince(province.getProvinceColor(), province);
        }
    }

    public void updateProvinces(ProvinceMap provinceMap){
        List<? extends Province> provinces = provinceMap.getProvinces();
        for (Province province: provinces){
            recolorProvince(province.getProvinceColor(), province);
        }
    }

    /**
     * Transform mouse coordinates to texture coordinates.
     * @param mousePosition
     */
    public void transform(Vector3 mousePosition){
        //TODO: Implement me.
        //TODO: Check if this method is fiable.
    }

    public void applyMask(){
        //TODO: Implement me.
    }

    public ProvinceMap getProvinceMap(){
        return this.provinceMap;
    }
}
