package octi.mapframework.label;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import octi.mapframework.model.Point;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;
import org.dom4j.Document;

import java.util.List;

public class MapLabel extends BitmapFont {

    private ILabel labelStrategy;

    public MapLabel(ILabel labelStrategy){
        this.labelStrategy = labelStrategy;
    }


    public GlyphLayout drawProvinceName(Batch batch, String provinceName, Point p){
        return super.draw(batch, provinceName, p.getX(), p.getY());
    }

    public void drawProvinceNames(Batch batch, ProvinceMap provinceMap){
        for(Province p : provinceMap.getProvinces()){
            super.draw(batch, drawProvinceName(batch, p.getName(), p.getCenter()), p.getCenter().getX(), p.getCenter().getY());
        }
    }

    public void drawProvinceLabel(Batch batch, Document doc) {
        List<LabelModel> model = labelStrategy.drawProvinceLabel(batch, doc);

        for(LabelModel m : model){
            super.draw(batch, m.getLabelName(), m.getLabelPosition().getX(), m.getLabelPosition().getY());
        }
    }
}
