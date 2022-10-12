package octi.mapframework;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import octi.mapframework.maptype.MapType;
import octi.mapframework.maptype.actions.MapClick;
import octi.mapframework.model.Point;
import octi.mapframework.model.ProvinceMap;
import octi.mapframework.pixmap.ProvincePixmap;
import org.dom4j.Document;

public class MapCreator {

    private final ProvincePixmap pixmap;
    private final ProvinceMap provinceMap;

    public MapCreator(FileHandle fh){
        this.pixmap = new ProvincePixmap(fh);
        provinceMap = pixmap.getProvinceMap();
    }

    public MapCreator(FileHandle fh, Document datamodel){
        this.pixmap = new ProvincePixmap(fh, datamodel);
        provinceMap = pixmap.getProvinceMap();
    }

    public Texture generateMap(MapType mapType){
        ProvinceMap pm = mapType.generateMap(provinceMap.getProvinces());
        pixmap.updateProvinces(pm);
        return new Texture(pixmap);
    }

    public Texture generateMapClick(MapClick mapType, Point clickPoint){
        ProvinceMap pm = mapType.clickColor(provinceMap.getProvinces(), clickPoint);
        pixmap.updateProvinces(pm);
        return new Texture(pixmap);
    }
}
