package octi.mapframework.util;

import com.badlogic.gdx.graphics.Color;

public class ColorUtils {
    public static Color parseColor(String[] colorCoordinates){
        float r = Float.parseFloat(colorCoordinates[0]);
        float g = Float.parseFloat(colorCoordinates[1]);
        float b = Float.parseFloat(colorCoordinates[2]);

        if(colorCoordinates.length > 3){
            float a = Float.parseFloat(colorCoordinates[3]);
            return new Color(r, g, b, a);
        }

        return new Color(r, g, b, 1);
    }
}
