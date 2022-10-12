package octi.mapframework.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class Point {
    private final int x;
    private final int y;

    public Point(float x, float y){
        this.x = (int)x;
        this.y = (int)y;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }
}
