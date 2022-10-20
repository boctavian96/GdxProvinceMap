package octi.mapframework;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import lombok.Getter;
import octi.mapframework.maptype.MapType;
import octi.mapframework.maptype.actions.MapClick;
import octi.mapframework.maptype.actions.MapHover;
import octi.mapframework.model.Point;
import octi.mapframework.model.ProvinceMap;
import octi.mapframework.pixmap.ProvincePixmap;
import org.dom4j.Document;

public class MapCreator {

    private static ProvincePixmap pixmap;
    @Getter
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
        ProvinceMap pm = mapType.generateMap(provinceMap);
        pixmap.updateProvinces(pm);
        return new Texture(pixmap);
    }

    public Texture generateMapClick(MapClick mapType, Point clickPoint){
        ProvinceMap pm = mapType.clickColor(provinceMap, clickPoint);
        pixmap.updateProvinces(pm);
        return new Texture(pixmap);
    }

    public Texture generateMapHover(MapHover mapHover, Point clickPoint){
        ProvinceMap pm = mapHover.hoverColor(provinceMap, clickPoint);
        pixmap.updateProvinces(pm);
        return new Texture(pixmap);
    }
}
