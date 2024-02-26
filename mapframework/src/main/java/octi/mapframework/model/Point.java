package octi.mapframework.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Point {
    private final int x;
    private final int y;

    public Point(float x, float y){
        this((int) x, (int) y);
    }

    public Point(String coordinates){
        String[] sCoords = coordinates.split(",");
        x = Integer.parseInt(sCoords[0].trim());
        y = Integer.parseInt(sCoords[1].trim());
    }
}
