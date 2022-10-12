package octi.mapframework.naming;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import octi.mapframework.model.Point;
import octi.mapframework.model.Province;
import octi.mapframework.model.ProvinceMap;

public class ProvinceBitmap extends BitmapFont {
    public GlyphLayout drawProvinceName(Batch batch, String provinceName, Point p){
        return super.draw(batch, provinceName, p.getX(), p.getY());
    }

    public void drawProvinceNames(Batch batch, ProvinceMap provinceMap){
        for(Province p : provinceMap.getProvinces()){
            super.draw(batch, drawProvinceName(batch, p.getName(), p.getCenter()), p.getCenter().getX(), p.getCenter().getY());
        }
    }
}
