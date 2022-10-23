package octi.mapframework.label;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import octi.mapframework.model.Point;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.List;

public class ProvinceBitmap extends BitmapFont {
    public GlyphLayout drawProvinceName(Batch batch, String provinceName, Point p){
        return super.draw(batch, provinceName, p.getX(), p.getY());
    }

    public void drawProvinceNames(Batch batch, ProvinceMap provinceMap){
        for(Province p : provinceMap.getProvinces()){
            super.draw(batch, drawProvinceName(batch, p.getName(), p.getCenter()), p.getCenter().getX(), p.getCenter().getY());
        }
    }

    public void drawProvinceNames(Batch batch, Document doc){
        if(doc.selectNodes("//province//center").isEmpty()){
            return;
        }
        List<Node> nodes = doc.selectNodes("//province");

        for(Node n : nodes){
            String coordinates = n.valueOf("center");
            String name = n.valueOf("name");
            Point p = new Point(coordinates);

            super.draw(batch, name, p.getX(), p.getY());
        }
    }
}
