package octi.mapframework.model;

import com.badlogic.gdx.graphics.Color;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
public class Province {
    private static final Color emptyColor = Color.GRAY;

    @Getter
    private int id;
    @Getter
    private Color provinceColorId;
    @Getter @Setter
    private Color provinceColor;
    @Getter @Setter
    private List<Point> pointList;
    @Getter @Setter
    private Point center;
    @Getter @Setter
    private String name;

    public Province(int id, Color provinceColorId, List<Point> pointList){
        this(id, provinceColorId, emptyColor, pointList, null, "Generic Name");
    }
}
