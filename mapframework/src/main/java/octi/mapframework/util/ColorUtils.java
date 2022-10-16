package octi.mapframework.util;

import com.badlogic.gdx.graphics.Color;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ColorUtils {
    public static Color parseColor(String[] colorCoordinates){
        float r = convertToColor(Float.parseFloat(colorCoordinates[0]));
        float g = convertToColor(Float.parseFloat(colorCoordinates[1]));
        float b = convertToColor(Float.parseFloat(colorCoordinates[2]));

        if(colorCoordinates.length > 3){
            float a = Float.parseFloat(colorCoordinates[3]);
            return new Color(r, g, b, a);
        }

        return new Color(r, g, b, 1);
    }

    public static Color parseColor(String colorCoordinates){
        String[] colorCoordinatesSplit = colorCoordinates.split(",");
        return parseColor(colorCoordinatesSplit);
    }

    private static float convertToColor(float color){
        return color > 1F ? color/255 : color;
    }
}
