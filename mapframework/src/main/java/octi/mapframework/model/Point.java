package octi.mapframework.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class Point {
    @Getter
    private final int x;
    @Getter
    private final int y;

    public Point(float x, float y){
        this((int) x, (int) y);
    }
}
