package octi.model;

import com.badlogic.gdx.graphics.Color;

import java.util.List;

public class Province {
    private int id;
    private Color provinceColorId;
    private Color provinceColor;
    private List<Point> pointList;

    public Province(int id, Color provinceColorId, Color provinceColor, List<Point> pointList) {
        this.id = id;
        this.provinceColorId = provinceColorId;
        this.provinceColor = provinceColor;
        this.pointList = pointList;
    }

    public Province(int id, Color provinceColorId, List<Point> pointList){
        this(id, provinceColorId, Color.GRAY, pointList);
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
