package test.octi.mapframework;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.sun.tools.javac.util.Assert;
import octi.mapframework.MapCreator;
import octi.mapframework.maptype.PoliticalMap;
import octi.mapframework.xml.XmlLoader;
import org.dom4j.Document;
import org.junit.jupiter.api.Test;

public class MapCreatorTest {

    private static final Document datamodel = XmlLoader.prepareDatamodel("/test/testMap1/mapDatamodel.xml");
    private static final FileHandle mapId = new FileHandle("resources/test/testMap1/mapId.png");

    @Test
    void testMapCreate(){
        //Given
        MapCreator mapCreator = new MapCreator(mapId, datamodel);

        //When
        Texture createdMap = mapCreator.generateMap(new PoliticalMap());

        //Then
        Assert.checkNonNull(createdMap);
    }
}
