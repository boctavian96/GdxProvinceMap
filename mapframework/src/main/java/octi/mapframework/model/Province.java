package octi.mapframework.model;

import com.badlogic.gdx.graphics.Color;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Province {
    private static final Color emptyColor = Color.GRAY;

    private int id;
    private Color provinceColorId;
    @Setter
    private Color provinceColor;
    @Setter
    private List<Point> pointList;
    @Setter
    private Point center;
    @Setter
    private String name;

    public Province(int id, Color provinceColorId, List<Point> pointList){
        this(id, provinceColorId, emptyColor, pointList, null, "Generic Name");
    }
}
