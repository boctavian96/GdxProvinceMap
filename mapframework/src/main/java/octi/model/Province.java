package octi.model;

import com.badlogic.gdx.graphics.Color;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
public class Province {
    private static final Color emptyColor = Color.GRAY;

    private int id;
    private Color provinceColorId;
    private Color provinceColor;
    private List<Point> pointList;

    public Province(int id, Color provinceColorId, List<Point> pointList){
        this(id, provinceColorId, emptyColor, pointList);
    }

    public Color getProvinceColorId() {
        return provinceColorId;
    }

    public Color getProvinceColor() {
        return provinceColor;
    }

    public void setProvinceColor(Color provinceColor) {
        this.provinceColor = provinceColor;
    }

    public List<Point> getPointList() {
        return pointList;
    }

}
