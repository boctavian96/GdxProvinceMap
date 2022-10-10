package octi.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Point {
    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }
}
